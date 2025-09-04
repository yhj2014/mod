package com.yhj.technological_revolution.items;

import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.TierSortingRegistry;
import java.util.List;

import com.yhj.technological_revolution.energy.ForgeEnergyStorage;

public class EnergyPickaxeItem extends PickaxeItem {
    private final ForgeEnergyStorage energyStorage;
    
    public EnergyPickaxeItem() {
        super(TierSortingRegistry.getSortedTiers().stream().findFirst().get(), 1, -2.8F, new Item.Properties());
        this.energyStorage = new ForgeEnergyStorage(10000, 1000);
    }
    
    @Override
    public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity entity) {
        if (energyStorage.getEnergyStored() >= 100) {
            energyStorage.extractEnergy(100, false);
            return super.mineBlock(stack, world, state, pos, entity);
        }
        return false;
    }
    
    @Override
    public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.literal("Energy: " + energyStorage.getEnergyStored() + "/" + energyStorage.getMaxEnergyStored() + " FE"));
        super.appendHoverText(stack, world, tooltip, flag);
    }
    
    public ForgeEnergyStorage getEnergyStorage() {
        return energyStorage;
    }
}
