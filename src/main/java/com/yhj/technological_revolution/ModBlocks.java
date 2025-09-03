package com.yhj.technological_revolution;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TechnologicalRevolution.MOD_ID);
    
    // 示例方块注册
    // public static final RegistryObject<Block> SOLAR_GENERATOR = BLOCKS.register("solar_generator", SolarGeneratorBlock::new);
}
