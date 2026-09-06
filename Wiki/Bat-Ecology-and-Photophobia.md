# 🦇 Bat Ecology, Photophobia & Daytime Roosting

| Feature Parameter | Specification Details |
|---|---|
| **Primary AI Goal Class** | `net.vanillaoutsider.betterbats.ai.BatSleepGoal` (Priority 2) |
| **Roost Validator Class** | `net.vanillaoutsider.betterbats.ai.BatRoostHelper` |
| **Daytime Sky Light Limit** | `Sky Light == 0` |
| **Daytime Block Light Limit** | `Block Light <= 7` |
| **Roost Search Radius** | `16 blocks` (Horizontal) / `10 blocks` (Vertical) |
| **Cluster Preference** | Prioritizes candidate roosts within `5x3x5` blocks of existing resting bats |
| **Supported Roost Surfaces** | Solid ceilings, pointed dripstone, hanging lanterns, chains, fences, walls, leaves |

---

## 🎮 Player Workflow & Roost Construction

1. **Natural Diurnal Cycles**: 
   - At dawn or during surface rainstorms, bats stop ambient wandering and actively descend into ravines, caves, or shaded overhangs to find a dark roost.
   - At nightfall, bats detach from the ceiling and fly upward toward the surface to forage.
2. **Constructing Bat Roosts**: Players can design artificial bat houses and roosting barns by providing:
   - Overhead darkness (`Sky Light == 0` and `Block Light <= 7`).
   - Valid hanging fixtures: Chains, hanging lanterns, iron bars/fences, walls, or dripstone stalactites.
3. **Colony Clustering**: When multiple bats roost in the same cavern, they naturally congregate in tight clusters rather than scattering uniformly.
4. **Waking Bats**: Roosting bats wake if a player comes within 4 blocks, if a predator approaches within 10 blocks, or if loud vibrations occur within 16 blocks.

---

## ☀️ Daytime Photophobia Mechanics

```
                  ┌────────────────────────┐
                  │    Daylight / Storm    │
                  └───────────┬────────────┘
                              │
                    Can see sky / Bright?
                     ┌────────┴────────┐
                    YES                NO
                     │                 │
           ┌─────────▼────────┐  ┌─────▼────────┐
           │ Seek Dark Cover  │  │ Check Roost  │
           │  (BatSleepGoal)  │  │ Surface Type │
           └─────────┬────────┘  └─────┬────────┘
                     │                 │
             Sky Light == 0 &&         │
             Block Light <= 7?         │
                     │                 │
           ┌─────────▼─────────────────▼────────┐
           │     Attach Ceiling & Sleep         │
           │        (setResting(true))          │
           └────────────────────────────────────┘
```

---

## 🪨 Valid Roosting Surfaces (`BatRoostHelper`)

Roost suitability is checked via `BatRoostHelper.isSuitableRoost(Level level, BlockPos pos, BlockPos above)`:

```java
public static boolean isSuitableRoost(Level level, BlockPos pos, BlockPos above) {
    if (!level.isEmptyBlock(pos)) return false;

    BlockState aboveState = level.getBlockState(above);
    if (aboveState.isAir()) return false;

    // 1. Standard sturdy bottom face (solid blocks, slabs, stairs) or redstone conductor
    if (aboveState.isFaceSturdy(level, above, Direction.DOWN) || aboveState.isRedstoneConductor(level, pos)) {
        return true;
    }

    // 2. Pointed Dripstone (Stalactite pointing down)
    if (aboveState.getBlock() instanceof PointedDripstoneBlock) {
        if (aboveState.hasProperty(PointedDripstoneBlock.TIP_DIRECTION) && aboveState.getValue(PointedDripstoneBlock.TIP_DIRECTION) == Direction.DOWN) {
            return true;
        }
    }

    // 3. Hanging Lantern
    if (aboveState.getBlock() instanceof LanternBlock) {
        if (aboveState.hasProperty(LanternBlock.HANGING) && aboveState.getValue(LanternBlock.HANGING)) {
            return true;
        }
    }

    // 4. Iron Chains, Fences, Walls, and Leaves
    return aboveState.is(BlockTags.CHAINS) || 
           aboveState.is(BlockTags.FENCES) || 
           aboveState.is(BlockTags.WALLS) || 
           aboveState.is(BlockTags.LEAVES);
}
```

---

## 📋 Roost Surface Reference Table

| Surface Category | Block / Tag Requirement | State Properties Verified |
|---|---|---|
| Solid Ceiling | Any block | `isFaceSturdy(Direction.DOWN) == true` |
| Pointed Dripstone | `minecraft:pointed_dripstone` | `TIP_DIRECTION == Direction.DOWN` |
| Hanging Lantern | `minecraft:lantern`, `soul_lantern` | `LanternBlock.HANGING == true` |
| Iron Chains | Tag `#minecraft:chains` | Any valid chain block state |
| Fences | Tag `#minecraft:fences` | Wooden or nether brick fences |
| Walls | Tag `#minecraft:walls` | Cobblestone, deepslate, and stone walls |
| Tree Canopy Leaves | Tag `#minecraft:leaves` | Oak, spruce, birch, jungle, etc. |

---

## 💻 Developer & Mixin Hooks

- **Sleep Goal**: [`BatSleepGoal.java`](file:///src/main/java/net/vanillaoutsider/betterbats/ai/BatSleepGoal.java) registered at Priority 2 in `BatMixin.<init>`.
- **Roost Validator**: Centralized in [`BatRoostHelper.java`](file:///src/main/java/net/vanillaoutsider/betterbats/ai/BatRoostHelper.java).
- **Server AI Step Injection**: Evaluated in `BatMixin.betterbats$onCustomServerAiStep`, checking player proximity (`TargetingConditions.forNonCombat().range(4.0)`) and predator proximity (10 blocks) to un-roost when disturbed.

---

## 🔗 Related Pages
- [[3D BOIDs Flocking, Altitude Caps & Steering|3D-BOIDs-Flocking-and-Steering]]
- [[Guano Production & Farmland Crop Fertilization|Guano-Production-and-Crop-Fertilization]]
- [[Dynamic GameRules Reference Table|Dynamic-GameRules-Reference]]
- [[Sound Effects & Visual Particles Reference|Sound-Effects-and-Visual-Particles]]
