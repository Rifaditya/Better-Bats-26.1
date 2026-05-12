package net.vanillaoutsider.betterbats.ai;

import net.dasik.social.ai.goal.FollowLeaderGoal;
import net.dasik.social.api.group.strategy.GroupParameters;
import net.dasik.social.api.gamerule.DynamicGameRuleManager;
import net.minecraft.world.entity.ambient.Bat;
import net.vanillaoutsider.betterbats.BetterBatsFabric;

/**
 * Custom FollowLeaderGoal for Bats that supports dynamic parameter tuning via GameRules.
 */
public class BatFollowLeaderGoal extends FollowLeaderGoal<Bat> {
    
    public BatFollowLeaderGoal(Bat mob) {
        // Start with default aerial parameters
        super(mob, GroupParameters.DEFAULT_AERIAL, 16.0);
    }

    @Override
    public void tick() {
        // Periodically sync parameters with GameRules (every 20 ticks to avoid overhead)
        if (this.mob.tickCount % 20 == 0 && !this.mob.level().isClientSide()) {
            this.syncParameters();
        }
        super.tick();
    }

    private void syncParameters() {
        int alignment = DynamicGameRuleManager.getInt(this.mob.level(), BetterBatsFabric.BAT_ALIGNMENT);
        int cohesion = DynamicGameRuleManager.getInt(this.mob.level(), BetterBatsFabric.BAT_COHESION);
        int separation = DynamicGameRuleManager.getInt(this.mob.level(), BetterBatsFabric.BAT_SEPARATION);

        // Update the goal's parameters with new Boids weights
        // Formula: RuleValue * 0.01f (e.g., 5 -> 0.05f)
        this.setParameters(new GroupParameters(
            3.0f,   // cohesionRadius
            1.0f,   // separationRadius
            0.4f,   // maxSpeed
            true,   // canTeleport
            144.0f, // teleportDistance
            6.0f,   // startDistance
            2.0f,   // stopDistance
            alignment * 0.01f,
            cohesion * 0.01f,
            separation * 0.01f
        ));
    }
}
