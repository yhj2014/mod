package com.yhj.technological_revolution;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.BlockItem;
import com.yhj.technological_revolution.items.EnergyPickaxeItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TechnologicalRevolution.MOD_ID);
    
    // 方块物品注册
    public static final RegistryObject<Item> SOLAR_GENERATOR_ITEM = ITEMS.register("solar_generator", 
        () -> new BlockItem(ModBlocks.SOLAR_GENERATOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> WIND_GENERATOR_ITEM = ITEMS.register("wind_generator", 
        () -> new BlockItem(ModBlocks.WIND_GENERATOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> WATER_GENERATOR_ITEM = ITEMS.register("water_generator", 
        () -> new BlockItem(ModBlocks.WATER_GENERATOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> NUCLEAR_REACTOR_ITEM = ITEMS.register("nuclear_reactor", 
        () -> new BlockItem(ModBlocks.NUCLEAR_REACTOR.get(), new Item.Properties()));
    
    public static final RegistryObject<Item> ORE_CRUSHER_ITEM = ITEMS.register("ore_crusher", 
        () -> new BlockItem(ModBlocks.ORE_CRUSHER.get(), new Item.Properties()));
    public static final RegistryObject<Item> ADVANCED_FURNACE_ITEM = ITEMS.register("advanced_furnace", 
        () -> new BlockItem(ModBlocks.ADVANCED_FURNACE.get(), new Item.Properties()));
    public static final RegistryObject<Item> AUTO_FARM_ITEM = ITEMS.register("auto_farm", 
        () -> new BlockItem(ModBlocks.AUTO_FARM.get(), new Item.Properties()));
    public static final RegistryObject<Item> AUTO_MINER_ITEM = ITEMS.register("auto_miner", 
        () -> new BlockItem(ModBlocks.AUTO_MINER.get(), new Item.Properties()));
    
    public static final RegistryObject<Item> ENERGY_CONVERTER_ITEM = ITEMS.register("energy_converter", 
        () -> new BlockItem(ModBlocks.ENERGY_CONVERTER.get(), new Item.Properties()));
    public static final RegistryObject<Item> ENERGY_STORAGE_ITEM = ITEMS.register("energy_storage", 
        () -> new BlockItem(ModBlocks.ENERGY_STORAGE.get(), new Item.Properties()));
    
    public static final RegistryObject<Item> COPPER_WIRE_ITEM = ITEMS.register("copper_wire", 
        () -> new BlockItem(ModBlocks.COPPER_WIRE.get(), new Item.Properties()));
    public static final RegistryObject<Item> GOLD_WIRE_ITEM = ITEMS.register("gold_wire", 
        () -> new BlockItem(ModBlocks.GOLD_WIRE.get(), new Item.Properties()));
    
    // 矿石物品注册
    public static final RegistryObject<Item> URANIUM_ORE_ITEM = ITEMS.register("uranium_ore", 
        () -> new BlockItem(ModBlocks.URANIUM_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> LITHIUM_ORE_ITEM = ITEMS.register("lithium_ore", 
        () -> new BlockItem(ModBlocks.LITHIUM_ORE.get(), new Item.Properties()));
    
    // 特殊物品注册
    public static final RegistryObject<Item> ENERGY_PICKAXE = ITEMS.register("energy_pickaxe", 
        () -> new EnergyPickaxeItem());
}
