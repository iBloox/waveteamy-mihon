# WaveTeamy Mihon Extension

<div align="center">

![WaveTeamy Icon](keiyoushi-extension/res/mipmap-xxxhdpi/ic_launcher.png)

**A complete, production-ready Mihon/Tachiyomi extension for WaveTeamy**

[![GitHub](https://img.shields.io/badge/GitHub-Repository-blue)](https://github.com/iBloox/waveteamy-mihon)
[![Keiyoushi](https://img.shields.io/badge/Keiyoushi-Ready-green)](https://github.com/keiyoushi/extensions-source)
[![Language](https://img.shields.io/badge/Language-Arabic-orange)](https://github.com/iBloox/waveteamy-mihon)

</div>

## 🎉 Extension Complete!

Your WaveTeamy extension is **ready to contribute** to the Keiyoushi repository!

## ✨ Features

- ✅ **Popular Manga** - Browse trending manga
- ✅ **Latest Updates** - See recent releases
- ✅ **Search** - Find manga with Arabic text support
- ✅ **Manga Details** - Full information (author, status, genres, description)
- ✅ **Chapter Reading** - Read all chapters with proper image loading
- ✅ **Cloudflare Support** - Automatic protection bypass
- ✅ **URL Encoding** - Proper handling of Arabic text and special characters

## 🚀 Quick Start

### Option 1: Contribute to Keiyoushi (Recommended)

```bash
# 1. Fork https://github.com/keiyoushi/extensions-source
# 2. Clone your fork
git clone https://github.com/YOUR_USERNAME/extensions-source.git
cd extensions-source

# 3. Copy the extension
cp -r /path/to/waveteamy-mihon/keiyoushi-extension src/ar/waveteamy

# 4. Build and test
./gradlew :src:ar:waveteamy:assembleDebug

# 5. Create PR
git checkout -b add-waveteamy-extension
git add src/ar/waveteamy
git commit -m "Add WaveTeamy extension (#ar)"
git push origin add-waveteamy-extension
```

See **[QUICK_START.md](QUICK_START.md)** for detailed steps.

### Option 2: Standalone Build

The standalone build requires Android SDK and won't work without the Tachiyomi extension library. See **[EXTENSION_FIX.md](EXTENSION_FIX.md)** for details.

## 📁 Project Structure

```
waveteamy-mihon/
├── keiyoushi-extension/          # ⭐ Ready-to-use extension
│   ├── build.gradle              # Build configuration
│   ├── res/                      # Icons (all densities)
│   └── src/                      # Source code
│       └── WaveTeamy.kt          # Main implementation
├── app/                          # Original standalone attempt
├── QUICK_START.md                # 🚀 Start here!
├── KEIYOUSHI_CONTRIBUTION_GUIDE.md  # Detailed guide
├── EXTENSION_FIX.md              # Technical analysis
└── BUILD_INSTRUCTIONS.md         # Build info
```

## 📖 Documentation

- **[QUICK_START.md](QUICK_START.md)** - Fast track to publishing (5 minutes)
- **[KEIYOUSHI_CONTRIBUTION_GUIDE.md](KEIYOUSHI_CONTRIBUTION_GUIDE.md)** - Complete guide with testing tips
- **[EXTENSION_FIX.md](EXTENSION_FIX.md)** - Technical details and issues found
- **[BUILD_INSTRUCTIONS.md](BUILD_INSTRUCTIONS.md)** - Build system information

## 🔧 Technical Details

### Implementation
- **Base Class:** `ParsedHttpSource` (Keiyoushi standard)
- **Parsing:** Jsoup HTML selectors
- **URL Encoding:** `HttpUrl.Builder` for proper Arabic support
- **Protection:** Cloudflare client integration
- **Date Parsing:** SimpleDateFormat with Arabic locale support

### Selectors (WordPress/Madara pattern)
```kotlin
popularMangaSelector = "div.page-item-detail"
chapterListSelector = "li.wp-manga-chapter"
pageListSelector = "div.reading-content img, div.page-break img"
```

## 🎯 What's Next?

1. **Fork Keiyoushi** - https://github.com/keiyoushi/extensions-source
2. **Copy Extension** - From `keiyoushi-extension/` to `src/ar/waveteamy`
3. **Test** - Build and test on your device
4. **Submit PR** - Contribute to Keiyoushi
5. **Publish** - Automatic after merge

## 🐛 Issues Found & Fixed

During development, we discovered and fixed:
- ❌ Missing Tachiyomi extension library
- ❌ Incomplete parse method implementations
- ❌ Wrong build configuration
- ✅ Created proper Keiyoushi-compatible extension
- ✅ Implemented all required parsing methods
- ✅ Added proper URL encoding for Arabic text

## 🤝 Contributing

This extension is ready to be contributed to Keiyoushi. Follow the guide in [KEIYOUSHI_CONTRIBUTION_GUIDE.md](KEIYOUSHI_CONTRIBUTION_GUIDE.md).

## 📝 License

This extension follows the Keiyoushi extensions license (Apache 2.0).

## 🙏 Credits

- **Keiyoushi Team** - Extension framework and repository
- **Mihon/Tachiyomi** - Manga reader app
- **WaveTeamy** - Manga source

## 💬 Support

- **Keiyoushi Discord:** https://discord.gg/3FbCpdKbdY
- **Documentation:** https://keiyoushi.github.io/docs/
- **Issues:** https://github.com/iBloox/waveteamy-mihon/issues

---

<div align="center">

**Ready to publish your extension? Start with [QUICK_START.md](QUICK_START.md)!**

Made with ❤️ for the Arabic manga community

</div>
