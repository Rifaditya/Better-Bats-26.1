# 🖥️ HUD Diagnostics & Client Configuration Screens

| Parameter | Specification Details |
|---|---|
| **Config File Location** | `.minecraft/config/better-bats.json` |
| **Config Version** | `1` (`public int configVersion = VERSION`) |
| **Config Helper API** | `net.vanillaoutsider.betterbats.config.BetterBatsConfig` |
| **ModMenu Entrypoint Class** | `net.vanillaoutsider.betterbats.config.ModMenuIntegration` |
| **Optional Screen Builder** | `net.vanillaoutsider.betterbats.config.YaclScreenHelper` (YetAnotherConfigLib v3) |
| **Support Integration** | `net.dasik.social.api.config.DasikSupportHelper.createYaclButton()` |

---

## ⚙️ Baseline Config JSON (`better-bats.json`)

On initial startup, `BetterBatsConfig.load()` generates a template JSON file inside the user's `.minecraft/config` folder backing default baseline values for newly created worlds:

```json
{
  "configVersion": 1,
  "batSwarmSize": 5,
  "batGuanoThreshold": 12000,
  "batPestControl": true,
  "batAlignment": 5,
  "batCohesion": 5,
  "batSeparation": 10,
  "batSpawnWeight": 30,
  "batDropGuanoItem": false
}
```

---

## 🛠️ ModMenu & YetAnotherConfigLib (YACL v3) Integration

Better Bats integrates cleanly with **ModMenu** and **YetAnotherConfigLib (YACL v3)** if loaded in the client environment. Accessing the mod config screen through ModMenu allows players to visually edit baseline options and access the creator support button:

```java
public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return GuiHelper.getOptionalYaclFactory(
                "better-bats",
                "net.vanillaoutsider.betterbats.config.YaclScreenHelper",
                "createScreen"
        );
    }
}
```

---

## ☕ Non-Intrusive Creator Support Button

Inside the configuration screen, a non-intrusive creator support button is injected at the top of the general settings group:
- **Button Label**: `☕ Support Solo Dev on Ko-fi`
- **Tooltip**: `Click to visit ko-fi.com/dasikigaijin in your default browser and directly support solo development!`
- **Behavior**: Opens the official Ko-fi page in the player's default web browser without interrupting client execution.

---

## ⚠️ 2-Way Sync Warning Display

The configuration screen renders an informational notice explaining world scope:

> ⚠️ **WARNING**: Changes made in this client screen only affect baseline defaults for **NEW worlds**. To configure your active/existing world, use the in-game Collapsible Game Rule Screen or the `/betterbats set <rule> <val>` command (which updates both the active world GameRule and the config file).

---

## 🔗 Related Pages
- [[Dynamic GameRules Reference Table|Dynamic-GameRules-Reference]]
- [[Commands & Advancements Guide|Commands-and-Advancements-Guide]]
- [[Minecraft 26.1 Setup & Technical Guide|Minecraft-26.1-Guide]]
