# Campus Notes App

A native Android application built with Kotlin and Java to store and organize notes for multiple units across academic years.

## Features

- **Dynamic Units Management**: Create and manage your own custom units
- **Multi-Year Support**: Organize notes by academic year
- **Create, Edit, Delete Notes**: Full note management capabilities
- **Search Functionality**: Quickly find notes across units and years
- **Local Storage**: Notes stored locally on device using SQLite
- **Material Design**: Modern and intuitive user interface
- **Dark Mode Support**: Adaptive color scheme

## Project Structure

```
campus-notes-app/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── kotlin/
│   │   │   │   └── com/campusnotes/
│   │   │   │       ├── MainActivity.kt
│   │   │   │       ├── ui/
│   │   │   │       ├── data/
│   │   │   │       └── model/
│   │   │   ├── java/
│   │   │   ├── res/
│   │   │   └── AndroidManifest.xml
│   │   └── test/
│   └── build.gradle
├── build.gradle
└── settings.gradle
```

## Tech Stack

- **Language**: Kotlin & Java
- **Database**: SQLite with Room ORM
- **UI Framework**: Android Material Design 3
- **Architecture**: MVVM (Model-View-ViewModel)
- **Build Tool**: Gradle

## Getting Started

### Prerequisites
- Android Studio Flamingo or later
- Android SDK 24 or higher
- Kotlin 1.8+

### Installation

1. Clone the repository
```bash
git clone https://github.com/love-751/campus-notes-app.git
cd campus-notes-app
```

2. Open in Android Studio
3. Sync Gradle files
4. Run on emulator or physical device

## Usage

1. **Add Units**: Create custom units according to your needs
2. **Select Year**: Choose an academic year
3. **Manage Units**: View, edit, or delete your units
4. **Create Notes**: Add notes with title and content for any unit
5. **Organize**: Notes are automatically organized by unit and year
6. **Search**: Find notes by keyword across all units and years

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.
