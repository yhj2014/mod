package com.yhj.technological_revolution.blocks.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import com.yhj.technological_revolution.blocks.WaterGeneratorBlock;

public class WaterGeneratorBlockEntity extends GeneratorBlockEntity {
    private static final int MAX_CAPACITY = 60000; // 最大能量存储
    private static final int GENERATE_RATE = 30;    // 每tick发电量
    
    public WaterGeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state, MAX_CAPACITY, GENERATE_RATE);
    }
    
    @Override
    protected boolean canGenerate() {
        // 检查是否可以发电
        if (level == null) return false;
        
        // 检查周围是否有水
        if (isWaterAdjacent()) {
            // 检查能量存储是否已满
            return energyStorage.getEnergyStored() < energyStorage.getMaxEnergyStored();
        }
        return false;
    }
    
    private boolean isWaterAdjacent() {
        // 检查六个方向是否有水
        return level.getBlockState(pos.above()).getBlock() == Blocks.WATER ||
               level.getBlockState(pos.below()).getBlock() == Blocks.WATER ||
               level.getBlockState(pos.north()).getBlock() == Blocks.WATER ||
               level.getBlockState(pos.south()).getBlock() == Blocks.WATER ||
               level.getBlockState(pos.west()).getBlock() == Blocks.WATER ||
               level.getBlockState(pos.east()).getBlock() == Blocks.WATER;
    }
    
    public static void tick(Level level, BlockPos pos, BlockState state, WaterGeneratorBlockEntity entity) {
        if (level.isClientSide) {
            return;
        }
        
        entity.tick();
        
        // 设置方块状态（是否在发电）
        boolean isGenerating = entity.canGenerate();
        if (state.getValue(WaterGeneratorBlock.GENERATING) != isGenerating) {
            level.setBlock(pos, state.setValue(WaterGeneratorBlock.GENERATING, isGenerating), 3);
        }
    }
}
