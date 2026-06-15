EduShelf
MADA372 / SS4

Peer-to-peer textbook marketplace for students in South African higher education.



Project Structure

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

WelcomeActivity
  ├── LoginActivity    → HomeActivity
  └── RegisterActivity → HomeActivity
                           ├── BrowseActivity → BookDetailActivity → EnquiryActivity
                           ├── SellActivity
                           └── ProfileActivity
Architecture
| Layer | Files |
|-------|-------|
| Model | `Textbook.kt`, `TextbookRepository.kt` |
| ViewModel | `TextbookViewModel.kt` |
| View | Activities + XML layouts |



## Quick Start
1. Open Android Studio → **File → Open** → select `EduShelf/`
2. Copy `ndebele_icon_transparent.png` into `app/src/main/res/drawable/`
3. Wait for Gradle sync
4. Run with **Shift + F10**


## GitHub Repository Setup
```bash
git init
git add .
git commit -m "Initial commit – EduShelf"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/EduShelf-MADA372.git
git push -u origin main
```


- Google (2024). Android Developers – Data Binding Library. https://developer.android.com/topic/libraries/data-binding
- Google (2024). Android Developers – ViewModel Overview. https://developer.android.com/topic/libraries/architecture/viewmodel
- Google (2024). RecyclerView for displaying lists of data. https://developer.android.com/develop/ui/views/layout/recyclerview
- Amazon (2024). Appstore Publishing Guide. https://developer.amazon.com/docs/app-submission/
