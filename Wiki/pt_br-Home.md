# 🦇 Wiki do Better Bats (Minecraft 26.1.2)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

Boas-vindas à documentação oficial do **Better Bats**, um mod completo para Minecraft 26.1.2 Fabric que recria totalmente o comportamento dos morcegos (Chiroptera). O mod implementa revoada 3D realista com algoritmo BOIDs (murmuração), fototaxia orbital em torno de tochas e lanternas, fotofobia diurna com recolhimento para cavernas, fertilização de plantações com guano, combate predatório em mergulho contra traças e endermites, pânico por vibrações acústicas e genética de entidades.

> 📌 **Aviso Legal sobre o Código Fonte do Repositório**: A documentação nesta Wiki reflete o **estado atual do código-fonte no repositório**, podendo incluir commits recentes em desenvolvimento antes de serem lançados no CurseForge e Modrinth.

---

## 🧭 Navegação pela Wiki

### 📦 Guias de Plataforma e Instalação
- [[Guia Técnico do Minecraft 26.1|Minecraft-26.1-Guide]] — Especificações técnicas (JDK 25, Fabric Loader >=0.19.1, Fabric API 0.145.4+26.1.2).
- [[Matriz de Compatibilidade de Versões|Version-Compatibility]] — Versões suportadas, checagem `ModVersionGuard` e dependências.
- [[Ambiente de Desenvolvimento e Compilação|Developer-Setup-and-Building]] — Compilação com Gradle 9.3+ sem daemon (`--no-daemon`) e Loom.

---

### 🎮 Guias de Jogabilidade e Mecânicas
- [[Ecologia dos Morcegos, Fotofobia e Poleiros|Bat-Ecology-and-Photophobia]] — Limiares de luminosidade diurna e superfícies de repouso válidas (estalactites, lanternas, correntes, folhas).
- [[Revoadas 3D BOIDs, Limites de Altitude e Física|3D-BOIDs-Flocking-and-Steering]] — Forças vetoriais de coesão, alinhamento e separação ao entardecer.
- [[Produção de Guano e Fertilização Agrícola|Guano-Production-and-Crop-Fertilization]] — Temporizadores de repouso, efeito de farinha de osso e drop físico de itens.
- [[Fototaxia e Órbita Noturna de Luzes|Phototaxis-and-Light-Orbiting]] — Detecção de fontes de luz, efeito mariposa e curvas suaves de aproximação.
- [[Controle de Pragas e Combate Predatório|Pest-Control-and-Predatory-Combat]] — Ataque em mergulho contra traças e endermites com dano genético.
- [[Ecolocalização Acústica e Pânico por Vibração|Acoustic-Echolocation-and-Panic]] — Pulsos sónicos com partículas de alma do sculk e dispersão por passos ou explosões.
- [[Genética Animal e Herança de Características|Animal-Genetics-and-Trait-Inheritance]] — Envergadura (0.75x–1.30x), velocidade de voo e multiplicador de ataque.
- [[Tabela de Regras de Jogo Dinâmicas|Dynamic-GameRules-Reference]] — Todas as 9 GameRules sob o namespace `better-bats:better_bats`.
- [[Spawn Ambiente e Modificadores de Peso|Ambient-Spawning-and-Weight-Modifiers]] — Spawn na superfície noturna e peso dinâmico de geração subterrânea.
- [[Diagnósticos HUD e Menus de Configuração|HUD-Diagnostics-and-Config-Screens]] — Menus com YetAnotherConfigLib (YACL v3) e integração ao ModMenu.
- [[Guia de Comandos e Conquistas|Commands-and-Advancements-Guide]] — Árvore de comandos `/betterbats` e `/bb`, compatibilidade com `/gamerule`.
- [[Efeitos Sonoros e Matriz de Partículas|Sound-Effects-and-Visual-Particles]] — Matriz de emissão de partículas e eventos de áudio.
- [[Solução de Problemas e Perguntas Frequentes|Troubleshooting-and-FAQ]] — Resolução de travamentos no início e sincronização de mundo.

---

### 💻 Referência Técnica para Desenvolvedores
- [[Arquitetura e Estrutura de Pacotes|Architecture-and-Package-Layout]] — Princípio de responsabilidade única e arquitetura de classes.
- [[Referência de Mixins e Pontos de Injeção|Mixin-Reference-and-Hooks]] — Injeções em `Bat`, `GameEventDispatcher` e `NaturalSpawner`.
- [[Perfis de Comportamento e Métodos de Acesso|Behavior-Profiles-and-Conditions]] — Matriz de prioridades e protocolo `BatStateAccessor`.
- [[Guia de Integração para Outros Mods|Consumer-Mods-Integration-Guide]] — Integração via DasikLibrary API e leitura de genética.

---

## 📜 Direitos Autorais e Licença

Better Bats é software de código aberto desenvolvido por **Dasik (Rifaditya)** e licenciado sob a **GNU General Public License v3.0 (GPL-3.0-or-later)**.
