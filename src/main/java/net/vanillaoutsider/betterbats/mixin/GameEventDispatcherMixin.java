package net.vanillaoutsider.betterbats.mixin;

import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEventDispatcher;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(GameEventDispatcher.class)
public abstract class GameEventDispatcherMixin {
    @Shadow @Final private ServerLevel level;

    @Inject(method = "post", at = @At("HEAD"))
    private void betterbats$onGameEvent(Holder<GameEvent> gameEvent, Vec3 position, GameEvent.Context context, CallbackInfo ci) {
        if (gameEvent == GameEvent.EXPLODE || gameEvent == GameEvent.BLOCK_DESTROY || gameEvent == GameEvent.STEP) {
            List<Bat> bats = this.level.getEntitiesOfClass(Bat.class, new AABB(position, position).inflate(16.0));
            for (Bat bat : bats) {
                if (bat.isResting()) {
                    bat.setResting(false);
                    // Scatter logic - just un-resting will make FollowLeaderGoal take over
                    // Or erratic vanilla flight if no leader
                }
            }
        }
    }
}
