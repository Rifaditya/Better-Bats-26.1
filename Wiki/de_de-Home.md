# 🦇 Better Bats Wiki (Minecraft 26.1.2)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

Willkommen in der offiziellen Wiki-Dokumentation für **Better Bats**, einer umfassenden Fabric-Modifikation für Minecraft 26.1.2, die das Verhalten von Fledermäusen (Chiroptera) grundlegend überarbeitet. Enthalten sind realistische 3D-BOIDs-Schwarmmechaniken (Murmuration), phototaktisches Umkreisen von Lichtquellen, tagaktive Photophobie mit Rückkehr in Höhlen, Guano-Düngung von Ackerflächen, stürzende Jagdangriffe auf Silberfischchen und Endermiten, akustische Panikreaktionen sowie genetische Vererbung.

> 📌 **Quellcode-Haftungsausschluss**: Die Dokumentation in diesem Wiki spiegelt den **aktuellen Quellcode-Stand im Repository** wider, welcher unvollendete Entwicklungsstände oder unveröffentlichte Commits vor dem offiziellen Release auf CurseForge und Modrinth enthalten kann.

---

## 🧭 Wiki-Navigation

### 📦 Plattform- & Installationsanleitungen
- [[Minecraft 26.1 Technische Anleitung|Minecraft-26.1-Guide]] — Plattformspezifikationen (JDK 25, Fabric Loader >=0.19.1, Fabric API 0.145.4+26.1.2).
- [[Versionskompatibilitäts-Matrix|Version-Compatibility]] — Unterstützte Versionen, `ModVersionGuard`-Laufzeitprüfung und Abhängigkeiten.
- [[Entwicklungsumgebung & Kompilierung|Developer-Setup-and-Building]] — Kompilierung mit Gradle 9.3+ ohne Daemon (`--no-daemon`) und Loom-Befehle.

---

### 🎮 Gameplay- & Mechanik-Leitfäden
- [[Fledermaus-Ökologie, Photophobie & Schlafplätze|Bat-Ecology-and-Photophobia]] — Lichtgrenzwerte und Ruheflächen (Tropfsteine, Laternen, Ketten, Laub).
- [[3D-BOIDs-Schwarmbildung, Höhenbegrenzung & Physik|3D-BOIDs-Flocking-and-Steering]] — Kohäsions-, Ausrichtungs- und Separationskräfte bei Dämmerung.
- [[Guano-Produktion & Erntedüngung|Guano-Production-and-Crop-Fertilization]] — Ruhetimer, Knochenmehl-Wachstumsschübe und physischer Gegenstandsabwurf.
- [[Phototaxis & Nächtliches Lichtumkreisen|Phototaxis-and-Light-Orbiting]] — Erkennung künstlicher Lichtquellen, Motteneffekt und Kurvenflug.
- [[Schädlingsbekämpfung & Sturzangriffe|Pest-Control-and-Predatory-Combat]] — Jagd auf Silberfischchen und Endermiten mit genetischem Schadensbonus.
- [[Akustische Echolokation & Panikreaktionen|Acoustic-Echolocation-and-Panic]] — Sculk-Seelenpartikel, Erschütterungserkennung und Fluchtvektoren.
- [[Tiergenetik & Vererbbare Merkmale|Animal-Genetics-and-Trait-Inheritance]] — Flügelspannweite (0.75x–1.30x), Fluggeschwindigkeit und Angriffskraft.
- [[Dynamische GameRules-Referenztabelle|Dynamic-GameRules-Reference]] — Übersicht über alle 9 GameRules unter `better-bats:better_bats`.
- [[Umgebungs-Spawning & Gewichtungsmodifikatoren|Ambient-Spawning-and-Weight-Modifiers]] — Nächtliches Oberflächen-Spawning und Gewichtungsanpassung in Höhlen.
- [[HUD-Diagnostik & Client-Konfiguration|HUD-Diagnostics-and-Config-Screens]] — YetAnotherConfigLib (YACL v3)-Menü und ModMenu-Integration.
- [[Befehls- & Fortschrittsleitfaden|Commands-and-Advancements-Guide]] — Befehlsbaum für `/betterbats` und `/bb`, Vanilla-Kompatibilität.
- [[Soundeffekte & Partikelemissions-Referenz|Sound-Effects-and-Visual-Particles]] — Verzeichnis aller Partikel und Klangereignisse.
- [[Fehlerbehebung & Häufige Fragen|Troubleshooting-and-FAQ]] — Diagnose von Startfehlern und Weltkonfigurations-Synchronisation.

---

### 💻 Technische Referenz für Entwickler
- [[Architektur & Paketstruktur|Architecture-and-Package-Layout]] — Single-Responsibility-Prinzip und Klassenhierarchie.
- [[Mixin-Referenz & Injektionspunkte|Mixin-Reference-and-Hooks]] — Bytecode-Injektionen in `Bat`, `GameEventDispatcher` und `NaturalSpawner`.
- [[Verhaltensprofile & Status-Zugriffsmethoden|Behavior-Profiles-and-Conditions]] — AI-Ziel-Prioritätsmatrix und `BatStateAccessor`-Schnittstelle.
- [[Entwickler-Integrationsleitfaden|Consumer-Mods-Integration-Guide]] — Auslesen von Merkmalen und Triggern über die DasikLibrary-API.

---

## 📜 Urheberrecht & Lizenz

Better Bats ist Open-Source-Software, entwickelt von **Dasik (Rifaditya)** und lizenziert unter der **GNU General Public License v3.0 (GPL-3.0-or-later)**.
