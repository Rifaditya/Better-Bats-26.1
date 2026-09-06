# 🦇 更好的蝙蝠 (Better Bats) 官方維基 (Minecraft 26.1.2)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

歡迎來到 **Better Bats** 的官方維基文檔中心。Better Bats 是一款專為 Minecraft 26.1.2 Fabric 環境打造的生態強化模組，徹底重構了原版蝙蝠（Chiroptera）的 AI 邏輯。引入逼真的三維 BOIDs 群飛算法（Murmuration）、趨光環繞巡飛、白天避光返洞棲息、地下鳥糞（Guano）農田施肥、蠹蟲與終界蟎俯衝獵殺、聲學震動驚恐散射以及實體遺傳學系統。

> 📌 **倉庫源碼免責聲明**：本維基文檔反映了**當前倉庫中的源碼開發狀態**，可能包含先於 CurseForge 與 Modrinth 公開發布版本的最新開發提交或未發布特性。

---

## 🧭 維基導航索引

### 📦 平臺與構建指南
- [[MC 26.1 安裝與技術指南|Minecraft-26.1-Guide]] — 核心目標平臺配置（JDK 25, Fabric Loader >=0.19.1, Fabric API 0.145.4+26.1.2）。
- [[版本與加載器相容性矩陣|Version-Compatibility]] — 支援版本、`ModVersionGuard` 運行時安全檢查與依賴範圍。
- [[從源碼構建開發環境|Developer-Setup-and-Building]] — Gradle 9.3+ 無守護進程構建與 Loom 指令。

---

### 🎮 玩家與遊戲機制指南
- [[蝙蝠生態、避光性與日間棲息|Bat-Ecology-and-Photophobia]] — 白天避光閾值、倒掛棲息表面（鐘乳石、吊燈、鐵鍊、樹葉）。
- [[三維 BOIDs 群飛、飛行限高與轉向數學|3D-BOIDs-Flocking-and-Steering]] — 凝聚、對齊、分離三維力學公式與黃昏群流現象。
- [[鳥糞生成與農作物施肥|Guano-Production-and-Crop-Fertilization]] — 倒掛累積計時器、骨粉農作物催熟與物理骨粉掉落。
- [[夜間趨光性與燈火環繞巡飛|Phototaxis-and-Light-Orbiting]] — 人工光源探測、飛蛾效應與平滑圓弧轉向。
- [[害蟲防治與俯衝捕食戰鬥|Pest-Control-and-Predatory-Combat]] — 蠹蟲與終界蟎鎖定、俯衝攻擊與遺傳傷害加成。
- [[聲學生物回聲定位與驚恐散射|Acoustic-Echolocation-and-Panic]] — 幽匿靈魂粒子聲學脈衝、潛行與奔跑震動驚醒。
- [[動物遺傳學與翼展屬性繼承|Animal-Genetics-and-Trait-Inheritance]] — 翼展體型（0.75x–1.30x）、飛行移速與攻擊傷害基因。
- [[動態遊戲規則參考表|Dynamic-GameRules-Reference]] — `better-bats:better_bats` 下全部 9 項遊戲規則詳解。
- [[環境自然生成與權重調節|Ambient-Spawning-and-Weight-Modifiers]] — 夜間地表生成規則與洞穴生成權重動態替換。
- [[HUD 診斷與客戶端配置介面|HUD-Diagnostics-and-Config-Screens]] — YetAnotherConfigLib (YACL v3) 選單與 ModMenu 整合。
- [[指令與進度系統指南|Commands-and-Advancements-Guide]] — `/betterbats` 與 `/bb` 指令樹、`/gamerule` 相容性與原生進度觸發。
- [[音效與視覺粒子參考|Sound-Effects-and-Visual-Particles]] — 粒子發射矩陣與音效事件定義。
- [[疑難解答與常見問題|Troubleshooting-and-FAQ]] — 啟動崩潰排查、依賴解決與世界配置同步。

---

### 💻 開發者與技術參考
- [[系統架構與代碼包佈局|Architecture-and-Package-Layout]] — 單一功能原則、包結構與類職責劃分。
- [[Mixin 字節碼注入參考與掛鉤點|Mixin-Reference-and-Hooks]] — 原版 `Bat`、`GameEventDispatcher` 與 `NaturalSpawner` 注入表。
- [[行為配置、目標優先級與狀態訪問器|Behavior-Profiles-and-Conditions]] — AI Goal 優先級矩陣與 `BatStateAccessor` 介面協議。
- [[第三方模組整合指南|Consumer-Mods-Integration-Guide]] — 透過 DasikLibrary API 讀取蝙蝠基因與觸發機制。

---

## 📜 署名與開源協議

Better Bats 是一款開源模組，由 **Dasik (Rifaditya)** 架構並開發，基於 **GNU 通用公共許可證 v3.0 (GPL-3.0-or-later)** 授權。
