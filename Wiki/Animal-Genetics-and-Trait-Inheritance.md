# 🧬 Animal Genetics & Inherited Chiroptera Traits

| Trait Key | Target Attribute | Modifier Operation | Default Base | Min Bound | Max Bound | Mutation Rule |
|---|---|---|---|---|---|---|
| `scale` | `minecraft:generic.scale` | `ADD_VALUE` | `0.0f` | `0.75f` | `1.30f` | `uniform(0.75f, 1.30f)` |
| `movement_speed` | `minecraft:generic.movement_speed` | `ADD_MULTIPLIED_BASE` | `0.0f` | `-0.04f` | `0.08f` | `uniform(-0.04f, 0.08f)` |
| `attack_damage` | `minecraft:generic.attack_damage` | `ADD_VALUE` | `0.0f` | `1.0f` | `4.0f` | `uniform(1.0f, 4.0f)` |

---

## 🎮 Player Workflow & Trait Observation

1. **Visual Diversity**: Wild bats spawn with noticeable physical variation. Micro-bats appear compact and agile ($0.75\times$ scale), while giant flying foxes have broad wingspans ($1.30\times$ scale) with proportionally scaled collision boxes.
2. **Flight Performance**: Speed genetics slightly alter locomotion speed, creating natural variety in how different members of a swarm maneuver.
3. **Predatory Effectiveness**: Bats with high attack damage traits instantly obliterate pests like Silverfish in a single dive-bomb strike.
4. **Diagnostic Inspection**: Server operators can inspect the genetics of the nearest bat using the command:
   ```mcfunction
   /betterbats debug inspect
   ```
   This displays the bat's UUID, state, genetic scale multiplier, accumulated guano, velocity vector, and active AI goal status.

---

## 🧮 Trait Mathematics & Attribute Modifiers

### 1. Scale & Wingspan (`scale`)
Directly applies to `minecraft:generic.scale`:
$$\text{Render Scale} = 1.0 + \text{scale\_trait} \quad (0.75 \le S \le 1.30)$$

### 2. Locomotion Speed (`movement_speed`)
Multiplies the base movement speed attribute:
$$\text{Effective Speed} = \text{Base Speed} \times (1.0 + \text{speed\_trait}) \quad (-0.04 \le \Delta v \le +0.08)$$

### 3. Predatory Strike Damage (`attack_damage`)
Scales the damage dealt when executing `BatDiveBombGoal`:
$$\text{Pest Damage} = 10.0 \times \text{attack\_damage\_trait} \quad (10.0 \le \text{Damage} \le 40.0)$$

---

## 🧬 Genetic State Diagram

```
                 [ Bat Spawns in World ]
                            │
              Has DasikLibrary Genetics Data?
                 ┌──────────┴──────────┐
                YES                    NO
                 │                     │
          Load existing NBT       Roll stats from distribution:
          modifiers from tag      - scale: uniform(0.75, 1.30)
                 │                - speed: uniform(-0.04, 0.08)
                 │                - attack: uniform(1.0, 4.0)
                 │                     │
                 └──────────┬──────────┘
                            │
               Apply Attribute Modifiers to Bat:
               - minecraft:generic.scale
               - minecraft:generic.movement_speed
               - minecraft:generic.attack_damage
```

---

## 💾 SNBT Entity Data Schema

Genetics data is persisted in vanilla entity NBT without introducing custom serializable entities, ensuring total uninstallation safety:

```snbt
{
  "EntityGenetics": {
    "traits": {
      "scale": 1.15f,
      "movement_speed": 0.04f,
      "attack_damage": 2.85f
    },
    "profile": "better-bats:bat"
  }
}
```

---

## 💻 Developer & Mixin Hooks

Better Bats registers bat genetics in `BetterBatsFabric.java` using the `EntityGeneticsRegistry` API from **DasikLibrary**:

```java
EntityGeneticsRegistry.register(
    EntityType.BAT,
    new GeneticsConfig(
        Map.of(
            "scale", new TraitConfig("scale", "minecraft:generic.scale", "ADD_VALUE", 0.0f, 1.0f, 0.75f, 1.30f),
            "movement_speed", new TraitConfig("movement_speed", "minecraft:generic.movement_speed", "ADD_MULTIPLIED_BASE", 0.0f, 1.0f, -0.04f, 0.08f),
            "attack_damage", new TraitConfig("attack_damage", "minecraft:generic.attack_damage", "ADD_VALUE", 0.0f, 1.0f, 1.0f, 4.0f)
        ),
        Map.of(
            "default", Map.of(
                "scale", new MutationRule("uniform", 0.75f, 1.30f),
                "movement_speed", new MutationRule("uniform", -0.04f, 0.08f),
                "attack_damage", new MutationRule("uniform", 1.0f, 4.0f)
            )
        )
    )
);
```

On server AI step (`BatMixin.betterbats$onCustomServerAiStep`), if genetics are missing, they are rolled and applied:
```java
if (!DasikAnimalGeneticsAPI.hasGenetics(self)) {
    DasikAnimalGeneticsAPI.rollStats(self, "better-bats:bat");
    GeneticsEngine.applyGeneticsModifiers(self);
}
```

---

## 🔗 Related Pages
- [[Pest Control & Predatory Dive-Bomb Combat|Pest-Control-and-Predatory-Combat]]
- [[Consumer Mods Integration Guide|Consumer-Mods-Integration-Guide]]
- [[Commands & Advancements Guide|Commands-and-Advancements-Guide]]
