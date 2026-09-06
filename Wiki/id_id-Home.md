# 🦇 Wiki Resmi Better Bats (Minecraft 26.1.2)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

Selamat datang di dokumentasi resmi **Better Bats**, mod Fabric untuk Minecraft 26.1.2 yang merombak total kecerdasan buatan (AI) kelelawar (Chiroptera). Mod ini menghadirkan pergerakan kawanan 3D BOIDs yang realistis (murmurasi), fototaksis mengitari lentera, fotofobia siang hari dengan kembali ke gua, pemupukan tanaman menggunakan kotoran kelelawar (guano), serangan menukik pemangsa kutu buku (silverfish) dan endermite, kepanikan terhadap getaran suara, serta sistem genetika entitas.

> 📌 **Pernyataan Sumber Kode Repositori**: Dokumentasi dalam Wiki ini mencerminkan **kondisi kode sumber terkini di dalam repositori**, yang mungkin memuat commit pengembangan terbaru sebelum dirilis secara publik di CurseForge dan Modrinth.

---

## 🧭 Navigasi Panduan Wiki

### 📦 Panduan Platform & Kompilasi
- [[Panduan Teknis Minecraft 26.1|Minecraft-26.1-Guide]] — Spesifikasi target platform (JDK 25, Fabric Loader >=0.19.1, Fabric API 0.145.4+26.1.2).
- [[Matriks Kompatibilitas Versi|Version-Compatibility]] — Versi yang didukung, perlindungan `ModVersionGuard`, dan dependensi pustaka.
- [[Pengaturan Lingkungan Pengembang & Build|Developer-Setup-and-Building]] — Kompilasi menggunakan Gradle 9.3+ tanpa daemon (`--no-daemon`) dan perintah Loom.

---

### 🎮 Panduan Pemain & Mekanika Gameplay
- [[Ekologi Kelelawar, Fotofobia & Tempat Bertengger|Bat-Ecology-and-Photophobia]] — Ambang batas cahaya siang dan permukaan bertengger valid (stalaktit, lentera, rantai, dedaunan).
- [[Kawanan 3D BOIDs, Batas Ketinggian & Vektor Fisika|3D-BOIDs-Flocking-and-Steering]] — Perhitungan kohesi, keselarasan, pemisahan, dan fenomena arus senja.
- [[Produksi Guano & Pemupukan Otomatis Tanaman|Guano-Production-and-Crop-Fertilization]] — Timer bertengger, efek tepung tulang, dan pengaturan drop item fisik.
- [[Fototaksis & Mengitari Cahaya Malam Hari|Phototaxis-and-Light-Orbiting]] — Pelacakan sumber cahaya, efek ngengat, dan pendekatan melengkung yang mulus.
- [[Pengendalian Hama & Serangan Menukik Predator|Pest-Control-and-Predatory-Combat]] — Perburuan silverfish dan endermite dengan penskalaan damage genetika.
- [[Ekolokasi Suara Gua Gelap & Kepanikan Getaran|Acoustic-Echolocation-and-Panic]] — Emisi partikel jiwa sculk dan respon panik terhadap lari cepat atau ledakan.
- [[Genetika Hewan & Pewarisan Ciri Fisik|Animal-Genetics-and-Trait-Inheritance]] — Variasi rentang sayap (0.75x–1.30x), kecepatan terbang, dan kekuatan serangan.
- [[Tabel Referensi GameRules Dinamis|Dynamic-GameRules-Reference]] — Panduan lengkap 9 GameRules di bawah namespace `better-bats:better_bats`.
- [[Spawn Alami & Pengubah Bobot Kemunculan|Ambient-Spawning-and-Weight-Modifiers]] — Kemunculan permukaan malam hari dan penggantian bobot spawn dalam gua.
- [[Diagnostik HUD & Layar Konfigurasi Klien|HUD-Diagnostics-and-Config-Screens]] — Antarmuka YetAnotherConfigLib (YACL v3) dan integrasi ModMenu.
- [[Panduan Perintah & Sistem Advancements|Commands-and-Advancements-Guide]] — Struktur perintah `/betterbats` dan `/bb`, serta kompatibilitas `/gamerule`.
- [[Referensi Efek Suara & Partikel Visual|Sound-Effects-and-Visual-Particles]] — Matriks emisi partikel dan daftar sound event.
- [[Pemecahan Masalah & Pertanyaan Umum (FAQ)|Troubleshooting-and-FAQ]] — Penanganan crash saat booting dan sinkronisasi konfigurasi dunia.

---

### 💻 Referensi Teknis Pengembang
- [[Arsitektur & Struktur Paket Kode|Architecture-and-Package-Layout]] — Prinsip satu berkas satu fungsi, struktur paket, dan pembagian kelas.
- [[Referensi Mixin & Titik Injeksi Bytecode|Mixin-Reference-and-Hooks]] — Tabel injeksi ke `Bat`, `GameEventDispatcher`, dan `NaturalSpawner`.
- [[Profil Perilaku AI & Pengakses Status (Accessor)|Behavior-Profiles-and-Conditions]] — Matriks prioritas AI Goal dan protokol antarmuka `BatStateAccessor`.
- [[Panduan Integrasi untuk Mod Pihak Ketiga|Consumer-Mods-Integration-Guide]] — Membaca genetika dan trigger menggunakan API DasikLibrary.

---

## 📜 Hak Cipta & Lisensi

Better Bats adalah perangkat lunak sumber terbuka yang dirancang dan dikembangkan oleh **Dasik (Rifaditya)** di bawah lisensi **GNU General Public License v3.0 (GPL-3.0-or-later)**.
