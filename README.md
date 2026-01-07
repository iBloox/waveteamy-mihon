# WaveTeamy Mihon Extension

A Mihon/Tachiyomi extension for reading Arabic manga from WaveTeamy.

## Features

- Browse popular manga
- View latest updates
- Search manga with proper URL encoding (supports Arabic text and special characters)
- Multi-language support (English, Arabic)

## Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── assets/
│   │   │   └── i18n/              # Internationalization files
│   │   │       ├── messages_en.properties
│   │   │       └── messages_ar.properties
│   │   ├── res/
│   │   │   ├── mipmap-*/          # Extension icons (various densities)
│   │   │   └── values/
│   │   │       └── public.xml     # Public resource declarations
│   │   ├── java/
│   │   │   └── eu/kanade/tachiyomi/
│   │   │       ├── source/        # Base source interfaces
│   │   │       └── extension/ar/waveteamy/
│   │   │           ├── WaveTeamy.kt        # Main source implementation
│   │   │           └── WaveTeamyFactory.kt # Source factory
│   │   └── AndroidManifest.xml
│   └── test/
│       └── java/                  # Unit tests
└── build.gradle
```

## Building

```bash
./gradlew assembleDebug
```

The APK will be generated in `app/build/outputs/apk/debug/`

## Installation

1. Build the extension APK
2. Install it on your device
3. Open Mihon/Tachiyomi
4. Go to Browse → Extensions
5. Enable WaveTeamy extension

## Development

### Requirements

- Android SDK 21+
- Kotlin 1.9.10+
- Gradle 8.2+

### Testing

```bash
./gradlew test
```

## Recent Fixes

- **URL Encoding Bug**: Fixed search functionality to properly encode Arabic text and special characters

## License

This extension is for educational purposes.
