# 📜 Commands & Advancements Guide

| Feature Domain | Implementation Status | Technical Mechanism |
|---|---|---|
| **Brigadier Command Tree** | Active | `/betterbats` and `/bb` command hierarchy |
| **GameRule Integration** | Active | Vanilla `/gamerule` and DasikLibrary `DynamicGameRuleManager` |
| **Permission Model** | Gamemasters (Level 2) | `Commands.LEVEL_GAMEMASTERS.check(source.permissions())` |
| **Custom Advancement JSONs** | Vanilla Integration | Leverages native mob kill and crop growth triggers |

---

## 🖥️ `/betterbats` & `/bb` Command Tree

Better Bats features a dedicated, full-featured in-game Brigadier command suite under the root literals `/betterbats` and `/bb`:

```
/betterbats
├── (root)                 [Display introductory hint]
├── help                   [Print complete command guide]
├── status                 [Formatted overview of all active GameRules]
├── get <rule>             [Query specific rule value (tab completion)]
├── set <rule> <val>       [Modify rule & sync to JSON config (Gamemasters)]
├── reset                  [Reset all rules to factory defaults & save (Gamemasters)]
├── reload                 [Reload config from disk & sync to world (Gamemasters)]
└── debug                  [Developer & diagnostic subcommands (Gamemasters)]
    ├── on                 [Enable real-time diagnostic logging]
    ├── off                [Disable diagnostic logging]
    ├── inspect            [Inspect nearest bat within 16 blocks]
    └── spawn_swarm [n]    [Spawn a test murmuration swarm (1-30 bats)]
```

---

## 📋 Command Subcommand Reference

### 1. `status`
Outputs a color-coded diagnostic summary of all active GameRules categorized by Swarm & Murmuration, Ecology & Fertilizer, World Spawning, and Diagnostics:
```mcfunction
/betterbats status
```

### 2. `get <rule>` & `set <rule> <value>`
Provides auto-completing queries and modifications. Modifying a rule via `set` updates the active world GameRule container and automatically saves the new setting to `.minecraft/config/better-bats.json`:
```mcfunction
# Query current alignment weight
/betterbats get bat_alignment

# Set swarm size limit to 8
/betterbats set bat_swarm_size 8

# Enable physical bone meal item drops
/betterbats set bat_drop_guano_item true
```

### 3. `debug inspect`
Scans for the nearest bat within 16 blocks and generates an instant status report:
```mcfunction
/betterbats debug inspect
```
**Output Example**:
```
§6=== Better Bats: Bat Diagnostic Report ===§r
 §7UUID: §f4a8b1c2d...
 §7State: §b[Flying]§r
 §7Wingspan / Scale: §a1.15x §7(Genetics)§r
 §7Guano Accumulation: §a4520§7/§f12000 ticks§r
 §7Velocity: §f[0.12, 0.05, -0.08] §7(Speed: §a0.15 blk/t)§r
 §7Goal Active: §7No§r §7| Panicked: §7No§r
```

### 4. `debug spawn_swarm [count]`
Spawns a synchronized flock of bats (default 5, up to 30) around the player with randomized velocity offsets for testing flocking mechanics:
```mcfunction
/betterbats debug spawn_swarm 12
```

---

## 🏆 Advancement Triggers & Vanilla Loops

Better Bats deliberately avoids injecting artificial advancement screens into vanilla menus. Instead, its gameplay mechanics seamlessly trigger vanilla Minecraft advancement criteria:
- **Pest Elimination**: When a bat dive-bombs and destroys a Silverfish or Endermite, it utilizes the bat's natural `mobAttack` damage source, triggering vanilla entity kill predicates.
- **Crop Fertilization**: When a roosting bat fertilizes a crop, the game executes standard bonemeal logic and emits world level event `2005`, allowing players to advance farming advancements.

---

## 🔗 Related Pages
- [[Dynamic GameRules Reference Table|Dynamic-GameRules-Reference]]
- [[Animal Genetics & Inherited Chiroptera Traits|Animal-Genetics-and-Trait-Inheritance]]
- [[Guano Production & Farmland Crop Fertilization|Guano-Production-and-Crop-Fertilization]]
- [[HUD Diagnostics & Client Configuration Screens|HUD-Diagnostics-and-Config-Screens]]
