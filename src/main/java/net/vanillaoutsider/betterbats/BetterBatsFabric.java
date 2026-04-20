// Verified against: concept_better_bats.md
package net.vanillaoutsider.betterbats;

import net.fabricmc.api.ModInitializer;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.level.gamerules.GameRuleCategory;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterBatsFabric implements ModInitializer {
    public static final String MOD_ID = "better-bats";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final GameRuleCategory BETTER_BATS = GameRuleCategory.register(Identifier.parse("better-bats:better_bats"));

    public static final GameRule<Integer> BAT_SWARM_SIZE = 
            GameRuleHelper.registerInteger("batSwarmSize", BETTER_BATS, 5);
    public static final GameRule<Integer> BAT_GUANO_THRESHOLD = 
            GameRuleHelper.registerInteger("batGuanoThreshold", BETTER_BATS, 12000);
    public static final GameRule<Boolean> BAT_PEST_CONTROL = 
            GameRuleHelper.registerBoolean("batPestControl", BETTER_BATS, true);

    @Override
    public void onInitialize() {
        LOGGER.info("Better Bats: Chioptera Enhancements Initialized");
    }
}
