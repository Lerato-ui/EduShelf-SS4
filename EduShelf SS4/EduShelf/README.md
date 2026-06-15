# EduShelf – Android App
### MADA372 / SS4

Peer-to-peer textbook marketplace for students in African higher education.

---

## Project Structure
```
EduShelf/
├── app/src/main/
│   ├── java/com/example/edushelf/
│   │   ├── Textbook.kt
│   │   ├── TextbookRepository.kt
│   │   ├── TextbookViewModel.kt
│   │   ├── TextbookAdapter.kt
│   │   ├── WelcomeActivity.kt
│   │   ├── LoginActivity.kt
│   │   ├── RegisterActivity.kt
│   │   ├── HomeActivity.kt
│   │   ├── BrowseActivity.kt
│   │   ├── BookDetailActivity.kt
│   │   ├── EnquiryActivity.kt
│   │   ├── SellActivity.kt
│   │   └── ProfileActivity.kt
│   └── res/
│       ├── layout/
│       ├── drawable/
│       └── values/
└── README.md
```

## Screen Flow
```
WelcomeActivity
  ├── LoginActivity    → HomeActivity
  └── RegisterActivity → HomeActivity
                           ├── BrowseActivity → BookDetailActivity → EnquiryActivity
                           ├── SellActivity
                           └── ProfileActivity
```

## Architecture
| Layer | Files |
|-------|-------|
| Model | `Textbook.kt`, `TextbookRepository.kt` |
| ViewModel | `TextbookViewModel.kt` |
| View | Activities + XML layouts |

## Logo Setup
1. Copy `ndebele_icon_transparent.png` from your Downloads folder.
2. Paste it into: `EduShelf/app/src/main/res/drawable/`
3. The filename must be exactly: `ndebele_icon_transparent.png`

## Quick Start
1. Open Android Studio → **File → Open** → select `EduShelf/`
2. Copy `ndebele_icon_transparent.png` into `app/src/main/res/drawable/`
3. Wait for Gradle sync
4. Run with **Shift + F10**

## Build Signed APK
1. **Build → Generate Signed Bundle / APK**
2. Choose **APK** → Next
3. Create or use an existing keystore
4. Select **release** build variant → Finish
5. APK will be in `app/release/app-release.apk`

## Amazon Appstore Submission
1. Create a developer account at https://developer.amazon.com
2. Go to **My Apps → Add a New App**
3. Upload the signed APK, add screenshots and description
4. Submit for review

## GitHub Repository Setup
```bash
git init
git add .
git commit -m "Initial commit – EduShelf"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/EduShelf-MADA372.git
git push -u origin main
```

## References
- Google (2024). Android Developers – Data Binding Library. https://developer.android.com/topic/libraries/data-binding
- Google (2024). Android Developers – ViewModel Overview. https://developer.android.com/topic/libraries/architecture/viewmodel
- Google (2024). RecyclerView for displaying lists of data. https://developer.android.com/develop/ui/views/layout/recyclerview
- Amazon (2024). Appstore Publishing Guide. https://developer.amazon.com/docs/app-submission/