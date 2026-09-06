# 🏮 Phototaxis & Nighttime Light Orbiting

| Parameter | Specification Details |
|---|---|
| **AI Goal Class** | `net.vanillaoutsider.betterbats.ai.BatHuntLightGoal` (Priority 4) |
| **Detection Light Level** | `Block Light > 8` (`LIGHT_DETECT_THRESHOLD`) |
| **Continue Light Level** | `Block Light > 6` (`LIGHT_CONTINUE_THRESHOLD`) |
| **Search Radius** | `8 blocks` Horizontal / `6 blocks` Vertical (`BlockPos.findClosestMatch`) |
| **Search Throttle** | Executes light search once every `30 ticks` (~1.5s) |
| **Orbit Duration** | `200` to `600 ticks` ($10 - 30\text{ seconds}$) |
| **Goal Cooldown** | `200` to `400 ticks` ($10 - 20\text{ seconds}$) |
| **Approach Mode** | Curved banking flight vector ($d > 2.5\text{ blocks}$) |
| **Orbiting Mode** | Tangential velocity vector with sine-wave vertical bobbing ($d \le 2.5\text{ blocks}$) |
| **Visual Particles** | `ParticleTypes.CRIT` (10% tick probability during orbit) |

---

## 🎮 Player Workflow & Atmospheric Base Decoration

1. **Illuminating the Night**: Placing lanterns, soul lanterns, jack-o'-lanterns, campfire embers, or torches outdoors in your village or base creates natural attraction nodes for nocturnal bats.
2. **The "Moth Effect"**: At night, flying bats leave their high altitude cruising to bank smoothly toward bright lights, simulating an attraction to insects fluttering around the illumination.
3. **Orbiting & Feeding**: The bat circles the lamp in a graceful bobbing orbit, emitting occasional critical hit particles (`CRIT`) to represent feeding on insects.
4. **Natural Hopping**: Rather than becoming permanently trapped circling a single lamp forever, the bat orbits for 10–30 seconds before breaking away on a 10–20 second cooldown, either flying off into the night sky or hopping to an adjacent lamp.

---

## 🌙 Phototaxis State Cycle

```
                   ┌──────────────────────────┐
                   │    Nighttime Ambient     │
                   └────────────┬─────────────┘
                                │
               Scans nearby area for Block Light > 8
                                │
                    Light Found (targetLight)?
                     ┌──────────┴──────────┐
                    YES                   NO
                     │                    │
              Distance > 2.5 blocks?    Wander / BOIDs
               ┌─────┴─────┐
              YES          NO
               │           │
       Curved Banking    Tangential Orbit
       Approach Flight   + Sine Bobbing (sin(t * 0.15) * 0.03)
                         + CRIT Particles
               │           │
               └─────┬─────┘
                     │
           Ticks >= maxCirclingTicks? (10-30s)
                     │
           Cooldown 10-20s -> Hop to next light
```

---

## 📐 Flight Vector Math

### 1. Curved Banking Approach ($d > 2.5\text{ blocks}$)
To prevent rigid straight-line approach paths, the velocity blends the direct target vector with a perpendicular tangent vector for organic banking:

$$\mathbf{V}_{\text{tangent}} = (-dz, \ dx) \cdot 0.5$$
$$\mathbf{V}_{\text{steer}} = \frac{(dx, dz) + \mathbf{V}_{\text{tangent}}}{\sqrt{dx^2 + dz^2}} \cdot 0.12$$

### 2. Tangential Orbiting & Vertical Sine Bobbing ($d \le 2.5\text{ blocks}$)
Once within 2.5 blocks of the light source, the bat calculates a perpendicular cross-product vector for smooth circular orbiting, combined with a vertical sine-wave oscillation:

$$\text{Y}_{\text{bobbing}} = \sin(\text{circlingTicks} \times 0.15) \times 0.03$$
$$\mathbf{V}_{\text{final}} = \left( (V_x + \text{Cross}_x \cdot S) \times 0.9, \ V_y \times 0.9 + \text{Y}_{\text{bobbing}}, \ (V_z + \text{Cross}_z \cdot S) \times 0.9 \right)$$

---

## 📋 Phototaxis Parameters Reference

| State / Metric | Value | Technical Description |
|---|---|---|
| Activation Light | $> 8$ Block Light | Ensures bats only seek meaningful light sources (torches, lanterns). |
| Cancellation Light | $\le 6$ Block Light | If the light is extinguished or broken, the bat abandons the orbit. |
| Orbiting Radius | $\approx 1.5 - 2.5$ blocks | Clamps flight distance around the light fixture center. |
| Bobbing Frequency | $0.15\text{ rad/tick}$ | Produces a smooth vertical rhythm ($\approx 2.1\text{ second period}$). |
| Particle Frequency | $10\%$ per tick | Spawns `CRIT` particles while in the orbit phase. |

---

## 💻 Developer & Mixin Hooks

- **Goal Class**: [`BatHuntLightGoal.java`](file:///src/main/java/net/vanillaoutsider/betterbats/ai/BatHuntLightGoal.java) registered at Priority 4 in `BatMixin.<init>`.
- **Search Optimization**: Uses native deterministic `BlockPos.findClosestMatch(pos, 8, 6, predicate)` to eliminate allocations and run smoothly on high-population servers.
- **Tick Throttling**: The goal only evaluates search sweeps when `bat.tickCount >= nextAllowedTick` and on a 1-in-30 random interval.

---

## 🔗 Related Pages
- [[3D BOIDs Flocking, Altitude Caps & Steering|3D-BOIDs-Flocking-and-Steering]]
- [[Sound Effects & Visual Particles Reference|Sound-Effects-and-Visual-Particles]]
- [[Behavior Profiles, Goal Flags & State Accessors|Behavior-Profiles-and-Conditions]]
