# 🦇 Better Bats 公式ウィキ (Minecraft 26.1.2)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

**Better Bats** の公式ドキュメントポータルへようこそ。本Modは Minecraft 26.1.2 Fabric 向けに開発された生態拡張Modであり、コウモリ（Chiroptera）のAIを根本から刷新します。リアルな3次元BOIDs群集アルゴリズム（群飛・ムルムレーション）、ランタンへの走光性旋回、昼間の走光忌避洞窟帰還、洞窟内グアノ（コウモリ糞）による作物自動施肥、シミ・エンダーマイトへの急降下捕食攻撃、音響振動パニック、そしてエンティティ遺伝子システムを搭載しています。

> 📌 **リポジトリソース免責事項**: 本ウィキの記載内容は**リポジトリ内の現在のソースコード開発状態**を反映しており、CurseForge や Modrinth での一般公開リリース前の最新コミットや開発中機能を含む場合があります。

---

## 🧭 ウィキナビゲーション

### 📦 プラットフォーム＆ビルドガイド
- [[Minecraft 26.1 技術導入ガイド|Minecraft-26.1-Guide]] — プラットフォーム要件（JDK 25, Fabric Loader >=0.19.1, Fabric API 0.145.4+26.1.2）。
- [[バージョン＆ローダー互換性マトリクス|Version-Compatibility]] — 対応バージョン、`ModVersionGuard` 実行時保護、依存関係。
- [[開発環境構築とソースコードビルド|Developer-Setup-and-Building]] — Gradle 9.3+ 非デーモンビルド（`--no-daemon`）と Loom コマンド。

---

### 🎮 プレイヤー＆ゲームメカニクス
- [[コウモリの生態、走光忌避と昼間休息|Bat-Ecology-and-Photophobia]] — 明るさ判定と有効なぶら下がり休息面（鍾乳石、ランタン、鎖、木の葉）。
- [[3D BOIDs群飛、高度上限と物理ベクトル計算|3D-BOIDs-Flocking-and-Steering]] — 結合・整列・分離の3次元物理演算と薄暮時の群集ストリーミング。
- [[グアノ生成と農作物自動骨粉施肥|Guano-Production-and-Crop-Fertilization]] — 休息蓄積タイマー、骨粉成長判定、物理アイテム化設定。
- [[走光性と夜間の灯火旋回飛行|Phototaxis-and-Light-Orbiting]] — 光源検知、蛾効果（Moth Effect）、滑らかなバンク旋回アプローチ。
- [[害虫駆除と急降下捕食戦闘|Pest-Control-and-Predatory-Combat]] — シミおよびエンダーマイトの索敵と遺伝補正攻撃力。
- [[洞窟音響エコーロケーションと振動パニック|Acoustic-Echolocation-and-Panic]] — スカルクソウル粒子パルス、ダッシュや採掘振動による群れ散開。
- [[動物遺伝学と翼幅・ステータス遺伝|Animal-Genetics-and-Trait-Inheritance]] — 個体翼幅（0.75倍〜1.30倍）、飛行速度、攻撃力遺伝子。
- [[動的ゲームルールリファレンス表|Dynamic-GameRules-Reference]] — `better-bats:better_bats` 配下の全9種GameRule解説。
- [[環境スポーンと出現ウェイト調整|Ambient-Spawning-and-Weight-Modifiers]] — 夜間地上スポーン判定と洞窟内出現確率の動的置換。
- [[HUD診断とクライアント設定画面|HUD-Diagnostics-and-Config-Screens]] — YetAnotherConfigLib (YACL v3) メニューと ModMenu 連携。
- [[コマンド＆進捗システムガイド|Commands-and-Advancements-Guide]] — `/betterbats` および `/bb` コマンドツリー、`/gamerule` 互換性。
- [[効果音とビジュアルパーティクル一覧|Sound-Effects-and-Visual-Particles]] — パーティクル放出マトリクスとサウンドイベント。
- [[トラブルシューティングとFAQ|Troubleshooting-and-FAQ]] — 起動クラッシュの診断、依存関係エラー、ワールド設定同期。

---

### 💻 開発者向け技術リファレンス
- [[アーキテクチャとパッケージ構造|Architecture-and-Package-Layout]] — 単一責任の原則、クラス責務とモジュール設計。
- [[Mixinバイトコード注入リファレンス|Mixin-Reference-and-Hooks]] — `Bat`, `GameEventDispatcher`, `NaturalSpawner` への注入点。
- [[AI行動プロファイルと状態アクセサ|Behavior-Profiles-and-Conditions]] — AI Goal 優先順位マトリクスと `BatStateAccessor` プロトコル。
- [[他Modからの連携・拡張ガイド|Consumer-Mods-Integration-Guide]] — DasikLibrary API を用いた遺伝子読み取りとトリガー。

---

## 📜 著作権とライセンス

Better Bats はオープンソースソフトウェアであり、**Dasik (Rifaditya)** によって開発され、**GNU General Public License v3.0 (GPL-3.0-or-later)** の下で公開されています。
