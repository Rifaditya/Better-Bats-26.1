# 🦇 更好的蝙蝠 (Better Bats) 官方维基 (Minecraft 26.1.2)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

欢迎来到 **Better Bats** 的官方维基文档中心。Better Bats 是一款专为 Minecraft 26.1.2 Fabric 环境打造的生态强化模组，彻底重构了原版蝙蝠（Chiroptera）的 AI 逻辑。引入逼真的三维 BOIDs 鸟群算法（Murmuration）、趋光环绕巡飞、白天避光返洞栖息、地下鸟粪（Guano）农田施肥、蠹虫与末影螨俯冲猎杀、声学振动惊恐散射以及实体遗传学系统。

> 📌 **仓库源码免责声明**：本维基文档反映了**当前仓库中的源码开发状态**，可能包含先于 CurseForge 与 Modrinth 公开发布版本的最新开发提交或未发布特性。

---

## 🧭 维基导航索引

### 📦 平台与构建指南
- [[MC 26.1 安装与技术指南|Minecraft-26.1-Guide]] — 核心目标平台配置（JDK 25, Fabric Loader >=0.19.1, Fabric API 0.145.4+26.1.2）。
- [[版本与加载器兼容性矩阵|Version-Compatibility]] — 支持版本、`ModVersionGuard` 运行时安全检查与依赖范围。
- [[从源码搭建开发环境与构建|Developer-Setup-and-Building]] — Gradle 9.3+ 无守护进程构建与 Loom 指令。

---

### 🎮 玩家与游戏机制指南
- [[蝙蝠生态、避光性与日间栖息|Bat-Ecology-and-Photophobia]] — 白天避光阈值、倒吊栖息表面（钟乳石、吊灯、锁链、树叶）。
- [[三维 BOIDs 群飞、飞行限高与转向数学|3D-BOIDs-Flocking-and-Steering]] — 凝聚、对齐、分离三维力学公式与黄昏群流现象。
- [[鸟粪生成与农作物施肥|Guano-Production-and-Crop-Fertilization]] — 倒吊积累计时器、骨粉农作物催熟与物理骨粉掉落。
- [[夜间趋光性与灯火环绕巡飞|Phototaxis-and-Light-Orbiting]] — 人工光源探测、飞蛾效应与平滑圆弧转向。
- [[害虫防治与俯冲捕食战斗|Pest-Control-and-Predatory-Combat]] — 蠹虫与末影螨锁定、俯冲攻击与遗传伤害加成。
- [[声学生物回声定位与惊恐散射|Acoustic-Echolocation-and-Panic]] — 幽匿灵魂粒子声学脉冲、潜行与奔跑震动惊醒。
- [[动物遗传学与翼展属性继承|Animal-Genetics-and-Trait-Inheritance]] — 翼展体型（0.75x–1.30x）、飞行移速与攻击伤害基因。
- [[动态游戏规则参考表|Dynamic-GameRules-Reference]] — `better-bats:better_bats` 下全部 9 项游戏规则详解。
- [[环境自然生成与权重调节|Ambient-Spawning-and-Weight-Modifiers]] — 夜间地表生成规则与洞穴生成权重动态替换。
- [[HUD 诊断与客户端配置界面|HUD-Diagnostics-and-Config-Screens]] — YetAnotherConfigLib (YACL v3) 菜单与 ModMenu 集成。
- [[指令与进度系统指南|Commands-and-Advancements-Guide]] — `/betterbats` 与 `/bb` 指令树、`/gamerule` 兼容性与原生进度触发。
- [[音效与视觉粒子参考|Sound-Effects-and-Visual-Particles]] — 粒子发射矩阵与音效事件定义。
- [[疑难解答与常见问题|Troubleshooting-and-FAQ]] — 启动崩溃排查、依赖解决与世界配置同步。

---

### 💻 开发者与技术参考
- [[系统架构与代码包布局|Architecture-and-Package-Layout]] — 单一功能原则、包结构与类职责划分。
- [[Mixin 字节码注入参考与挂钩点|Mixin-Reference-and-Hooks]] — 原版 `Bat`、`GameEventDispatcher` 与 `NaturalSpawner` 注入表。
- [[行为配置、目标优先级与状态访问器|Behavior-Profiles-and-Conditions]] — AI Goal 优先级矩阵与 `BatStateAccessor` 接口协议。
- [[第三方模组集成指南|Consumer-Mods-Integration-Guide]] — 通过 DasikLibrary API 读取蝙蝠基因与触发机制。

---

## 📜 署名与开源协议

Better Bats 是一款开源模组，由 **Dasik (Rifaditya)** 架构并开发，基于 **GNU 通用公共许可证 v3.0 (GPL-3.0-or-later)** 授权。
