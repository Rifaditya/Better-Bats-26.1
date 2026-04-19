package net.vanillaoutsider.betterbats;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterBatsFabric implements ModInitializer {
    public static final String MOD_ID = "better-bats";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Better Bats: Chioptera Enhancements Initialized");
    }
}
