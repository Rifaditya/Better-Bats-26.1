# 🦇 Ambient Spawning & Weight Modifiers

| Parameter | Specification Details |
|---|---|
| **Spawn Injector Mixin** | `net.vanillaoutsider.betterbats.mixin.NaturalSpawnerMixin` |
| **Surface Spawn Mixin** | `net.vanillaoutsider.betterbats.mixin.BatMixin.betterbats$onCheckBatSpawnRules` |
| **Mob Category** | `MobCategory.AMBIENT` |
| **Vanilla Base Spawn Weight** | `10` |
| **Mod Default Weight** | `30` (`better-bats:bat_spawn_weight`) |
| **Valid Surface Spawn Block Tag** | `#minecraft:bats_spawnable_on` |
| **Surface Spawn Sky Light** | `Sky Light <= 7` (Nighttime or dense canopy cover) |

---

## 🎮 Player Workflow & World Mechanics

1. **Surface Night Encounters**: Players wandering dark forests, plains, and swamps at night will encounter bats naturally spawning under the open sky, enlivening nocturnal biomes.
2. **Subterranean Density**: In caves, bats spawn at a higher relative frequency (weight 30 vs vanilla 10), populating massive caverns with active colonies.
3. **Server Administration**:
   - Query current spawn weight: `/betterbats get bat_spawn_weight` (or `/gamerule better-bats:bat_spawn_weight`).
   - Increase or decrease spawn frequency: `/betterbats set bat_spawn_weight <0-100>`.
   - Setting the weight to `0` cleanly disables all natural ambient bat spawning without throwing errors or breaking chunk generation.

---

## 🧮 Ambient Spawn Probability Math

Whenever the Minecraft world spawning engine selects an ambient creature for a chunk location, the selection probability for bats ($P_{\text{bat}}$) is proportional to its weight relative to all valid ambient candidates in that biome:

$$P_{\text{bat}} = \frac{W_{\text{bat}}}{W_{\text{bat}} + \sum_{k \neq \text{bat}} W_k}$$

- In pure cave biomes where bats are typically the sole ambient mob, $P_{\text{bat}} = 1.0$ (subject to mob cap limits).
- In biomes with additional ambient mobs, bumping the weight from `10` to `30` increases bat representation threefold.

---

## 🌲 Spawn Rule Decision Flow

```
              ┌──────────────────────────────────────────────┐
              │ NaturalSpawner checks MobCategory.AMBIENT    │
              └──────────────────────┬───────────────────────┘
                                     │
                    Is candidate position on Surface?
                    (pos.getY() >= Heightmap WORLD_SURFACE)
                       ┌─────────────┴─────────────┐
                      YES                          NO
                       │                           │
                Sky Light <= 7 &&           Subterranean Cave
           Block below in BlockTags         (Vanilla depth checks)
             BATS_SPAWNABLE_ON?                    │
            ┌──────────┴──────────┐                │
           YES                    NO               │
            │                     │                │
     Allow Surface Spawn      Deny Spawn           │
            │                                      │
            └──────────────────────┬───────────────┘
                                   │
              Apply Dynamic GameRule Spawn Weight
              (better-bats:bat_spawn_weight)
              If weight == 0: Remove from SpawnerData list
```

---

## 📋 Spawning Configuration Reference

| Setting / Rule | Default | Range | Description |
|---|---|---|---|
| `better-bats:bat_spawn_weight` | `30` | `0` to `100` | Dynamic spawn weight for ambient bats across all biomes. |
| Surface Sky Light Threshold | `<= 7` | Fixed | Prevents daylight surface spawning while enabling nocturnal flight. |
| Subterranean Spawn Cap | Dynamic | Vanilla Engine | Governed by vanilla `MobCategory.AMBIENT` mob cap ($15$ per player). |

---

## 💻 Developer & Mixin Hooks

- **Dynamic Weight Replacement**: Intercepts `NaturalSpawner.mobsAt` via [`NaturalSpawnerMixin.java`](file:///src/main/java/net/vanillaoutsider/betterbats/mixin/NaturalSpawnerMixin.java) at `@At("RETURN")`:
  ```java
  if (mobCategory == MobCategory.AMBIENT) {
      WeightedList<MobSpawnSettings.SpawnerData> original = cir.getReturnValue();
      if (original != null && !original.isEmpty()) {
          int customWeight = DynamicGameRuleManager.getInt(level, BetterBatsFabric.BAT_SPAWN_WEIGHT);
          List<Weighted<MobSpawnSettings.SpawnerData>> newList = new ArrayList<>();
          for (Weighted<MobSpawnSettings.SpawnerData> item : original.unwrap()) {
              if (item.value().type() == EntityType.BAT) {
                  if (customWeight > 0) {
                      newList.add(new Weighted<>(item.value(), customWeight));
                  }
              } else {
                  newList.add(item);
              }
          }
          cir.setReturnValue(WeightedList.of(newList));
      }
  }
  ```
- **Surface Rule Patch**: Injected into `Bat.checkBatSpawnRules` in [`BatMixin.java`](file:///src/main/java/net/vanillaoutsider/betterbats/mixin/BatMixin.java) at `@At("HEAD")`.

---

## 🔗 Related Pages
- [[Bat Ecology, Photophobia & Daytime Roosting|Bat-Ecology-and-Photophobia]]
- [[Dynamic GameRules Reference Table|Dynamic-GameRules-Reference]]
- [[Mixin Reference & Injection Hooks|Mixin-Reference-and-Hooks]]
