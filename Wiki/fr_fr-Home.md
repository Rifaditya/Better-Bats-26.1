# 🦇 Wiki Better Bats (Minecraft 26.1.2)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

Bienvenue sur la documentation officielle de **Better Bats**, un mod Fabric pour Minecraft 26.1.2 révisant intégralement le comportement des chauves-souris (Chiroptera). Ce mod apporte des vols en nuées 3D réalistes (algorithme BOIDs / murmuration), une attirance phototaxique en orbite autour des lanternes, une photophobie diurne avec retour sous terre, la fertilisation des cultures par le guano, des attaques prédatrices en piqué contre les poissons d'argent et endermites, la panique face aux vibrations acoustiques, ainsi que la génétique animale.

> 📌 **Avertissement sur le Code Source du Répertoire** : La documentation de ce Wiki reflète **l'état actuel du code source dans le dépôt**, incluant potentiellement des fonctionnalités en cours de développement avant publication sur CurseForge et Modrinth.

---

## 🧭 Navigation dans le Wiki

### 📦 Guides de Plateforme et Compilation
- [[Guide Technique Minecraft 26.1|Minecraft-26.1-Guide]] — Prérequis techniques (JDK 25, Fabric Loader >=0.19.1, Fabric API 0.145.4+26.1.2).
- [[Matrice de Compatibilité des Versions|Version-Compatibility]] — Versions supportées, garde d'exécution `ModVersionGuard` et dépendances.
- [[Environnement de Développement et Compilation|Developer-Setup-and-Building]] — Compilation avec Gradle 9.3+ sans démon (`--no-daemon`) et Loom.

---

### 🎮 Mécaniques de Jeu pour Joueurs
- [[Écologie, Photophobie et Perchoirs Diurnes|Bat-Ecology-and-Photophobia]] — Seuils de luminosité et surfaces d'accroche (stalactites, lanternes, chaînes, feuilles).
- [[Nuées 3D BOIDs, Plafond d'Altitude et Physique|3D-BOIDs-Flocking-and-Steering]] — Vecteurs de cohésion, alignement et séparation au crépuscule.
- [[Production de Guano et Fertilisation des Sols|Guano-Production-and-Crop-Fertilization]] — Minuteurs de repos, fertilisation par poudre d'os et objets physiques.
- [[Phototaxie et Orbite Nocturne des Lanternes|Phototaxis-and-Light-Orbiting]] — Détection des lumières, effet papillon de nuit et virages incurvés.
- [[Contrôle des Nuisibles et Attaque en Piqué|Pest-Control-and-Predatory-Combat]] — Chasse aux poissons d'argent et endermites avec dégâts génétiques.
- [[Écholocalisation Acoustique et Panique|Acoustic-Echolocation-and-Panic]] — Pulsations de particules d'âmes de sculk et fuite face aux bruits de pas rapides.
- [[Génétique Animale et Traits Héréditaires|Animal-Genetics-and-Trait-Inheritance]] — Envergure (0.75x–1.30x), vitesse de vol et puissance d'attaque.
- [[Tableau des Règles de Jeu Dynamiques|Dynamic-GameRules-Reference]] — Guide exhaustif des 9 GameRules dans `better-bats:better_bats`.
- [[Génération Ambiante et Modificateurs de Poids|Ambient-Spawning-and-Weight-Modifiers]] — Apparition nocturne en surface et ajustement des poids en caverne.
- [[Diagnostics HUD et Menus de Configuration|HUD-Diagnostics-and-Config-Screens]] — Interface YetAnotherConfigLib (YACL v3) et intégration ModMenu.
- [[Guide des Commandes et Progrès|Commands-and-Advancements-Guide]] — Arborescence des commandes `/betterbats` et `/bb`, compatibilité `/gamerule`.
- [[Effets Sonores et Répertoire des Particules|Sound-Effects-and-Visual-Particles]] — Matrice d'émission de particules et événements sonores.
- [[Dépannage et Foire Aux Questions|Troubleshooting-and-FAQ]] — Résolution des plantages au démarrage et synchronisation de monde.

---

### 💻 Référence pour Développeurs
- [[Architecture et Organisation des Paquets|Architecture-and-Package-Layout]] — Principe de responsabilité unique et hiérarchie logicielle.
- [[Référence des Mixins et Points d'Injection|Mixin-Reference-and-Hooks]] — Injections bytecode dans `Bat`, `GameEventDispatcher` et `NaturalSpawner`.
- [[Profils de Comportement et Accesseurs d'État|Behavior-Profiles-and-Conditions]] — Matrice de priorité des buts AI et protocole `BatStateAccessor`.
- [[Guide d'Intégration pour Autres Mods|Consumer-Mods-Integration-Guide]] — Exploitation de l'API DasikLibrary et lecture de génétique.

---

## 📜 Droits d'Auteur et Licence

Better Bats est un logiciel libre développé par **Dasik (Rifaditya)** sous licence **GNU General Public License v3.0 (GPL-3.0-or-later)**.
