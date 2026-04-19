package net.vanillaoutsider.betterbats.ai;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class BatHuntLightGoal extends Goal {
    private final Bat bat;
    private BlockPos targetLight;
    private int circlingTicks;

    public BatHuntLightGoal(Bat bat) {
        this.bat = bat;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        if (this.bat.isResting() || this.bat.getRandom().nextInt(40) != 0) {
            return false;
        }
        Level level = this.bat.level();
        if (level.isClientSide()) return false;
        
        BlockPos pos = this.bat.blockPosition();
        if (level.getBrightness(LightLayer.BLOCK, pos) > 12) {
            this.targetLight = pos;
            return true;
        }
        
        for (int i = 0; i < 10; i++) {
            BlockPos checkPos = pos.offset(this.bat.getRandom().nextInt(16) - 8, this.bat.getRandom().nextInt(8) - 4, this.bat.getRandom().nextInt(16) - 8);
            if (level.getBrightness(LightLayer.BLOCK, checkPos) > 12) {
                this.targetLight = checkPos;
                return true;
            }
        }
        return false;
    }

    @Override
    public void start() {
        this.circlingTicks = 0;
        if (this.bat instanceof net.dasik.social.api.group.GroupMember gm) {
            gm.setLeader(null); 
        }
    }

    @Override
    public boolean canContinueToUse() {
        return this.targetLight != null && this.circlingTicks < 200 && !this.bat.isResting() && this.bat.level().getBrightness(LightLayer.BLOCK, this.targetLight) > 12;
    }

    @Override
    public void stop() {
        this.targetLight = null;
    }

    @Override
    public void tick() {
        this.circlingTicks++;
        if (this.targetLight != null) {
            Vec3 targetVec = this.targetLight.getCenter();
            Vec3 dir = targetVec.subtract(this.bat.position());
            
            double dist = dir.length();
            if (dist > 1.5) {
                this.bat.setDeltaMovement(this.bat.getDeltaMovement().add(dir.normalize().scale(0.05)));
            } else {
                Vec3 cross = dir.cross(new Vec3(0, 1, 0)).normalize().scale(0.1);
                this.bat.setDeltaMovement(this.bat.getDeltaMovement().add(cross).scale(0.9));
                
                if (this.bat.getRandom().nextInt(10) == 0 && this.bat.level() instanceof ServerLevel sl) {
                    sl.sendParticles(net.minecraft.core.particles.ParticleTypes.CRIT, this.bat.getX(), this.bat.getY(), this.bat.getZ(), 3, 0.2, 0.2, 0.2, 0.05);
                }
            }
        }
    }
}
