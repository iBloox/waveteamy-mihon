# 🚀 START HERE - Add WaveTeamy to Keiyoushi

## ⚠️ Important: Mihon Only Accepts Extensions from Repositories!

You're right - Mihon no longer accepts manual APK installations. Extensions **must** come from trusted repositories like **Keiyoushi**.

## ✅ Extension Ready for Keiyoushi!

I've updated the extension to use the **exact same code pattern as TeamX** (a working Arabic extension). This ensures it will work perfectly!

**See [FINAL_UPDATE.md](FINAL_UPDATE.md) for technical details.**

## 📦 Submit to Keiyoushi Repository

Follow these 3 simple steps:

---

## Step 1: Fork Keiyoushi (2 minutes)

1. Go to: https://github.com/keiyoushi/extensions-source
2. Click **"Fork"** button (top-right)
3. Wait for fork to complete

---

## Step 2: Clone & Copy (3 minutes)

```bash
# Clone your fork
git clone https://github.com/iBloox/extensions-source.git
cd extensions-source

# Copy the extension
cp -r /path/to/waveteamy-mihon/keiyoushi-extension src/ar/waveteamy

# Create branch
git checkout -b add-waveteamy-extension

# Commit
git add src/ar/waveteamy
git commit -m "Add WaveTeamy extension (#ar)"

# Push
git push origin add-waveteamy-extension
```

---

## Step 3: Create Pull Request (2 minutes)

1. Go to: https://github.com/iBloox/extensions-source
2. Click **"Compare & pull request"**
3. Review and click **"Create pull request"**

---

## 🎉 Done!

Wait for Keiyoushi maintainers to review (1-7 days).
Once merged, your extension will be live!

---

## 📖 Detailed Guide

See **[KEIYOUSHI_PR_GUIDE.md](KEIYOUSHI_PR_GUIDE.md)** for:
- Complete step-by-step instructions
- What happens after merge
- How users will install your extension
- Troubleshooting tips

---

## 🎯 After Your PR is Merged

Users will be able to install WaveTeamy:

1. **Add Keiyoushi repo to Mihon:**
   - Browse → Extension repos
   - Add: `https://raw.githubusercontent.com/keiyoushi/extensions/repo/index.min.json`

2. **Install WaveTeamy:**
   - Browse → Extensions → Arabic
   - Find "WaveTeamy"
   - Click Install

---

## 💬 Need Help?

- **Full Guide:** [KEIYOUSHI_PR_GUIDE.md](KEIYOUSHI_PR_GUIDE.md)
- **Discord:** https://discord.gg/3FbCpdKbdY
- **Docs:** https://keiyoushi.github.io/docs/

---

<div align="center">

**Ready? Start with Step 1: Fork Keiyoushi!** 🚀

https://github.com/keiyoushi/extensions-source

</div>
