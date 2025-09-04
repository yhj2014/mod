package com.yhj.technological_revolution.blocks.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import com.yhj.technological_revolution.energy.ForgeEnergyStorage;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class GeneratorBlockEntity extends BlockEntity {
    protected ForgeEnergyStorage energyStorage;
    protected LazyOptional<IEnergyStorage> energyStorageLazyOptional;
    
    // 发电量(每tick)
    protected int energyGenerateRate;
    
    // 发电冷却时间
    protected int cooldown;
    
    public GeneratorBlockEntity(BlockPos pos, BlockState state, int energyCapacity, int energyGenerateRate) {
        super(ModBlockEntities.GENERATOR.get(), pos, state);
        this.energyStorage = new ForgeEnergyStorage(energyCapacity, 0, energyCapacity);
        this.energyStorageLazyOptional = LazyOptional.of(() -> this.energyStorage);
        this.energyGenerateRate = energyGenerateRate;
        this.cooldown = 0;
    }
    
    public void tick() {
        if (level == null || level.isClientSide) {
            return;
        }
        
        // 冷却时间减1
        if (cooldown > 0) {
            cooldown--;
            return;
        }
        
        // 检查是否可以发电(子类实现)
        if (canGenerate()) {
            // 发电
            generateEnergy();
        }
    }
    
    protected boolean canGenerate() {
        // 基础实现，子类可以重写
        return energyStorage.getEnergyStored() < energyStorage.getMaxEnergyStored();
    }
    
    protected void generateEnergy() {
        // 向能量存储中添加能量
        if (energyStorage.getEnergyStored() + energyGenerateRate <= energyStorage.getMaxEnergyStored()) {
            energyStorage.setEnergy(energyStorage.getEnergyStored() + energyGenerateRate);
            setChanged();
        } else {
            // 如果不能完全添加，就添加到最大值
            energyStorage.setEnergy(energyStorage.getMaxEnergyStored());
            setChanged();
        }
    }
    
    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        if (tag.contains("energy")) {
            energyStorage.setEnergy(tag.getInt("energy"));
        }
        if (tag.contains("cooldown")) {
            cooldown = tag.getInt("cooldown");
        }
    }
    
    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("energy", energyStorage.getEnergyStored());
        tag.putInt("cooldown", cooldown);
    }
    
    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable net.minecraft.core.Direction side) {
        if (cap == ForgeCapabilities.ENERGY) {
            return energyStorageLazyOptional.cast();
        }
        return super.getCapability(cap, side);
    }
    
    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        energyStorageLazyOptional.invalidate();
    }
}
