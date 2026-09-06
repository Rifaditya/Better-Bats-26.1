# 💻 Developer Setup & Building from Source

| Requirement | Environment Specification |
|---|---|
| **JDK Version** | Java 25 (`Adoptium HotSpot jdk-25.0.2.10-hotspot` / `jdk-25+`) |
| **Gradle Engine** | Gradle 9.3+ (`--no-daemon` mandatory) |
| **Fabric Loom Plugin** | Loom 1.15+ |
| **Build Command** | `./gradlew build --no-daemon` |
| **Test Command** | `./gradlew test --no-daemon` |
| **Output Jar Location** | `build/libs/better-bats-1.1.41-26.1.2.jar` |

---

## 🛠️ Environment Setup & Prerequisites

Before setting up or compiling Better Bats from source:

1. **Install JDK 25**: Download Java 25 (Adoptium OpenJDK). Verify using `java -version`.
2. **Configure `JAVA_HOME`**: Set `JAVA_HOME` to your JDK 25 path (e.g. `C:/Program Files/Eclipse Adoptium/jdk-25.0.2.10-hotspot`).
3. **Gradle Configuration**: Ensure `gradle.properties` references your JDK 25 environment or system environment variables:
   ```properties
   org.gradle.parallel=false
   # org.gradle.java.home=C:\\Program Files\\Eclipse Adoptium\\jdk-25.0.2.10-hotspot
   ```

---

## 🚀 Building the Release JAR

To compile and package the production JAR without launching background daemons:

```bash
# Clean and build release JAR
./gradlew build --no-daemon
```

Upon successful compilation, the built release JAR will be generated in `build/libs/`:
- `better-bats-1.1.41-26.1.2.jar`
- `better-bats-1.1.41-26.1.2-sources.jar`

---

## 🧪 Automated Testing Verification

Execute the automated test suite to verify entity mechanics, genetics, and safety checks prior to release:

```bash
# Run automated headless test suite
./gradlew test --no-daemon
```

---

## 📂 IDE Setup (IntelliJ IDEA / VS Code)

1. Clone the repository to your local workspace directory.
2. Open IntelliJ IDEA or VS Code and select **Open Project** pointing to `Better Bats 26.1`.
3. Import as a Gradle project. Allow Loom to auto-generate Fabric mappings and run configurations.
4. Execute `./gradlew genSources` if workspace source definitions require indexing.

---

## 🔗 Related Pages
- [[Minecraft 26.1 Setup & Technical Guide|Minecraft-26.1-Guide]]
- [[Architecture & Package Layout|Architecture-and-Package-Layout]]
- [[Mixin Reference & Injection Hooks|Mixin-Reference-and-Hooks]]
