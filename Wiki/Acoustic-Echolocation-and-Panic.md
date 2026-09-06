# 🔊 Acoustic Echolocation, Vibration Sensing & Panic

| Parameter | Specification Details |
|---|---|
| **Vibration Listener Mixin** | `net.vanillaoutsider.betterbats.mixin.GameEventDispatcherMixin` |
| **Panic AI Goal Class** | `net.vanillaoutsider.betterbats.ai.BatPanicGoal` (Goal Priority 1) |
| **Vibration Trigger Events** | `GameEvent.EXPLODE`, `GameEvent.BLOCK_DESTROY`, Sprinting `GameEvent.STEP` |
| **Detection Radius** | `16 blocks` (AABB inflation) |
| **Panic Duration** | `100 ticks` ($5.0\text{ seconds}$) |
| **Panic Flight Response** | Disperses from group, flies rapidly away from disturbance ($0.15\text{ accel}$) |
| **Panic Audio** | `BAT_TAKEOFF` (Vol 0.8, Pitch 1.0) & `PHANTOM_FLAP` (Vol 0.5, Pitch 0.6) |
| **Echolocation Condition** | `Sky Light == 0` && `Block Light < 4` |
| **Echolocation Probability** | `1/90 ticks` (~4.5s average frequency) |
| **Echolocation Particles** | `SCULK_SOUL` (2 particles, speed 0.02) |
| **Echolocation Pitch** | `1.8f` to `2.1f` high-pitched click |

---

## 🎮 Player Workflow & Survival Tactics

1. **Caving Awareness**: When mining through deep subterranean caves, players will hear distinctive high-frequency clicks and notice faint cyan `SCULK_SOUL` sonic pulse particles emanating from bats flying in pitch darkness.
2. **Stealth vs. Disturbance**: 
   - Sneaking or walking quietly allows players to navigate past sleeping bat colonies without disturbing them.
   - Sprinting, breaking blocks, or igniting TNT triggers an acoustic shockwave within 16 blocks, causing all roosting bats to drop from the ceiling in a screeching panic.
3. **Guano Interruption**: If players disturb a resting bat, its internal guano accumulation timer immediately resets to zero, emphasizing the need to create quiet, undisturbed bat preserves for fertilizer harvesting.

---

## ⚡ Acoustic Vibration Sensing Flow

```
              ┌──────────────────────────────────────────────┐
              │ Environmental GameEvent within 16 Blocks     │
              │ (EXPLODE, BLOCK_DESTROY, Sprinting STEP)    │
              └──────────────────────┬───────────────────────┘
                                     │
                     Bat within 16-block AABB?
                       ┌─────────────┴─────────────┐
                      YES                          NO
                       │                           │
               Wake up resting bat             Ignore event
             (bat.setResting(false))
                       │
              Reset guano accumulation
            (betterbats$resetGuanoTicks())
                       │
            Trigger 100-tick Panic State
             (betterbats$panic(position))
                       │
         ┌─────────────▼─────────────────────────────┐
         │ BatPanicGoal (Priority 1)                 │
         │ - Clear group leadership                  │
         │ - Play BAT_TAKEOFF & PHANTOM_FLAP sounds  │
         │ - Accelerate away at 0.15 blocks/tick     │
         │ - Tick down from 100 to 0 ticks           │
         └───────────────────────────────────────────┘
```

---

## 🧮 Panic Locomotion Math

When `BatPanicGoal` runs, the bat calculates a normalized repulsive vector ($\hat{\mathbf{D}}$) away from the disturbance coordinate ($\mathbf{P}_{\text{source}}$):

$$\mathbf{D} = \mathbf{P}_{\text{bat}} - \mathbf{P}_{\text{source}}, \quad \hat{\mathbf{D}} = \frac{\mathbf{D}}{\|\mathbf{D}\|}$$

$$\mathbf{V}_{t+1} = \left( \mathbf{V}_t + \hat{\mathbf{D}} \times 0.15 \right) \times 0.85$$

The $0.85$ dampening factor provides tight, rapid, erratic turns while maintaining a high escape speed.

---

## 🦇 Pitch-Dark Cave Echolocation Mechanics

When flying through subterranean caverns with zero sky light (`Sky Light == 0`) and minimal artificial illumination (`Block Light < 4`), bats emit high-frequency echolocation clicks:

```java
if (self.getRandom().nextInt(90) == 0 && level.getBrightness(LightLayer.SKY, pos) == 0 && level.getBrightness(LightLayer.BLOCK, pos) < 4) {
    level.playSound(null, pos, SoundEvents.BAT_AMBIENT, SoundSource.NEUTRAL, 0.35F, 1.8F + self.getRandom().nextFloat() * 0.3F);
    level.sendParticles(ParticleTypes.SCULK_SOUL, self.getX(), self.getY() + 0.1, self.getZ(), 2, 0.08, 0.08, 0.08, 0.02);
}
```

---

## 📋 Acoustic & Vibration Matrix

| Event / Trigger | Range | Sound Event | Particles | Effect on Bat |
|---|---|---|---|---|
| `GameEvent.EXPLODE` | 16 blocks | `BAT_TAKEOFF` (0.8, 1.0) | None | Un-roost, reset guano, 100t panic |
| `GameEvent.BLOCK_DESTROY` | 16 blocks | `BAT_TAKEOFF` (0.8, 1.0) | None | Un-roost, reset guano, 100t panic |
| Sprinting `GameEvent.STEP` | 16 blocks | `BAT_TAKEOFF` (0.8, 1.0) | None | Un-roost, reset guano, 100t panic |
| Walking / Sneaking | Any | None | None | No disturbance; bat remains asleep |
| Echolocation Click | Self | `BAT_AMBIENT` (0.35, 1.8–2.1) | `SCULK_SOUL` (2) | Visual ambient ping |

---

## 💻 Developer & Mixin Hooks

- **Mixin**: [`GameEventDispatcherMixin.java`](file:///src/main/java/net/vanillaoutsider/betterbats/mixin/GameEventDispatcherMixin.java) intercepts `GameEventDispatcher.post` at `@At("HEAD")`.
- **Accessor Interface**: [`BatStateAccessor.java`](file:///src/main/java/net/vanillaoutsider/betterbats/BatStateAccessor.java) exposes `betterbats$panic(Vec3 source)`, `betterbats$isPanicked()`, and `betterbats$getPanicTicks()`.
- **AI Goal**: [`BatPanicGoal.java`](file:///src/main/java/net/vanillaoutsider/betterbats/ai/BatPanicGoal.java) registered at Priority 1 in `BatMixin.<init>`.

---

## 🔗 Related Pages
- [[Bat Ecology, Photophobia & Daytime Roosting|Bat-Ecology-and-Photophobia]]
- [[Sound Effects & Visual Particles Reference|Sound-Effects-and-Visual-Particles]]
- [[Behavior Profiles, Goal Flags & State Accessors|Behavior-Profiles-and-Conditions]]
- [[Mixin Reference & Injection Hooks|Mixin-Reference-and-Hooks]]
