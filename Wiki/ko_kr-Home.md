# 🦇 Better Bats 공식 위키 (Minecraft 26.1.2)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

**Better Bats**의 공식 문서 포털에 오신 것을 환영합니다. 본 모드는 Minecraft 26.1.2 Fabric 전용으로 설계된 생태계 오버홀 모드로, 박쥐(Chiroptera)의 인공지능을 완전히 개편합니다. 실감 나는 3차원 BOIDs 군집 비행(Murmuration), 조명 주변 궤도 선회(주광성), 낮 시간 동굴 복귀(주광 기피), 구아노 배설을 통한 농작물 뼛가루 시비, 좀벌레 및 엔더마이트 급강하 사냥, 진동 소음 패닉, 그리고 엔티티 유전학 시스템을 도입합니다.

> 📌 **저장소 소스코드 면책 조항**: 본 위키 문서는 **저장소 내의 최신 소스코드 상태**를 반영하고 있으며, CurseForge 및 Modrinth에 공식 배포되기 전의 개발 중인 기능이나 커밋이 포함될 수 있습니다.

---

## 🧭 위키 내비게이션

### 📦 플랫폼 및 빌드 가이드
- [[Minecraft 26.1 기술 설정 가이드|Minecraft-26.1-Guide]] — 플랫폼 요구사항 (JDK 25, Fabric Loader >=0.19.1, Fabric API 0.145.4+26.1.2).
- [[버전 및 로더 호환성 매트릭스|Version-Compatibility]] — 지원 버전, `ModVersionGuard` 런타임 검증 및 종속성 범위.
- [[개발 환경 설정 및 소스 빌드|Developer-Setup-and-Building]] — 데몬 없는 Gradle 9.3+ 빌드 (`--no-daemon`) 및 Loom 명령어.

---

### 🎮 플레이어 및 게임플레이 메커니즘
- [[박쥐 생태, 주광 기피 및 낮 휴식|Bat-Ecology-and-Photophobia]] — 낮 밝기 기준 및 휴식 가능 표면 (종유석, 랜턴, 사슬, 나뭇잎).
- [[3D BOIDs 군집 비행, 고도 제한 및 물리 벡터|3D-BOIDs-Flocking-and-Steering]] — 결집, 정렬, 분리 벡터 계산 및 황혼기 군집 이동.
- [[구아노 생산 및 농작물 자동 비료 시비|Guano-Production-and-Crop-Fertilization]] — 휴식 타이머, 뼛가루 작물 성장 및 아이템 드롭 설정.
- [[주광성 및 야간 랜턴 궤도 선회 비행|Phototaxis-and-Light-Orbiting]] — 인공 조명 탐지, 나방 효과(Moth Effect) 및 부드러운 곡선 선회.
- [[해충 구제 및 급강하 포식 공격|Pest-Control-and-Predatory-Combat]] — 좀벌레와 엔더마이트 사냥 및 유전 공격력 반영.
- [[동굴 음향 반향정위 및 진동 패닉|Acoustic-Echolocation-and-Panic]] — 스컬크 영혼 입자 음향 펄스 및 질주/폭발 시 공황 분산.
- [[동물 유전학 및 형질 유전 시스템|Animal-Genetics-and-Trait-Inheritance]] — 날개폭 크기(0.75배~1.30배), 비행 속도 및 공격력 형질.
- [[동적 게임 규칙(GameRules) 참조표|Dynamic-GameRules-Reference]] — `better-bats:better_bats` 하위 9개 게임 규칙 상세 설명.
- [[자연 스폰 및 가중치 조정|Ambient-Spawning-and-Weight-Modifiers]] — 야간 지표면 스폰 및 동굴 스폰 가중치 동적 교체.
- [[HUD 진단 및 클라이언트 설정 화면|HUD-Diagnostics-and-Config-Screens]] — YetAnotherConfigLib (YACL v3) 메뉴 및 ModMenu 통합.
- [[명령어 및 발전 과제 가이드|Commands-and-Advancements-Guide]] — `/betterbats` 및 `/bb` 명령어 트리, 바닐라 발전 과제 연동.
- [[음향 효과 및 시각 입자 레퍼런스|Sound-Effects-and-Visual-Particles]] — 파티클 방출 매트릭스 및 사운드 이벤트.
- [[문제 해결 및 자주 묻는 질문(FAQ)|Troubleshooting-and-FAQ]] — 시작 충돌 해결, 의존성 오류 및 월드 설정 동기화.

---

### 💻 개발자용 기술 레퍼런스
- [[아키텍처 및 패키지 구조|Architecture-and-Package-Layout]] — 단일 책임 원칙, 클래스 구조 및 모듈 설계.
- [[Mixin 바이트코드 주입 레퍼런스|Mixin-Reference-and-Hooks]] — `Bat`, `GameEventDispatcher`, `NaturalSpawner` 주입점.
- [[행동 프로필 및 상태 접근자(Accessor)|Behavior-Profiles-and-Conditions]] — AI Goal 우선순위 매트릭스 및 `BatStateAccessor` 인터페이스.
- [[타 모드 연동 및 확장 가이드|Consumer-Mods-Integration-Guide]] — DasikLibrary API를 통한 유전 정보 접근 및 트리거.

---

## 📜 저작권 및 라이선스

Better Bats는 오픈소스 소프트웨어로 **Dasik (Rifaditya)**에 의해 개발되었으며 **GNU General Public License v3.0 (GPL-3.0-or-later)** 하에 배포됩니다.
