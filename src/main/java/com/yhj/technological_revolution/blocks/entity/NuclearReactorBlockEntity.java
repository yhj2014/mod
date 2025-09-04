package com.yhj.technological_revolution.blocks.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import com.yhj.technological_revolution.blocks.NuclearReactorBlock;

public class NuclearReactorBlockEntity extends GeneratorBlockEntity {
    private static final int MAX_CAPACITY = 1000000; // 最大能量存储
    private static final int GENERATE_RATE = 500;    // 每tick发电量
    private static final int HEAT_GENERATION = 10;   // 每tick产生热量
    private static final int MAX_HEAT = 1000;        // 最大热量
    
    private int heat;           // 当前热量
    private int fuelTime;       // 燃料剩余时间
    private boolean active;     // 是否激活
    
    public NuclearReactorBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state, MAX_CAPACITY, GENERATE_RATE);
        this.heat = 0;
        this.fuelTime = 0;
        this.active = false;
    }
    
    @Override
    protected boolean canGenerate() {
        // 检查是否可以发电
        if (level == null) return false;
        
        // 检查是否有燃料
        if (fuelTime > 0) {
            // 检查能量存储是否已满
            return energyStorage.getEnergyStored() < energyStorage.getMaxEnergyStored();
        }
        return false;
    }
    
    @Override
    protected void generateEnergy() {
        // 核反应堆发电逻辑
        if (fuelTime > 0) {
            // 减少燃料时间
            fuelTime--;
            
            // 增加热量
            heat += HEAT_GENERATION;
            
            // 如果热量过高，有爆炸风险
            if (heat > MAX_HEAT * 0.9) {
                // TODO: 实现爆炸逻辑
            }
            
            // 发电
            if (energyStorage.getEnergyStored() + energyGenerateRate <= energyStorage.getMaxEnergyStored()) {
                energyStorage.setEnergy(energyStorage.getEnergyStored() + energyGenerateRate);
                setChanged();
            } else {
                energyStorage.setEnergy(energyStorage.getMaxEnergyStored());
                setChanged();
            }
        }
    }
    
    public void addFuel(int fuelTicks) {
        // 添加燃料
        this.fuelTime += fuelTicks;
        this.active = true;
        setChanged();
    }
    
    public void coolDown(int coolingAmount) {
        // 冷却反应堆
        this.heat = Math.max(0, this.heat - coolingAmount);
        setChanged();
    }
    
    public int getHeat() {
        return heat;
    }
    
    public int getFuelTime() {
        return fuelTime;
    }
    
    public boolean isActive() {
        return active;
    }
    
    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        if (tag.contains("heat")) {
            heat = tag.getInt("heat");
        }
        if (tag.contains("fuelTime")) {
            fuelTime = tag.getInt("fuelTime");
        }
        if (tag.contains("active")) {
            active = tag.getBoolean("active");
        }
    }
    
    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("heat", heat);
        tag.putInt("fuelTime", fuelTime);
        tag.putBoolean("active", active);
    }
    
    public static void tick(Level level, BlockPos pos, BlockState state, NuclearReactorBlockEntity entity) {
        if (level.isClientSide) {
            return;
        }
        
        entity.tick();
        
        // 设置方块状态（是否在发电）
        boolean isGenerating = entity.canGenerate();
        if (state.getValue(NuclearReactorBlock.GENERATING) != isGenerating) {
            level.setBlock(pos, state.setValue(NuclearReactorBlock.GENERATING, isGenerating), 3);
        }
        
        // 如果燃料用完，设置为非激活状态
        if (entity.fuelTime <= 0 && entity.active) {
            entity.active = false;
            level.setBlock(pos, state.setValue(NuclearReactorBlock.ACTIVE, false), 3);
        }
    }
}
