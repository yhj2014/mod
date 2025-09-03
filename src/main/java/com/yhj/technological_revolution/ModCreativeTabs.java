package com.yhj.technological_revolution;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(ForgeRegistries.CREATIVE_MODE_TABS, TechnologicalRevolution.MOD_ID);
    
    // 示例创造模式物品栏注册
    // public static final RegistryObject<CreativeModeTab> TECHNOLOGICAL_REVOLUTION_TAB = CREATIVE_TABS.register("technological_revolution_tab", 
    //     () -> CreativeModeTab.builder()
    //         .title(Component.translatable("itemGroup.technological_revolution"))
    //         .icon(() -> new ItemStack(ModBlocks.SOLAR_GENERATOR.get()))
    //         .displayItems((params, output) -> {
    //             // 在这里添加要显示在创造模式物品栏中的物品
    //             // output.accept(ModItems.ENERGY_PICKAXE.get());
    //             // output.accept(ModBlocks.SOLAR_GENERATOR.get());
    //         })
    //         .build());
            
    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }
}
