package com.yhj.technological_revolution;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.yhj.technological_revolution.blocks.*;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TechnologicalRevolution.MOD_ID);
    
    // 发电机方块
    public static final RegistryObject<Block> SOLAR_GENERATOR = BLOCKS.register("solar_generator", 
        () -> new SolarGeneratorBlock(Block.Properties.of(Material.METAL).strength(3.0F, 3.0F)));
    public static final RegistryObject<Block> WIND_GENERATOR = BLOCKS.register("wind_generator", 
        () -> new WindGeneratorBlock(Block.Properties.of(Material.METAL).strength(3.0F, 3.0F)));
    public static final RegistryObject<Block> WATER_GENERATOR = BLOCKS.register("water_generator", 
        () -> new WaterGeneratorBlock(Block.Properties.of(Material.METAL).strength(3.0F, 3.0F)));
    public static final RegistryObject<Block> NUCLEAR_REACTOR = BLOCKS.register("nuclear_reactor", 
        () -> new NuclearReactorBlock(Block.Properties.of(Material.METAL).strength(5.0F, 6.0F)));
    
    // 机器方块
    public static final RegistryObject<Block> ORE_CRUSHER = BLOCKS.register("ore_crusher", 
        () -> new OreCrusherBlock(Block.Properties.of(Material.METAL).strength(3.0F, 3.0F)));
    public static final RegistryObject<Block> ADVANCED_FURNACE = BLOCKS.register("advanced_furnace", 
        () -> new AdvancedFurnaceBlock(Block.Properties.of(Material.METAL).strength(3.0F, 3.0F)));
    public static final RegistryObject<Block> AUTO_FARM = BLOCKS.register("auto_farm", 
        () -> new AutoFarmBlock(Block.Properties.of(Material.METAL).strength(3.0F, 3.0F)));
    public static final RegistryObject<Block> AUTO_MINER = BLOCKS.register("auto_miner", 
        () -> new AutoMinerBlock(Block.Properties.of(Material.METAL).strength(3.0F, 3.0F)));
    
    // 能源方块
    public static final RegistryObject<Block> ENERGY_CONVERTER = BLOCKS.register("energy_converter", 
        () -> new EnergyConverterBlock(Block.Properties.of(Material.METAL).strength(3.0F, 3.0F)));
    public static final RegistryObject<Block> ENERGY_STORAGE = BLOCKS.register("energy_storage", 
        () -> new EnergyStorageBlock(Block.Properties.of(Material.METAL).strength(3.0F, 3.0F)));
    
    // 电线方块
    public static final RegistryObject<Block> COPPER_WIRE = BLOCKS.register("copper_wire", 
        () -> new CopperWireBlock(Block.Properties.of(Material.METAL).strength(1.0F, 1.0F)));
    public static final RegistryObject<Block> GOLD_WIRE = BLOCKS.register("gold_wire", 
        () -> new GoldWireBlock(Block.Properties.of(Material.METAL).strength(1.0F, 1.0F)));
    
    // 矿石方块
    public static final RegistryObject<Block> URANIUM_ORE = BLOCKS.register("uranium_ore", 
        () -> new UraniumOreBlock(Block.Properties.of(Material.STONE).strength(3.0F, 3.0F)));
    public static final RegistryObject<Block> LITHIUM_ORE = BLOCKS.register("lithium_ore", 
        () -> new LithiumOreBlock(Block.Properties.of(Material.STONE).strength(3.0F, 3.0F)));
}
