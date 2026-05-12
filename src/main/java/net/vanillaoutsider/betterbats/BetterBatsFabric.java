// Verified against: concept_better_bats.md
package net.vanillaoutsider.betterbats;

import net.dasik.social.api.gamerule.DynamicGameRuleManager;
import net.fabricmc.api.ModInitializer;
import net.minecraft.world.level.gamerules.GameRuleCategory;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterBatsFabric implements ModInitializer {
    public static final String MOD_ID = "better-bats";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final GameRuleCategory BETTER_BATS = DynamicGameRuleManager.registerCategory(Identifier.parse("better-bats:better_bats"));

    public static final GameRule<Integer> BAT_SWARM_SIZE = 
            DynamicGameRuleManager.integerRule("better-bats:bat_swarm_size", BETTER_BATS, 5)
                    .name("Bat Swarm Size")
                    .description("Maximum number of bats allowed in a single flock.")
                    .register();
                    
    public static final GameRule<Integer> BAT_GUANO_THRESHOLD = 
            DynamicGameRuleManager.integerRule("better-bats:bat_guano_threshold", BETTER_BATS, 12000)
                    .name("Guano Production Speed")
                    .description("Ticks required for a resting bat to produce guano (Lower is faster).")
                    .register();
                    
    public static final GameRule<Boolean> BAT_PEST_CONTROL = 
            DynamicGameRuleManager.booleanRule("better-bats:bat_pest_control", BETTER_BATS, true)
                    .name("Enable Pest Control")
                    .description("If true, bats will hunt silverfish and endermites.")
                    .register();

    // Boids Weights (New in DasikLibrary 1.7.0)
    public static final GameRule<Integer> BAT_ALIGNMENT = 
            DynamicGameRuleManager.integerRule("better-bats:bat_alignment", BETTER_BATS, 5)
                    .name("Bat Alignment Weight")
                    .description("How strongly bats align their flight direction with the swarm (0-100). Default: 5")
                    .range(0, 100)
                    .register();

    public static final GameRule<Integer> BAT_COHESION = 
            DynamicGameRuleManager.integerRule("better-bats:bat_cohesion", BETTER_BATS, 5)
                    .name("Bat Cohesion Weight")
                    .description("How strongly bats are pulled towards the center of the swarm (0-100). Default: 5")
                    .range(0, 100)
                    .register();

    public static final GameRule<Integer> BAT_SEPARATION = 
            DynamicGameRuleManager.integerRule("better-bats:bat_separation", BETTER_BATS, 10)
                    .name("Bat Separation Weight")
                    .description("How strongly bats avoid colliding with each other (0-100). Default: 10")
                    .range(0, 100)
                    .register();

    @Override
    public void onInitialize() {
        LOGGER.info("Better Bats: Chioptera Enhancements Initialized (v1.1.1+build.1)");
    }
}
