# WaveTeamy Extension - Build Instructions

## ✅ Source Files Verified

### Extension Source Code
```
app/src/main/java/eu/kanade/tachiyomi/extension/ar/waveteamy/
├── WaveTeamy.kt          ✅ Main extension with URL encoding fix
└── WaveTeamyFactory.kt   ✅ Source factory
```

### Resources
```
app/src/main/res/
├── mipmap-mdpi/ic_launcher.png      ✅ 48x48
├── mipmap-hdpi/ic_launcher.png      ✅ 72x72
├── mipmap-xhdpi/ic_launcher.png     ✅ 96x96
├── mipmap-xxhdpi/ic_launcher.png    ✅ 144x144
├── mipmap-xxxhdpi/ic_launcher.png   ✅ 192x192
└── values/public.xml                ✅ Resource declarations
```

### Configuration
```
gradle.properties:
✅ android.useAndroidX=true
✅ android.enableJetifier=true
```

## 📦 Getting the APK

### Option 1: Download from GitHub Actions (Recommended)

The extension is automatically built by GitHub Actions when code is pushed to main.

**Steps:**
1. Go to: https://github.com/iBloox/waveteamy-mihon/actions
2. Click on the latest "Build Mihon Extension APK" workflow run
3. Scroll down to "Artifacts" section
4. Download "waveteamy-apk"
5. Extract the ZIP file to get `app-debug.apk`

### Option 2: Build Locally (Requires Android SDK)

If you have Android SDK installed:

```bash
# Set Android SDK location (if not already set)
export ANDROID_HOME=/path/to/android/sdk

# Build the APK
./gradlew :app:assembleDebug

# APK will be at:
# app/build/outputs/apk/debug/app-debug.apk
```

### Option 3: Use GitHub CLI

If you have GitHub CLI authenticated:

```bash
# List recent workflow runs
gh run list -L 5 --workflow=android-build.yml

# Download the latest APK artifact
LATEST_RUN=$(gh run list -L 1 --workflow=android-build.yml --json databaseId -q '.[0].databaseId')
gh run download $LATEST_RUN -D ./apk

# APK will be in ./apk/waveteamy-apk/
```

## 📱 Installing on Your Device

### Method 1: Direct Install
1. Transfer `app-debug.apk` to your Android device
2. Open the APK file
3. Allow installation from unknown sources if prompted
4. Install the extension

### Method 2: ADB Install
```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```

## 🔧 Using the Extension

1. Open Mihon/Tachiyomi app
2. Go to **Browse** → **Extensions**
3. Find "WaveTeamy" in the list
4. Enable the extension
5. Start browsing Arabic manga!

## ✨ Features

- ✅ Browse popular manga
- ✅ View latest updates
- ✅ Search with proper URL encoding (supports Arabic text and special characters)
- ✅ Multi-language support (English/Arabic)
- ✅ Official WaveTeamy branding

## 🐛 Bug Fixes Included

- **URL Encoding Fix**: Search queries now properly encode Arabic text, spaces, and special characters
- **Proper Extension Structure**: Follows standard Mihon extension format
- **Comprehensive Tests**: Unit tests ensure search functionality works correctly

## 📝 Notes

- This is a debug build (not signed for production)
- The extension requires Mihon or compatible Tachiyomi fork
- Minimum Android version: 5.0 (API 21)
- Target Android version: 14 (API 34)

## 🔗 Links

- **Repository**: https://github.com/iBloox/waveteamy-mihon
- **GitHub Actions**: https://github.com/iBloox/waveteamy-mihon/actions
- **Issues**: https://github.com/iBloox/waveteamy-mihon/issues
