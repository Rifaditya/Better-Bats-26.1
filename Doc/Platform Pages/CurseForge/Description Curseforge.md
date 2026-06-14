<div align="center">

![Better Bats Banner](Doc/Assets/banner.png)

</div>
<p align="center">
    <a href="https://www.curseforge.com/minecraft/mc-mods/fabric-api"><img src="https://img.shields.io/badge/Requires-Fabric_API-blue?style=for-the-badge&logo=fabric" alt="Requires Fabric API"></a>
    <img src="https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=java" alt="Java">
    <img src="https://img.shields.io/badge/License-GPLv3-green?style=for-the-badge" alt="License">
    <img src="https://img.shields.io/badge/Minecraft-26.1+-brightgreen?style=for-the-badge" alt="Minecraft 26.1+">
</p>

# 🦇 Better Bats: The "Acoustic & Sleep" Update (Build 4)

**No Backports:** I will **NOT** backport this mod to older versions (1.21, 1.20, etc.). Please do not ask.

**The Vanilla Problem:** In vanilla Minecraft, bats are purely cosmetic, chaotic, ambient entities that offer no interactive value to the player's world. They fly aimlessly, spawn in complete darkness, and drop absolutely nothing, rendering them essentially useless.

**Better Bats** changes this foundation. It integrates bats into the ecosystem as active, social, and symbiotic neighbors. They group into coordinated swarms, seek shelter from the sun, fertilize crops, hunt insect pests, circle lanterns, and panic dynamically when loud events disrupt their sleep.

---

## 🎥 Showcase Video

<!-- For CurseForge / GitHub (Markdown Image Link) -->
[![Mod Showcase Video](https://img.youtube.com/vi/VIDEO_ID/maxresdefault.jpg)](https://youtu.be/VIDEO_ID)

*Click the player above to watch the mod showcase in action!*

---

## ✨ Features

### 🌪️ Hive Mind (Social Swarms)

Bats no longer fly in erratic, individual patterns. They organize into cohesive swarms using the **DasikLibrary** flocking strategy. Witness groups of bats moving together in coordination through cave corridors.

> [!NOTE]
> **Boids Steering**: Swarm flight is powered by a dynamic Boids murmuration algorithm.  
> Flocking Range: **16 blocks** — Bats dynamically elect a leader and align their movement vectors.

### 💩 Guano Fertility (Natural Growth)

While roosting upside down in the dark, bats slowly accumulate guano. Every 10 minutes, they drop guano to fertilize soil and crops far below.

> [!TIP]
> **Farmland Enrichment**: If a bat roosts above crops, it scans up to **20 blocks down** to apply a bone meal growth tick.

### 💡 Phototaxis (Lantern Hunting)

During the night, bats are attracted to bright artificial light sources. They break from their swarms to circle lanterns and torches, simulating the hunting of insects attracted to the glow.

> [!NOTE]
> **Insect Feeding**: Bats will circle light sources with a brightness level **>12**, emitting `crit` particles to represent feeding.

### 🛡️ Pest Control (Symbiotic Defense)

Bats are natural allies in pest management. They will aggressively dive-bomb and one-shot crawling pests that enter their vicinity.

> [!TIP]
> **Predatory Prey**: Bats target **Silverfish** and **Endermites** in a **10-block radius** and instantly defeat them.

### 📢 Acoustic Panic

Caves are quiet for a reason. Loud noises (sprinting players, block mining, explosions) nearby will wake sleeping bat swarms instantly, sending them into a frantic, high-speed scatter and resetting their guano timers.

> [!WARNING]
> **Sleep Interruption**: Noise events within **16 blocks** trigger immediate panic flight and clear the bat's flocking state.

### ⚖️ Multiplayer

Better Bats is fully compatible with multiplayer environments. The flocking and guano algorithms run entirely server-side, ensuring vanilla clients can connect without issues.

---

## ⚙️ Config

The mod works out of the box with zero setup.

* **Global Template**: `config/better-bats.json` (Sets defaults for new worlds)
* **In-Game**: Use `/gamerule [rule_name]` for core settings:
  * `bat_swarm_size`: Max bats allowed in a single flock. (Default: 5)
  * `bat_guano_threshold`: Ticks required for a roosting bat to drop guano. (Default: 12000)
  * `bat_pest_control`: Enables/disables hunting of silverfish and endermites. (Default: true)
  * `bat_alignment`: Strength of matching velocity direction with the swarm (0-100). (Default: 5)
  * `bat_cohesion`: Strength of pull towards the swarm's center of mass (0-100). (Default: 5)
  * `bat_separation`: Strength of collision avoidance from neighboring bats (0-100). (Default: 10)

> [!IMPORTANT]
> **Recommended Mod**: Since this mod generates 6+ GameRules, it is highly recommended to use **[Collapsible Game Rules](https://modrinth.com/mod/collapsible-gamerules)** for a cleaner UI.

---

## 🧩 Suggested Mods

For the best experience, we recommend installing:
* **[Collapsible Game Rules](https://modrinth.com/mod/collapsible-gamerules)**: Prevents the GameRules menu from becoming cluttered.

---

## 📦 Installation & Environment

### 🖥️ Environment Support
* [ ] **Client-side only**: All functionality is done client-side and is compatible with vanilla servers.
* [x] **Server-side only**: All functionality is done server-side and is compatible with vanilla clients.
  * [x] Works in singleplayer too
  * [ ] Dedicated server only
* [ ] **Client and server**: Has some functionality on both the client and server.

### 📥 Install Instructions
1. Install **[Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api)**.
2. Install **[DasikLibrary](https://www.curseforge.com/minecraft/mc-mods/dasik-library)**.
3. Download `better-bats-1.1.1+build.4.jar` and place it in your `mods` folder.

---

## 🧩 Compatibility

| Feature | Fabric (26.1+) |
| :--- | :---: |
| Singleplayer | ✅ |
| Multiplayer (LAN/Server) | ✅ |
| **VO: Better Dogs** | ✅ |
| Empty Dimensions | ✅ |

---

## ☕ Support

If you enjoy **Better Bats** and the **Vanilla Outsider** philosophy, consider fueling the next update with a coffee!

[![Ko-fi](https://img.shields.io/badge/Ko--fi-Support%20Me-FF5E5B?style=for-the-badge&logo=ko-fi&logoColor=white)](https://ko-fi.com/dasikigaijin/tip)
[![SocioBuzz](https://img.shields.io/badge/SocioBuzz-Local_Support-7BB32E?style=for-the-badge)](https://sociabuzz.com/dasikigaijin/tribe)
[![Saweria](https://img.shields.io/badge/Saweria-Local_Support-FFA500?style=for-the-badge)](https://saweria.co/DasikIgaijinn)

> [!NOTE]
> **Indonesian Users:** SocioBuzz and Saweria support local payment methods (Gopay, OVO, Dana, etc.) if you want to support me without using PayPal/Ko-fi!

---

## 📜 Credits

| Role | Author |
| :--- | :--- |
| **Creator** | Dasik (Rifaditya) |
| **Collection** | Vanilla Outsider |
| **License** | GNU GPLv3 |

---

> [!IMPORTANT]
> This mod is part of the **Vanilla Outsider** collection. You are free to use it in modpacks, videos, and servers.
>
> > [!IMPORTANT]
> > **Modpack Permissions:** You are free to include this mod in modpacks, **provided the modpack is hosted on the same platform** (e.g. CurseForge).
> >
> > **Cross-platform distribution is not permitted.** If you download this mod from CurseForge, your modpack must also be published on CurseForge.

---

<div align="center">

**Made with ❤️ for the Minecraft community**

*Part of the Vanilla Outsider Collection*

</div>
