package com.yhj.technological_revolution;

import com.yhj.technological_revolution.blocks.entity.SolarGeneratorBlockEntity;
import com.yhj.technological_revolution.blocks.entity.WindGeneratorBlockEntity;
import com.yhj.technological_revolution.blocks.entity.WaterGeneratorBlockEntity;
import com.yhj.technological_revolution.blocks.entity.NuclearReactorBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = 
        DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TechnologicalRevolution.MOD_ID);
    
    // 注册太阳能发电机方块实体
    public static final RegistryObject<BlockEntityType<SolarGeneratorBlockEntity>> SOLAR_GENERATOR = 
        BLOCK_ENTITIES.register("solar_generator", () -> 
            BlockEntityType.Builder.of(SolarGeneratorBlockEntity::new, 
                ModBlocks.SOLAR_GENERATOR.get()).build(null));
                
    // 注册风力发电机方块实体
    public static final RegistryObject<BlockEntityType<WindGeneratorBlockEntity>> WIND_GENERATOR = 
        BLOCK_ENTITIES.register("wind_generator", () -> 
            BlockEntityType.Builder.of(WindGeneratorBlockEntity::new, 
                ModBlocks.WIND_GENERATOR.get()).build(null));
                
    // 注册水流发电机方块实体
    public static final RegistryObject<BlockEntityType<WaterGeneratorBlockEntity>> WATER_GENERATOR = 
        BLOCK_ENTITIES.register("water_generator", () -> 
            BlockEntityType.Builder.of(WaterGeneratorBlockEntity::new, 
                ModBlocks.WATER_GENERATOR.get()).build(null));
                
    // 注册核反应堆方块实体
    public static final RegistryObject<BlockEntityType<NuclearReactorBlockEntity>> NUCLEAR_REACTOR = 
        BLOCK_ENTITIES.register("nuclear_reactor", () -> 
            BlockEntityType.Builder.of(NuclearReactorBlockEntity::new, 
                ModBlocks.NUCLEAR_REACTOR.get()).build(null));
    
    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
