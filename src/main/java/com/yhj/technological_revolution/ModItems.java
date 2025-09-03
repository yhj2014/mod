package com.yhj.technological_revolution;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TechnologicalRevolution.MOD_ID);
    
    // 示例物品注册
    // public static final RegistryObject<Item> ENERGY_PICKAXE = ITEMS.register("energy_pickaxe", EnergyPickaxeItem::new);
}
