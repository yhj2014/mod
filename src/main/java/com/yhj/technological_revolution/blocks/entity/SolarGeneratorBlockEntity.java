package com.yhj.technological_revolution.blocks.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import com.yhj.technological_revolution.blocks.SolarGeneratorBlock;

public class SolarGeneratorBlockEntity extends GeneratorBlockEntity {
    private static final int MAX_CAPACITY = 100000; // 最大能量存储
    private static final int GENERATE_RATE = 50;    // 每tick发电量
    
    public SolarGeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state, MAX_CAPACITY, GENERATE_RATE);
    }
    
    @Override
    protected boolean canGenerate() {
        // 检查是否可以发电
        if (level == null) return false;
        
        // 检查是否是白天
        if (level.isDay()) {
            // 检查方块上方是否可以直接看到天空
            if (level.canSeeSky(pos.above())) {
                // 检查是否在最高点（没有被遮挡）
                int highestY = level.getHeight(Heightmap.Types.WORLD_SURFACE, pos.getX(), pos.getZ());
                if (pos.getY() >= highestY - 1) {
                    // 检查能量存储是否已满
                    return energyStorage.getEnergyStored() < energyStorage.getMaxEnergyStored();
                }
            }
        }
        return false;
    }
    
    public static void tick(Level level, BlockPos pos, BlockState state, SolarGeneratorBlockEntity entity) {
        if (level.isClientSide) {
            return;
        }
        
        entity.tick();
        
        // 设置方块状态（是否在发电）
        boolean isGenerating = entity.canGenerate();
        if (state.getValue(SolarGeneratorBlock.GENERATING) != isGenerating) {
            level.setBlock(pos, state.setValue(SolarGeneratorBlock.GENERATING, isGenerating), 3);
        }
    }
}
