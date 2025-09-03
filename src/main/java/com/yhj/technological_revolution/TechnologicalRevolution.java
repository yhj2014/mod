package com.yhj.technological_revolution;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("technological_revolution")
public class TechnologicalRevolution {
    public static final String MOD_ID = "technological_revolution";
    public static final Logger LOGGER = LogManager.getLogger();

    public TechnologicalRevolution() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("Initializing Technological Revolution mod");
    }
}
