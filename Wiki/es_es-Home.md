# 🦇 Wiki de Better Bats (Minecraft 26.1.2)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

Bienvenido a la documentación oficial de **Better Bats**, un mod integral para Minecraft 26.1.2 Fabric que transforma el comportamiento de los murciélagos (Chiroptera). Incorpora bandadas 3D realistas con física BOIDs (murmuraciones), fototropismo orbital alrededor de linternas, fotofobia diurna con regreso a cavernas, fertilización de cultivos mediante guano, combate depredador en picado contra lepisinas y endermites, pánico ante vibraciones acústicas e integración con genética de entidades.

> 📌 **Descargo de Responsabilidad del Código Fuente**: La documentación de esta Wiki refleja el **estado actual del código fuente en el repositorio**, el cual puede incluir commits recientes o características en desarrollo antes de su publicación en CurseForge y Modrinth.

---

## 🧭 Navegación de la Wiki

### 📦 Guías de Plataforma e Instalación
- [[Guía Técnica de Minecraft 26.1|Minecraft-26.1-Guide]] — Especificaciones de plataforma (JDK 25, Fabric Loader >=0.19.1, Fabric API 0.145.4+26.1.2).
- [[Matriz de Compatibilidad de Versiones|Version-Compatibility]] — Versiones compatibles, comprobación `ModVersionGuard` y dependencias.
- [[Configuración de Desarrollo y Compilación|Developer-Setup-and-Building]] — Compilación con Gradle 9.3+ sin demonio (`--no-daemon`) y comandos Loom.

---

### 🎮 Guías de Jugabilidad y Mecánicas
- [[Ecología, Fotofobia y Descanso Diurno|Bat-Ecology-and-Photophobia]] — Umbrales de luz diurnos y superficies de descanso válidas (estalactitas, linternas, cadenas, hojas).
- [[Bandadas 3D BOIDs, Límites de Altura y Física|3D-BOIDs-Flocking-and-Steering]] — Vectores de cohesión, alineación y separación con corrientes crepusculares.
- [[Producción de Guano y Fertilización de Cultivos|Guano-Production-and-Crop-Fertilization]] — Temporizadores de reposo, crecimiento de cultivos y caída de harina de huesos.
- [[Fototaxia y Órbita Nocturna de Fuentes de Luz|Phototaxis-and-Light-Orbiting]] — Detección de luces, efecto polilla y aproximación en curva suave.
- [[Control de Plagas y Ataques en Picado|Pest-Control-and-Predatory-Combat]] — Caza de lepisinas y endermites con daño genético escalable.
- [[Ecolocalización Acústica y Reacción de Pánico|Acoustic-Echolocation-and-Panic]] — Pulsos sónicos con partículas de alma de sculk y pánico por pisadas o explosiones.
- [[Genética Animal y Rasgos Heredados|Animal-Genetics-and-Trait-Inheritance]] — Escala de envergadura (0.75x–1.30x), velocidad de vuelo y daño de ataque.
- [[Tabla de Reglas de Juego Dinámicas|Dynamic-GameRules-Reference]] — Guía de las 9 GameRules en `better-bats:better_bats`.
- [[Generación Ambiental y Modificadores de Peso|Ambient-Spawning-and-Weight-Modifiers]] — Generación en superficie nocturna y pesos dinámicos en cuevas.
- [[Diagnóstico HUD y Pantallas de Configuración|HUD-Diagnostics-and-Config-Screens]] — Menú con YetAnotherConfigLib (YACL v3) e integración con ModMenu.
- [[Guía de Comandos y Progresos|Commands-and-Advancements-Guide]] — Árbol de comandos `/betterbats` y `/bb`, compatibilidad con `/gamerule`.
- [[Referencia de Efectos de Sonido y Partículas|Sound-Effects-and-Visual-Particles]] — Matriz de emisión de partículas y eventos de sonido.
- [[Resolución de Problemas y Preguntas Frecuentes|Troubleshooting-and-FAQ]] — Corrección de errores de inicio y sincronización de configs.

---

### 💻 Referencia Técnica para Desarrolladores
- [[Arquitectura y Estructura de Paquetes|Architecture-and-Package-Layout]] — Principio de una función por archivo y diseño de clases.
- [[Referencia de Mixins y Puntos de Inyección|Mixin-Reference-and-Hooks]] — Inyecciones en `Bat`, `GameEventDispatcher` y `NaturalSpawner`.
- [[Perfiles de IA y Métodos de Acceso al Estado|Behavior-Profiles-and-Conditions]] — Matriz de prioridades y protocolo `BatStateAccessor`.
- [[Guía de Integración para Otros Mods|Consumer-Mods-Integration-Guide]] — Lectura de genética y eventos vía DasikLibrary.

---

## 📜 Derechos de Autor y Licencia

Better Bats es software de código abierto desarrollado por **Dasik (Rifaditya)** bajo la licencia **GNU General Public License v3.0 (GPL-3.0-or-later)**.
