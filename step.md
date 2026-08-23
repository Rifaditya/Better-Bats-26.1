# 📋 Better Bats 26.1.2 Parity Upgrade: Step-by-Step Execution Plan (`step.md`)

**Target Subproject**: [`Better Bats 26.1`](file:///E:/Minecraft%20Project/Vanilla%20Outsider%20Collections/Better%20Bats/Better%20Bats%20v26.1/Better%20Bats%2026.1)  
**Baseline Version**: `v1.1.16-26.1.2`  
**Target Parity Version**: `v1.1.25-26.1.2` (Full Parity with 26.2 `v1.1.25+26.2`)  
**Design Philosophy**: **Vanilla Outsider (VO)**  

---

## 📊 Parity Steps Status & Checklist

- [x] **Step 1: Architectural Overhaul & Flight Jitter Elimination** (`v1.1.17-26.1.2`)
- [x] **Step 2: Expanded Roost Hanging (Feature 7)** (`v1.1.18-26.1.2`)
- [x] **Step 3: Physical Guano Harvest (Feature 8)** (`v1.1.19-26.1.2`)
- [x] **Step 4: Predator Avoidance (Feature 9)** (`v1.1.20-26.1.2`)
- [ ] **Step 5: Ambient Cave Echolocation, Roost Clustering & Storm Shelter (Features 10–12)** (`v1.1.22-26.1.2`)
- [ ] **Step 6: Dasik Animal Genetics API Integration** (`v1.1.23-26.1.2`)
- [ ] **Step 7: Resting Entity Lookup Throttling & Performance Optimization** (`v1.1.24-26.1.2`)
- [ ] **Step 8: Automated Headless Test Suite (JUnit 5)** (`v1.1.25-26.1.2`)

---

## 🛠️ Detailed Step Breakdown

---

### 🟡 Step 1: Architectural Overhaul & Flight Jitter Elimination
* **Target Version**: `1.1.17-26.1.2`
* **Purpose**: Eliminate vanilla flight jitter and abrupt yaw snapping, provide smooth rotational banking, and add guano particle feedback.
* **Files to Modify / Create**:
  * `[NEW]` [`net/vanillaoutsider/betterbats/util/ModVersionGuard.java`](file:///E:/Minecraft%20Project/Vanilla%20Outsider%20Collections/Better%20Bats/Better%20Bats%20v26.1/Better%20Bats%2026.1/src/main/java/net/vanillaoutsider/betterbats/util/ModVersionGuard.java)
  * `[MODIFY]` [`net/vanillaoutsider/betterbats/BetterBatsFabric.java`](file:///E:/Minecraft%20Project/Vanilla%20Outsider%20Collections/Better%20Bats/Better%20Bats%20v26.1/Better%20Bats%2026.1/src/main/java/net/vanillaoutsider/betterbats/BetterBatsFabric.java)
  * `[MODIFY]` [`net/vanillaoutsider/betterbats/mixin/BatMixin.java`](file:///E:/Minecraft%20Project/Vanilla%20Outsider%20Collections/Better%20Bats/Better%20Bats%20v26.1/Better%20Bats%2026.1/src/main/java/net/vanillaoutsider/betterbats/mixin/BatMixin.java)
* **Mechanics**:
  1. Switch `customServerAiStep` injection to `@At("HEAD")` with `cancellable = true`. In flight mode, cancel vanilla step (`ci.cancel()`) so `BatFlightHelper` has 100% clean trajectory control.
  2. Implement smooth 3-axis yaw lerping (`Mth.approachDegrees(self.getYRot(), targetYaw, 12.0F)`).
  3. Guano fertilization polish: trigger `ParticleTypes.HAPPY_VILLAGER` on crop fertilization, and `ParticleTypes.MYCELIUM` dust on non-crop blocks.
* **Verification & Release**:
  * Bump `mod_version=1.1.17-26.1.2` in `gradle.properties`.
  * Sync `CHANGELOG.md`, `RELEASE_QUEUE.md`, and `Doc/Develop/Changelogs/History.md`.
  * Build & archive `better-bats-1.1.17-26.1.2.jar`.
  * Git commit & push.

---

### ⚪ Step 2: Expanded Roost Hanging (Feature 7)
* **Target Version**: `1.1.18-26.1.2`
* **Purpose**: Allow bats to hang upside-down from realistic hanging structures beyond full solid blocks.
* **Files to Modify / Create**:
  * `[NEW]` [`net/vanillaoutsider/betterbats/ai/BatRoostHelper.java`](file:///E:/Minecraft%20Project/Vanilla%20Outsider%20Collections/Better%20Bats/Better%20Bats%20v26.1/Better%20Bats%2026.1/src/main/java/net/vanillaoutsider/betterbats/ai/BatRoostHelper.java)
  * `[MODIFY]` [`net/vanillaoutsider/betterbats/mixin/BatMixin.java`](file:///E:/Minecraft%20Project/Vanilla%20Outsider%20Collections/Better%20Bats/Better%20Bats%20v26.1/Better%20Bats%2026.1/src/main/java/net/vanillaoutsider/betterbats/mixin/BatMixin.java)
* **Mechanics**:
  1. Bats can roost beneath **Pointed Dripstone (stalactites)**, **Hanging Lanterns**, **Iron Chains**, **Fences**, **Walls**, **Tree Leaves**, and any block with `isFaceSturdy(Direction.DOWN)`.
  2. Integrated `isSuitableRoost(Level level, BlockPos pos, BlockPos above)` check in `BatMixin`.
* **Verification & Release**:
  * Bump `mod_version=1.1.18-26.1.2`.
  * Doc sync $\rightarrow$ Build & Archive $\rightarrow$ Git commit & push.

---

### ⚪ Step 3: Physical Guano Harvest (Feature 8)
* **Target Version**: `1.1.19-26.1.2`
* **Purpose**: Enable physical Bone Meal item entity drops when resting over non-crop surfaces.
* **Files to Modify / Create**:
  * `[MODIFY]` [`net/vanillaoutsider/betterbats/BetterBatsFabric.java`](file:///E:/Minecraft%20Project/Vanilla%20Outsider%20Collections/Better%20Bats/Better%20Bats%20v26.1/Better%20Bats%2026.1/src/main/java/net/vanillaoutsider/betterbats/BetterBatsFabric.java)
  * `[MODIFY]` [`net/vanillaoutsider/betterbats/config/BetterBatsConfig.java`](file:///E:/Minecraft%20Project/Vanilla%20Outsider%20Collections/Better%20Bats/Better%20Bats%20v26.1/Better%20Bats%2026.1/src/main/java/net/vanillaoutsider/betterbats/config/BetterBatsConfig.java)
  * `[MODIFY]` [`net/vanillaoutsider/betterbats/config/ClothConfigScreenHelper.java`](file:///E:/Minecraft%20Project/Vanilla%20Outsider%20Collections/Better%20Bats/Better%20Bats%20v26.1/Better%20Bats%2026.1/src/main/java/net/vanillaoutsider/betterbats/config/ClothConfigScreenHelper.java)
  * `[MODIFY]` [`net/vanillaoutsider/betterbats/mixin/BatMixin.java`](file:///E:/Minecraft%20Project/Vanilla%20Outsider%20Collections/Better%20Bats/Better%20Bats%20v26.1/Better%20Bats%2026.1/src/main/java/net/vanillaoutsider/betterbats/mixin/BatMixin.java)
  * `[MODIFY]` `assets/better-bats/lang/en_us.json` & `id_id.json`
* **Mechanics**:
  1. Add `better-bats:bat_drop_guano_item` boolean GameRule (default `false`).
  2. When enabled and guano threshold is reached over non-crop or fully grown blocks, spawn a `ItemEntity` with `Items.BONE_MEAL`.
* **Verification & Release**:
  * Bump `mod_version=1.1.19-26.1.2`.
  * Doc sync $\rightarrow$ Build & Archive $\rightarrow$ Git commit & push.

---

### ⚪ Step 4: Predator Avoidance (Feature 9)
* **Target Version**: `1.1.20-26.1.2`
* **Purpose**: Make bats flee from natural predators (Cats, Ocelots, Phantoms).
* **Files to Modify / Create**:
  * `[MODIFY]` [`net/vanillaoutsider/betterbats/ai/BatFlightHelper.java`](file:///E:/Minecraft%20Project/Vanilla%20Outsider%20Collections/Better%20Bats/Better%20Bats%20v26.1/Better%20Bats%2026.1/src/main/java/net/vanillaoutsider/betterbats/ai/BatFlightHelper.java)
  * `[MODIFY]` [`net/vanillaoutsider/betterbats/mixin/BatMixin.java`](file:///E:/Minecraft%20Project/Vanilla%20Outsider%20Collections/Better%20Bats/Better%20Bats%20v26.1/Better%20Bats%2026.1/src/main/java/net/vanillaoutsider/betterbats/mixin/BatMixin.java)
* **Mechanics**:
  1. Roosting bats wake and take off when a predator approaches within 10 blocks.
  2. Flying bats compute directional flee steering vector (`force = 0.25`) pushing them directly away from nearby predators.
* **Verification & Release**:
  * Bump `mod_version=1.1.20-26.1.2`.
  * Doc sync $\rightarrow$ Build & Archive $\rightarrow$ Git commit & push.

---

### ⚪ Step 5: Ambient Cave Echolocation, Roost Clustering & Storm Shelter (Features 10–12)
* **Target Version**: `1.1.22-26.1.2`
* **Purpose**: Atmospheric cave clicks/pulses, group roosting colonies, and rain/thunder avoidance.
* **Files to Modify / Create**:
  * `[MODIFY]` [`net/vanillaoutsider/betterbats/mixin/BatMixin.java`](file:///E:/Minecraft%20Project/Vanilla%20Outsider%20Collections/Better%20Bats/Better%20Bats%20v26.1/Better%20Bats%2026.1/src/main/java/net/vanillaoutsider/betterbats/mixin/BatMixin.java)
  * `[MODIFY]` [`net/vanillaoutsider/betterbats/ai/BatSleepGoal.java`](file:///E:/Minecraft%20Project/Vanilla%20Outsider%20Collections/Better%20Bats/Better%20Bats%20v26.1/Better%20Bats%2026.1/src/main/java/net/vanillaoutsider/betterbats/ai/BatSleepGoal.java)
  * `[MODIFY]` [`net/vanillaoutsider/betterbats/ai/BatFlightHelper.java`](file:///E:/Minecraft%20Project/Vanilla%20Outsider%20Collections/Better%20Bats/Better%20Bats%20v26.1/Better%20Bats%2026.1/src/main/java/net/vanillaoutsider/betterbats/ai/BatFlightHelper.java)
* **Mechanics**:
  1. **Echolocation**: Flying in total cave darkness (Sky Light 0, Block Light < 4) emits pitch-variant clicks (`BAT_AMBIENT`) and `SCULK_SOUL` pulse particles.
  2. **Roost Clustering**: Sleep-seeking bats prioritize ceiling blocks near already resting bats.
  3. **Storm Shelter**: Bats in open sky during rain or thunder actively seek cave ceilings/overhangs to roost.
* **Verification & Release**:
  * Bump `mod_version=1.1.22-26.1.2`.
  * Doc sync $\rightarrow$ Build & Archive $\rightarrow$ Git commit & push.

---

### ⚪ Step 6: Dasik Animal Genetics API Integration
* **Target Version**: `1.1.23-26.1.2`
* **Purpose**: Genetic trait scaling for bats (wingspan, speed, damage).
* **Files to Modify / Create**:
  * `[MODIFY]` [`net/vanillaoutsider/betterbats/mixin/BatMixin.java`](file:///E:/Minecraft%20Project/Vanilla%20Outsider%20Collections/Better%20Bats/Better%20Bats%20v26.1/Better%20Bats%2026.1/src/main/java/net/vanillaoutsider/betterbats/mixin/BatMixin.java)
  * `[MODIFY]` `gradle.properties` (Update `dasik_library_version` if needed)
* **Mechanics**:
  1. Integrate `DasikAnimalGeneticsAPI` and `GeneticsEngine` for `better-bats:bat`.
  2. Support scale modifiers (`0.75x` microbats to `1.30x` giant bats), movement speed, and pest dive-bomb damage.
* **Verification & Release**:
  * Bump `mod_version=1.1.23-26.1.2`.
  * Doc sync $\rightarrow$ Build & Archive $\rightarrow$ Git commit & push.

---

### ⚪ Step 7: Performance Optimization & Lookup Throttling
* **Target Version**: `1.1.24-26.1.2`
* **Purpose**: Throttle resting predator entity lookups to eliminate AABB allocations during sleep cycles.
* **Files to Modify / Create**:
  * `[MODIFY]` [`net/vanillaoutsider/betterbats/mixin/BatMixin.java`](file:///E:/Minecraft%20Project/Vanilla%20Outsider%20Collections/Better%20Bats/Better%20Bats%20v26.1/Better%20Bats%2026.1/src/main/java/net/vanillaoutsider/betterbats/mixin/BatMixin.java)
* **Mechanics**:
  1. Gate `level.getEntitiesOfClass(...)` during roosting to once every 20 ticks (1/sec) instead of every tick.
* **Verification & Release**:
  * Bump `mod_version=1.1.24-26.1.2`.
  * Doc sync $\rightarrow$ Build & Archive $\rightarrow$ Git commit & push.

---

### ⚪ Step 8: Automated Headless Test Suite (JUnit 5)
* **Target Version**: `1.1.25-26.1.2`
* **Purpose**: Integrate automated CI test suite verifying Boids math, clamping, and genetics bounds.
* **Files to Modify / Create**:
  * `[MODIFY]` `build.gradle` (Add `useJUnitPlatform()`, `testImplementation`)
  * `[NEW]` `src/test/java/net/vanillaoutsider/betterbats/test/BatFlightMathTest.java`
  * `[NEW]` `src/test/java/net/vanillaoutsider/betterbats/test/BetterBatsConfigTest.java`
* **Mechanics**:
  1. Add JUnit 5 unit tests for flight vector algorithms, velocity bounds, and config defaults.
* **Verification & Release**:
  * Bump `mod_version=1.1.25-26.1.2`.
  * Run `./gradlew test` and `./gradlew build`.
  * Doc sync $\rightarrow$ Archive $\rightarrow$ Git commit & push.

---

## 🔒 Mandatory Lifecycle for Every Step
Every single step above MUST follow the un-skippable lifecycle:
1. **SemVer Bump**: Bump `mod_version` in `gradle.properties`.
2. **Doc Sync**: Update `CHANGELOG.md`, `RELEASE_QUEUE.md`, `Doc/Develop/Changelogs/History.md`, and this `step.md`.
3. **Build & Auto-Archive**: Run `./gradlew build` and verify output JAR in `Archive Jar of all versions/`.
4. **Git Commit & Push**: Stage changed files, commit with version tag `Release v<version>: <summary>`, and `git push`.
