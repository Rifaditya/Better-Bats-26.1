# ⚔️ Pest Control & Predatory Dive-Bomb Combat

| Parameter | Specification Details |
|---|---|
| **AI Goal Class** | `net.vanillaoutsider.betterbats.ai.BatDiveBombGoal` (Priority 5) |
| **GameRule Toggle** | `better-bats:bat_pest_control` (Default: `true`) |
| **Target Pest Entities** | `Silverfish` (`EntityType.SILVERFISH`), `Endermite` (`EntityType.ENDERMITE`) |
| **Detection Radius** | `8 blocks` (Bounding box inflation) |
| **Base Impact Damage** | `10.0` points ($5\text{ hearts}$) |
| **Genetics Damage Multiplier** | `attack_damage` trait ($1.0\times - 4.0\times$) |
| **Dive-Bomb Speed** | `0.3 blocks/tick` ($6.0\text{ blocks/sec}$) |
| **Audio Cue** | `minecraft:entity.bat.ambient` (Pitch `0.5f`) |

---

## 🎮 Player Workflow & Base Defense

1. **Natural Stronghold & Mine Defense**: In areas infested with Silverfish (such as Strongholds, Mountain biomes, or extreme hills), keeping bats nearby provides passive perimeter pest control.
2. **Endermite Hunting**: When pearls are thrown in Endermite traps or End portal rooms, bats home in on the crawling mites and eliminate them.
3. **Observing the Dive-Bomb**:
   - When a Silverfish or Endermite crawls within 8 blocks of an airborne bat, the bat breaks out of its flock.
   - It folds its wings and dives aggressively towards the target at $0.3\text{ blocks/tick}$.
   - Upon impact ($<1.0\text{ block}$), the bat executes a low-pitched screech (`BAT_AMBIENT` at pitch 0.5) and inflicts immediate lethal damage.
4. **Disabling Pest Combat**: Admins or players who prefer peaceful, purely ambient bats can disable combat via:
   ```mcfunction
   /betterbats set bat_pest_control false
   ```

---

## 🦅 Predatory Hunting Mechanics

```
                  ┌───────────────────────────────┐
                  │    Bat in Flight (Active)     │
                  └───────────────┬───────────────┘
                                  │
               GameRule bat_pest_control == true?
                                  │
                Scans 8 blocks for Silverfish/Endermite
                                  │
                       Pest Entity Found?
                         ┌────────┴────────┐
                        YES                NO
                         │                 │
                Clear Group Leader         Continue Ambient
                Set Goal Active = true     Flight / Flocking
                         │
                 Accelerate 0.3 b/t
                 Direct Dive-Bomb
                         │
                   Distance < 1.0?
                         │
           💥 Deal (10.0 * attack_damage_trait)
           🎵 Play BAT_AMBIENT sound (Pitch 0.5)
```

---

## 🧮 Damage Formula & Genetics Integration

The damage dealt to a pest upon impact is scaled dynamically by the bat's individual genetics:

$$\text{Damage} = 10.0 \times \text{attack\_damage\_trait}$$

- **Base Trait Value**: Default fallback baseline is $2.0$.
- **Genetic Trait Range**: $1.0\times$ to $4.0\times$ (configured in `EntityGeneticsRegistry`).
- **Effective Damage Range**: $10.0$ to $40.0$ damage points, instantly slaying Silverfish ($8\text{ HP}$) and Endermites ($8\text{ HP}$).

```java
if (dist < 1.0) {
    float attackDamageTrait = net.dasik.social.api.genetics.DasikAnimalGeneticsAPI.getTrait(this.bat, "attack_damage", 2.0f);
    float damage = 10.0f * attackDamageTrait;
    this.targetPest.hurt(this.bat.damageSources().mobAttack(this.bat), damage);
    this.bat.playSound(net.minecraft.sounds.SoundEvents.BAT_AMBIENT, 1.0f, 0.5f); 
    this.targetPest = null;
}
```

---

## 📋 Pest Targeting Reference Matrix

| Pest Mob | Registry Identifier | Base HP | Bat Attack Damage | Result |
|---|---|---|---|---|
| Silverfish | `minecraft:silverfish` | $8.0$ ($4\text{ hearts}$) | $10.0 - 40.0$ | Instant kill on single dive |
| Endermite | `minecraft:endermite` | $8.0$ ($4\text{ hearts}$) | $10.0 - 40.0$ | Instant kill on single dive |
| Other Arthropods | Spiders, Cave Spiders | $12.0 - 16.0$ | Ignored | Bats only target crawling micro-pests |

---

## 💻 Developer & Mixin Hooks

- **Goal Implementation**: [`BatDiveBombGoal.java`](file:///src/main/java/net/vanillaoutsider/betterbats/ai/BatDiveBombGoal.java) registered at Priority 5 in `BatMixin.<init>`.
- **Damage Source**: Uses vanilla `damageSources().mobAttack(this.bat)`, fully triggering vanilla mob kill statistics, advancement predicates, and death events.
- **State Suspension**: Sets `accessor.betterbats$setGoalActive(true)` during the strike, ensuring flocking forces do not interrupt the dive trajectory.

---

## 🔗 Related Pages
- [[Animal Genetics & Inherited Chiroptera Traits|Animal-Genetics-and-Trait-Inheritance]]
- [[Dynamic GameRules Reference Table|Dynamic-GameRules-Reference]]
- [[Behavior Profiles, Goal Flags & State Accessors|Behavior-Profiles-and-Conditions]]
