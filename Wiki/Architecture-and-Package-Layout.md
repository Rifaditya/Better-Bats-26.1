# 🏛️ Architecture & Package Layout

| Design Principle | Architectural Policy |
|---|---|
| **Core Philosophy** | Vanilla Outsider (VO) — Diegetic, non-destructive, input-consistent |
| **Design Rule** | 1 File, 1 Function Law (Single-responsibility Cohesion) |
| **Main Package Namespace** | `net.vanillaoutsider.betterbats` |
| **Thread Safety Model** | Server-Thread Main Looper Sync (Zero async world mutation) |

---

## 🌳 ASCII Package Hierarchy Tree

```
net.vanillaoutsider.betterbats
├── BetterBatsFabric.java             [ModInitializer: GameRules, Genetics, Commands setup]
├── BetterBatsFabricClient.java       [ClientModInitializer]
├── BatStateAccessor.java             [State Accessor Interface: Guano, Panic & Goals]
│
├── ai
│   ├── BatDiveBombGoal.java          [Predatory Attack Goal on Silverfish & Endermites]
│   ├── BatFlightHelper.java          [3D BOIDs Flocking & Environmental Flight Steering]
│   ├── BatHuntLightGoal.java         [Phototaxis Light Orbiting & Banking AI Goal]
│   ├── BatPanicGoal.java             [Vibration Scattering Panic Flight AI Goal]
│   ├── BatRoostHelper.java           [Roost Surface Validator Helper]
│   └── BatSleepGoal.java             [Photophobia Daytime Cave Roosting AI Goal]
│
├── command
│   ├── BatCommandHelper.java         [Diagnostics & Murmuration Swarm Spawning Helper]
│   ├── BetterBatsCommand.java        [Brigadier Command Tree: /betterbats & /bb]
│   └── CommandSuggestionsHelper.java [Rule & Value Tab Completion Suggestions]
│
├── config
│   ├── BetterBatsConfig.java         [Config POJO & JSON File Persistence]
│   ├── ModMenuIntegration.java       [ModMenu API Screen Provider with YACL]
│   └── YaclScreenHelper.java         [YetAnotherConfigLib v3 Screen Builder]
│
├── mixin
│   ├── BatMixin.java                 [Core Bat Overhaul: Tick, AI, Guano, Echolocation]
│   ├── GameEventDispatcherMixin.java [Vibration Listener: Explosion, Step, Destroy]
│   ├── MobAccessor.java              [Exposes Mob.getGoalSelector()]
│   └── NaturalSpawnerMixin.java      [Dynamic Ambient Spawn Weight Interceptor]
│
└── util
    ├── BatDebugHelper.java           [Zero-Allocation Debug Logging Gating Helper]
    └── ModVersionGuard.java          [Zero-Dependency Version Safety Checker]
```

---

## 🔒 1 File, 1 Function Architectural Law

Every class in Better Bats follows strict single-function responsibility:
- **`BatFlightHelper`**: Purely handles vector math calculations for BOIDs flocking, ground/ceiling avoidance, and day/night flight steering.
- **`BatRoostHelper`**: Purely evaluates block state suitability for bat hanging and roosting.
- **`BatCommandHelper`**: Purely provides entity inspection formatting and swarm spawning logic.
- **`GameEventDispatcherMixin`**: Purely listens for world vibration events and triggers panic accessors.
- **`YaclScreenHelper`**: Purely constructs YetAnotherConfigLib v3 client GUI screens with Ko-fi support buttons.

---

## 💻 Developer & Extension Patterns

- **Duck Typing via Interfaces**: Rather than polluting vanilla entities with hard dependencies, `BatMixin` implements `BatStateAccessor` and `GroupMember`.
- **DasikLibrary API Binding**: Uses static facades like `DynamicGameRuleManager`, `DasikAnimalGeneticsAPI`, and `DasikSupportHelper` to keep the codebase clean, robust, and thin.
- **Zero-Allocation Logging Gating**: Wrapped via `BatDebugHelper.isDebug(level)`, ensuring debug log strings are never evaluated or allocated during standard gameplay ticks.

---

## 🔗 Related Pages
- [[Developer Setup & Building from Source|Developer-Setup-and-Building]]
- [[Mixin Reference & Injection Hooks|Mixin-Reference-and-Hooks]]
- [[Behavior Profiles, Goal Flags & State Accessors|Behavior-Profiles-and-Conditions]]
- [[Commands & Advancements Guide|Commands-and-Advancements-Guide]]
