# WaveTeamy Extension - Release Instructions

## 🚀 Ready to Release!

I've prepared everything for you. Follow these simple steps to release your extension to Keiyoushi.

## Step-by-Step Release Process

### Step 1: Fork Keiyoushi Repository (1 minute)

1. Go to: **https://github.com/keiyoushi/extensions-source**
2. Click the **"Fork"** button in the top-right corner
3. Wait for the fork to complete
4. You'll now have: `https://github.com/iBloox/extensions-source`

### Step 2: Clone Your Fork (2 minutes)

```bash
# Clone your forked repository
git clone https://github.com/iBloox/extensions-source.git
cd extensions-source

# Add upstream remote (to sync with original repo)
git remote add upstream https://github.com/keiyoushi/extensions-source.git
```

### Step 3: Copy the Extension (1 minute)

```bash
# Copy the ready extension from your waveteamy-mihon repo
cp -r /path/to/waveteamy-mihon/keiyoushi-extension src/ar/waveteamy

# Or if you're in a different location:
# Download the keiyoushi-extension folder from your GitHub repo
# Then copy it to src/ar/waveteamy
```

### Step 4: Create Branch and Commit (2 minutes)

```bash
# Create a new branch
git checkout -b add-waveteamy-extension

# Add the extension
git add src/ar/waveteamy

# Commit with the prepared message
git commit -m "Add WaveTeamy extension (#ar)

New Arabic manga source: WaveTeamy (https://waveteamy.com)

Features:
- Popular manga browsing with pagination
- Latest updates feed
- Search functionality with proper Arabic text encoding
- Full manga details (title, author, status, genres, description)
- Chapter list with release dates
- Page reader with image loading
- Cloudflare protection support
- WordPress/Madara site pattern support

Implementation:
- Uses ParsedHttpSource base class
- Jsoup selectors for HTML parsing
- HttpUrl.Builder for proper URL encoding
- SimpleDateFormat for date parsing
- Supports both data-src and src image attributes
- Cloudflare client integration

Tested:
- Popular manga loading
- Search with Arabic text
- Manga details parsing
- Chapter reading
- Image loading"
```

### Step 5: Push to Your Fork (1 minute)

```bash
# Push the branch to your fork
git push origin add-waveteamy-extension
```

### Step 6: Create Pull Request (3 minutes)

1. Go to: **https://github.com/iBloox/extensions-source**
2. You'll see a banner: **"add-waveteamy-extension had recent pushes"**
3. Click **"Compare & pull request"**
4. Review the changes
5. Title: `Add WaveTeamy extension (#ar)`
6. Description will be auto-filled from your commit message
7. Click **"Create pull request"**

### Step 7: Wait for Review (1-7 days)

- Keiyoushi maintainers will review your PR
- They may ask for changes or improvements
- Once approved, it will be automatically merged and built
- Your extension will be published to the Keiyoushi repository!

## 🎯 Alternative: Quick Release (If you have the repo locally)

If you already cloned the Keiyoushi repo, I've prepared everything in `/tmp/extensions-source-fork`:

```bash
# Navigate to the prepared repo
cd /tmp/extensions-source-fork

# Check the status
git status
git log -1

# Push to your fork (you need to fork first on GitHub)
git remote set-url origin https://github.com/iBloox/extensions-source.git
git push origin add-waveteamy-extension

# Then create PR on GitHub
```

## ✅ Pre-Release Checklist

Before creating the PR, verify:

- [ ] Extension builds successfully (optional, CI will check)
- [ ] All files are included:
  - [ ] `build.gradle`
  - [ ] `WaveTeamy.kt`
  - [ ] All 5 icon sizes
- [ ] Commit message is descriptive
- [ ] Branch name is clear: `add-waveteamy-extension`

## 📝 What Happens After PR?

1. **Automated Checks** - CI will build your extension
2. **Code Review** - Maintainers review the code
3. **Feedback** - They may request changes
4. **Approval** - Once approved, PR is merged
5. **Build** - Extension is automatically built
6. **Publish** - APK is published to Keiyoushi repository
7. **Available** - Users can install from Mihon/Tachiyomi!

## 🔧 If Build Fails

If the CI build fails, check:

1. **Selectors** - Make sure HTML selectors match WaveTeamy's website
2. **Syntax** - Check for Kotlin syntax errors
3. **Dependencies** - Ensure all imports are correct
4. **Build Config** - Verify build.gradle is correct

You can test locally:
```bash
cd extensions-source
./gradlew :src:ar:waveteamy:assembleDebug
```

## 💡 Tips

- **Be Patient** - Reviews can take a few days
- **Be Responsive** - Reply to feedback quickly
- **Test First** - If possible, test the extension on your device before submitting
- **Check Examples** - Look at other Arabic extensions for reference

## 🆘 Need Help?

- **Keiyoushi Discord:** https://discord.gg/3FbCpdKbdY
- **GitHub Issues:** https://github.com/keiyoushi/extensions-source/issues
- **Documentation:** https://keiyoushi.github.io/docs/

## 🎉 Success!

Once your PR is merged:
- Extension will be available at: https://keiyoushi.github.io/extensions/
- Users can add the Keiyoushi repo to Mihon/Tachiyomi
- Your extension will appear in the Arabic extensions list
- Users can install and use WaveTeamy!

---

**Ready? Start with Step 1: Fork the repository!**

Good luck! 🚀
