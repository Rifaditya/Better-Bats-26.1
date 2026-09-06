# 📦 Version & Modloader Compatibility Matrix

| Minecraft Target | Mod Version | Build JAR Name | DasikLibrary Version | Compatibility Status |
|---|---|---|---|---|
| **MC 26.1.2** (Target) | `1.1.41-26.1.2` | `better-bats-1.1.41-26.1.2.jar` | `>=1.8.38` (Built with `1.8.38`) | 🟢 Active Mainline Release |
| **MC 26.2** (Sister Anchor) | `1.1.25+26.2` | `better-bats-1.1.25+26.2.jar` | `>=1.8.9` | 🟢 Active Mainline Release |

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.

---

## 🔒 1 Jar 1 Version Law & Strict Bounds

Better Bats strictly enforces the **1 Jar 1 Version** architectural mandate:
- **`fabric.mod.json` Bounds**:
  ```json
  "depends": {
      "fabricloader": ">=0.19.1",
      "minecraft": ">=26.1.2",
      "java": ">=25",
      "fabric-api": "*",
      "dasik-library": ">=1.8.38"
  },
  "suggests": {
      "yet-another-config-lib": "*",
      "yet_another_config_lib_v3": "*",
      "modmenu": "*"
  }
  ```
- **Open-Ended Bounds (`>=`)**: Open-ended lower bounds prevent rigid Fabric Loader pre-release locks while ensuring backwards safety.
- **Dependency Guard**: Better Bats requires `dasik-library` to be loaded at runtime; missing library dependencies will cause `BetterBatsFabric` to throw a `RuntimeException` during initialization.

---

## 🛡️ `ModVersionGuard` Class Enforcement

To prevent class loading crashes on mismatched Minecraft versions, `ModVersionGuard` executes during `onInitialize()` before any mixin or entity access occurs:

```java
public final class ModVersionGuard {
    public static void checkClass(String modName, String requiredClassName) {
        ClassLoader contextLoader = Thread.currentThread().getContextClassLoader();
        ClassLoader currentLoader = ModVersionGuard.class.getClassLoader();
        try {
            if (contextLoader != null) {
                Class.forName(requiredClassName, false, contextLoader);
            } else {
                Class.forName(requiredClassName, false, currentLoader);
            }
        } catch (ClassNotFoundException e) {
            try {
                Class.forName(requiredClassName, false, currentLoader);
            } catch (ClassNotFoundException e2) {
                throw new RuntimeException("\n" +
                    "=====================================================================\n" +
                    " [PRE-RELEASE / VERSION GUARD WARNING] " + modName + "\n" +
                    "---------------------------------------------------------------------\n" +
                    " CRITICAL: Incompatible Minecraft Game Runtime or Missing Class!\n" +
                    " Required Class : " + requiredClassName + "\n" +
                    " Status         : UNRESOLVED AT RUNTIME\n\n" +
                    " Safety Protection:\n" +
                    " Execution halted to prevent unreleased/incompatible build deployment\n" +
                    " or broken world state save corruption.\n\n" +
                    " Troubleshooting Steps:\n" +
                    " 1. Verify target Minecraft version (26.1.2 release drop).\n" +
                    " 2. Ensure all required dependencies (Fabric API, DasikLibrary) are loaded.\n" +
                    " 3. Build/Download a verified matching release JAR from Modrinth/CurseForge.\n" +
                    "=====================================================================");
            }
        }
    }
}
```

---

## 🔗 Related Pages
- [[Minecraft 26.1 Setup & Technical Guide|Minecraft-26.1-Guide]]
- [[Developer Setup & Building from Source|Developer-Setup-and-Building]]
- [[Troubleshooting & Frequently Asked Questions|Troubleshooting-and-FAQ]]
