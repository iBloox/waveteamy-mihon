# Adding WaveTeamy to Keiyoushi Repository

## 🎯 Why Keiyoushi?

Keiyoushi is the most popular and actively maintained extension repository for Mihon. It's the best choice because:
- ✅ Most users have it configured
- ✅ Active maintainers
- ✅ Fast review process
- ✅ Automatic builds and updates

## 📋 Step-by-Step Guide

### Step 1: Fork Keiyoushi Repository

1. Go to: **https://github.com/keiyoushi/extensions-source**
2. Click the **"Fork"** button in the top-right
3. Wait for the fork to complete
4. You now have: `https://github.com/iBloox/extensions-source`

### Step 2: Clone Your Fork

```bash
git clone https://github.com/iBloox/extensions-source.git
cd extensions-source
```

### Step 3: Add Upstream Remote

```bash
git remote add upstream https://github.com/keiyoushi/extensions-source.git
git fetch upstream
```

### Step 4: Create New Branch

```bash
git checkout -b add-waveteamy-extension
```

### Step 5: Copy WaveTeamy Extension

```bash
# Copy from your waveteamy-mihon repo
cp -r /path/to/waveteamy-mihon/keiyoushi-extension src/ar/waveteamy

# Verify files are copied
ls -la src/ar/waveteamy/
```

You should see:
```
src/ar/waveteamy/
├── build.gradle
├── res/
│   ├── mipmap-hdpi/ic_launcher.png
│   ├── mipmap-mdpi/ic_launcher.png
│   ├── mipmap-xhdpi/ic_launcher.png
│   ├── mipmap-xxhdpi/ic_launcher.png
│   └── mipmap-xxxhdpi/ic_launcher.png
└── src/
    └── eu/kanade/tachiyomi/extension/ar/waveteamy/
        └── WaveTeamy.kt
```

### Step 6: Commit Changes

```bash
git add src/ar/waveteamy

git commit -m "Add WaveTeamy extension (#ar)

New Arabic manga source: WaveTeamy (https://waveteamy.com)

Features:
- Popular manga browsing with pagination
- Latest updates with duplicate filtering
- Search functionality with AJAX endpoint
- Full manga details (title, author, status, genres, description)
- Chapter list with pagination support
- Page reader with proper image loading
- Cloudflare protection support
- Rate limiting (10 req/sec)

Implementation:
- Based on TeamX extension pattern (same platform)
- Uses ParsedHttpSource base class
- Jsoup selectors for HTML parsing
- SimpleDateFormat for date parsing
- Supports both canvas[data-src] and img[src]
- Cloudflare client with timeouts

Selectors:
- Popular: div.listupd div.bsx
- Latest: div.last-chapter div.box
- Search: /ajax/search endpoint
- Chapters: div.chapter-card a
- Pages: div.image_list canvas/img

Tested:
- Popular manga loading
- Latest updates
- Search with Arabic text
- Manga details
- Chapter reading
- Image loading"
```

### Step 7: Push to Your Fork

```bash
git push origin add-waveteamy-extension
```

### Step 8: Create Pull Request

1. Go to: **https://github.com/iBloox/extensions-source**
2. You'll see a banner: **"add-waveteamy-extension had recent pushes"**
3. Click **"Compare & pull request"**
4. Review the changes
5. Title: `Add WaveTeamy extension (#ar)`
6. The description will be auto-filled from your commit
7. Click **"Create pull request"**

### Step 9: Wait for Review

- Keiyoushi maintainers will review (usually 1-7 days)
- They may request changes
- Respond to any feedback
- Once approved, it will be merged automatically

### Step 10: Extension Goes Live!

After merge:
- Extension is automatically built
- Published to Keiyoushi repository
- Users can install from Mihon/Tachiyomi
- Appears in Browse → Extensions → Arabic

## 🔧 If You Need to Make Changes

If maintainers request changes:

```bash
# Make the changes to files in src/ar/waveteamy/
# Then commit and push
git add src/ar/waveteamy
git commit -m "Fix: [describe the fix]"
git push origin add-waveteamy-extension
```

The PR will automatically update.

## 📝 PR Checklist

Before submitting, verify:

- [ ] All files copied correctly
- [ ] build.gradle present
- [ ] WaveTeamy.kt present
- [ ] All 5 icon sizes present
- [ ] Commit message is descriptive
- [ ] Branch name is clear

## 🎯 After Your PR is Merged

1. **Add Keiyoushi Repo to Mihon:**
   - Open Mihon
   - Go to Browse → Extension repos
   - Add: `https://raw.githubusercontent.com/keiyoushi/extensions/repo/index.min.json`

2. **Install WaveTeamy:**
   - Go to Browse → Extensions
   - Find "WaveTeamy" in Arabic section
   - Click Install
   - Start reading!

## 💡 Tips

- **Be Patient:** Reviews can take a few days
- **Be Responsive:** Reply to feedback quickly
- **Test First:** If possible, build locally to test
- **Check CI:** GitHub Actions will build your extension automatically

## 🆘 Common Issues

### "Build Failed"
- Check the CI logs
- Usually selector or syntax errors
- Fix and push again

### "Selectors Don't Match"
- WaveTeamy's HTML might be different from TeamX
- You may need to adjust selectors
- Check the actual website HTML

### "Duplicate Extension"
- Make sure WaveTeamy doesn't already exist
- Check: https://keiyoushi.github.io/extensions/

## 📞 Need Help?

- **Keiyoushi Discord:** https://discord.gg/3FbCpdKbdY
- **GitHub Issues:** https://github.com/keiyoushi/extensions-source/issues
- **Documentation:** https://keiyoushi.github.io/docs/

## 🎉 Success!

Once merged, your extension will be available to thousands of Mihon users!

---

**Ready? Start with Step 1: Fork the repository!**
