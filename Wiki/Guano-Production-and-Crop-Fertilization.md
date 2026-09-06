# 🌱 Guano Production & Farmland Crop Fertilization

| Parameter | Specification Details |
|---|---|
| **NBT Persistence Tag** | `betterbats:guano_ticks` (Integer) |
| **Default Timer Threshold** | `12000 ticks` ($600\text{ seconds} / 10\text{ minutes}$) |
| **Speed GameRule Key** | `better-bats:bat_guano_threshold` |
| **Item Drop GameRule Key** | `better-bats:bat_drop_guano_item` (Default: `false`) |
| **Crop Target Interface** | `net.minecraft.world.level.block.BonemealableBlock` |
| **Farmland Search Depth** | Up to `20 blocks` vertically below roost position |
| **Fertilizer Particles** | `HAPPY_VILLAGER` (Crop growth) / `MYCELIUM` (Soil drop) |
| **Item Entity Drop** | `minecraft:bone_meal` (When item drop enabled) |

---

## 🎮 Player Workflow: Creating an Automated Bat Fertilizer Farm

1. **Building the Aviary / Roost**: Build a dark room or cave with ceiling fixtures (chains, pointed dripstone, lanterns) positioned up to 20 blocks directly above hydrated farmland crops (wheat, carrots, potatoes, beetroots).
2. **Attracting Bats**: Ensure the ceiling has zero sky light and block light $\le 7$ so bats roost quietly during the day.
3. **Automated Growth**: Every 10 minutes (by default), resting bats drop natural guano downwards. When the raycast strikes a valid crop, it triggers bonemeal growth accompanied by green sparkles (`HAPPY_VILLAGER`) and bone meal audio.
4. **Physical Bone Meal Harvester**:
   - By default, bats only fertilize live crops.
   - Enabling `/betterbats set bat_drop_guano_item true` causes bats resting over non-crop surfaces or fully grown crops to drop physical `Bone Meal` item entities that can be collected via hopper minecarts or water streams.
5. **Adjusting Production Speed**:
   - Accelerate fertilization for modpacks or survival: `/betterbats set bat_guano_threshold 2400` (every 2 minutes).

---

## ⌛ Guano Accumulation Flow

```
                  ┌────────────────────────┐
                  │     Bat is Resting     │
                  └───────────┬────────────┘
                              │
                    guano_ticks++ (per tick)
                              │
                 guano_ticks >= threshold?
                     ┌────────┴────────┐
                    YES                NO
                     │                 │
           Scan up to 20 blocks        Wait for next tick
           down for farmland/crops
                     │
         ┌───────────┴───────────┐
      Crop Found?             Soil / Block Only?
         │                       │
 🌾 Bonemeal Crop         ✨ Spawn Mycelium particles
 ✨ Spawn Happy Villager   📦 Drop Bone Meal Item
    particles                 (If bat_drop_guano_item is true)
```

$$\text{Guano Progress} = \frac{\text{guano\_ticks}}{\text{bat\_guano\_threshold}} \times 100\%$$

---

## 🌾 Farmland Crop Bonemealing Logic

The vertical raycast evaluates down to 20 blocks below the bat's position:

```java
for (int i = 1; i < 20; i++) {
    BlockPos target = pos.below(i);
    BlockState state = level.getBlockState(target);
    if (!state.isAir()) {
        if (state.getBlock() instanceof FarmlandBlock) {
            BlockPos cropPos = target.above();
            BlockState cropState = level.getBlockState(cropPos);
            if (cropState.getBlock() instanceof BonemealableBlock crop) {
                if (crop.isValidBonemealTarget(level, cropPos, cropState)) {
                    crop.performBonemeal(level, level.getRandom(), cropPos, cropState);
                    level.levelEvent(2005, cropPos, 0);
                    level.sendParticles(ParticleTypes.HAPPY_VILLAGER, cropPos.getX() + 0.5, cropPos.getY() + 0.5, cropPos.getZ() + 0.5, 5, 0.2, 0.2, 0.2, 0.05);
                    fertilized = true;
                }
            }
        }
        if (!fertilized) {
            level.sendParticles(ParticleTypes.MYCELIUM, target.getX() + 0.5, target.getY() + 1.0, target.getZ() + 0.5, 3, 0.2, 0.1, 0.2, 0.01);
            if (DynamicGameRuleManager.getBoolean(level, BetterBatsFabric.BAT_DROP_GUANO_ITEM)) {
                ItemEntity itemEntity = new ItemEntity(
                    level,
                    target.getX() + 0.5, target.getY() + 0.8, target.getZ() + 0.5,
                    new ItemStack(Items.BONE_MEAL)
                );
                level.addFreshEntity(itemEntity);
            }
        }
        break;
    }
}
```

---

## 💾 Save & Load Persistence

The accumulated guano counter is preserved across world saves and restarts using modern MC 26.1 `ValueOutput` and `ValueInput` mixin hooks:

```java
@Inject(method = "addAdditionalSaveData", at = @At("TAIL"))
private void betterbats$onAddAdditionalSaveData(ValueOutput output, CallbackInfo ci) {
    output.putInt("betterbats:guano_ticks", this.betterbats$guanoTicks);
}

@Inject(method = "readAdditionalSaveData", at = @At("TAIL"))
private void betterbats$onReadAdditionalSaveData(ValueInput input, CallbackInfo ci) {
    this.betterbats$guanoTicks = input.getIntOr("betterbats:guano_ticks", 0);
}
```

---

## 📋 Guano Production Reference Matrix

| Condition | Surface Below | `bat_drop_guano_item` | Outcome | Particle / Audio Feedback |
|---|---|---|---|---|
| Threshold Met | Farmland with growing crop | Any (`true`/`false`) | Crop stage advances | `HAPPY_VILLAGER` (5) + `levelEvent 2005` |
| Threshold Met | Farmland with mature crop | `false` | None | `MYCELIUM` (3) dust |
| Threshold Met | Farmland with mature crop | `true` | Drops `ItemEntity(BONE_MEAL)` | `MYCELIUM` (3) dust |
| Threshold Met | Solid floor / stone | `false` | None | `MYCELIUM` (3) dust |
| Threshold Met | Solid floor / stone | `true` | Drops `ItemEntity(BONE_MEAL)` | `MYCELIUM` (3) dust |
| Vibration / Woken | Any | Any | Guano timer resets to 0 | `BAT_TAKEOFF` panic |

---

## 🔗 Related Pages
- [[Bat Ecology, Photophobia & Daytime Roosting|Bat-Ecology-and-Photophobia]]
- [[Dynamic GameRules Reference Table|Dynamic-GameRules-Reference]]
- [[Commands & Advancements Guide|Commands-and-Advancements-Guide]]
- [[Sound Effects & Visual Particles Reference|Sound-Effects-and-Visual-Particles]]
