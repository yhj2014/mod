package com.yhj.technological_revolution.blocks.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import com.yhj.technological_revolution.blocks.WindGeneratorBlock;

public class WindGeneratorBlockEntity extends GeneratorBlockEntity {
    private static final int MAX_CAPACITY = 80000; // 最大能量存储
    private static final int GENERATE_RATE = 40;    // 每tick发电量
    
    public WindGeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state, MAX_CAPACITY, GENERATE_RATE);
    }
    
    @Override
    protected boolean canGenerate() {
        // 检查是否可以发电
        if (level == null) return false;
        
        // 检查是否在足够高的位置
        if (pos.getY() >= 64) {
            // 检查是否在露天位置（上方没有方块阻挡）
            if (level.isEmptyBlock(pos.above())) {
                // 检查能量存储是否已满
                return energyStorage.getEnergyStored() < energyStorage.getMaxEnergyStored();
            }
        }
        return false;
    }
    
    public static void tick(Level level, BlockPos pos, BlockState state, WindGeneratorBlockEntity entity) {
        if (level.isClientSide) {
            return;
        }
        
        entity.tick();
        
        // 设置方块状态（是否在发电）
        boolean isGenerating = entity.canGenerate();
        if (state.getValue(WindGeneratorBlock.GENERATING) != isGenerating) {
            level.setBlock(pos, state.setValue(WindGeneratorBlock.GENERATING, isGenerating), 3);
        }
    }
}
