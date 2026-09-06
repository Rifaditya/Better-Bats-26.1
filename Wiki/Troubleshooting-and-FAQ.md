# ❓ Troubleshooting & Frequently Asked Questions

---

## ❓ Frequently Asked Questions

### Q1: Why are bats not spawning in my world?
**Answer**: 
1. Check the active GameRule value using `/betterbats get bat_spawn_weight` (or `/gamerule better-bats:bat_spawn_weight`). If set to `0`, spawning is completely disabled.
2. Ensure that surface spawning areas satisfy nighttime or dark forest overhang conditions (`Sky Light <= 7`) over valid spawn blocks (`#minecraft:bats_spawnable_on`).
3. Verify that the world is not currently at the global ambient mob cap ($15$ ambient mobs per player).

---

### Q2: Why are changes in `better-bats.json` not taking effect in my existing world?
**Answer**: 
Values in `.minecraft/config/better-bats.json` set baseline defaults for **NEW WORLDS ONLY**. Existing active worlds store their configuration inside the world's `level.dat` GameRules. To update an existing world, use `/betterbats set <rule> <val>` in-game (which automatically syncs both the live world and your config file) or standard `/gamerule` commands.

---

### Q3: Why are resting bats dropping Bone Meal items on my floor?
**Answer**: 
The GameRule `better-bats:bat_drop_guano_item` is set to `true`. By default, this is `false` (bats fertilize crops directly without dropping physical item entities). Run `/betterbats set bat_drop_guano_item false` to stop physical item drops.

---

### Q4: How do I view diagnostic stats or inspect a bat?
**Answer**: 
You can use the built-in diagnostic command:
```mcfunction
/betterbats debug inspect
```
This inspects the closest bat within 16 blocks, reporting its UUID, resting status, genetics scale, accumulated guano progress, velocity, and active AI goal state.

---

## 🛠️ Common Startup Errors & Solutions

### Error 1: `RuntimeException: Better Bats requires 'dasik-library' to be loaded!`
- **Cause**: DasikLibrary is missing from your `mods/` directory.
- **Solution**: Download and install `dasik-library` (version `>=1.8.38`) matching your Minecraft 26.1.2 installation.

---

### Error 2: `[PRE-RELEASE / VERSION GUARD WARNING] Better Bats: Incompatible Minecraft Game Runtime...`
- **Cause**: You are attempting to run a Minecraft 26.1.2 build (`better-bats-1.1.41-26.1.2.jar`) on an incompatible or mismatched Minecraft release.
- **Solution**: Ensure your game version is Minecraft 26.1.2 and Fabric Loader is `0.19.1` or newer.

---

## 🔗 Related Pages
- [[Minecraft 26.1 Setup & Technical Guide|Minecraft-26.1-Guide]]
- [[Dynamic GameRules Reference Table|Dynamic-GameRules-Reference]]
- [[Version & Modloader Compatibility Matrix|Version-Compatibility]]
- [[Commands & Advancements Guide|Commands-and-Advancements-Guide]]
