Login Details:

user name: princes ira

password: s8146150



My Music Application

Overview

My Music Application is an Android app for the NIT3213 software engineering assessment. It demonstrates a complete user flow:

- Secure login  
- Album dashboard with a dynamic list display  
- Detailed view for each album  
- Backend integration with Retrofit for RESTful API calls  
- Dependency injection with Koin  
- Four working unit tests verifying data, logic, and parsing reliability

The architecture embraces separation of concerns, modern Android practices, and clear code organization.

Features

- Login Screen  
  Users enter credentials. On success, a keypass is retrieved and the app navigates to the main dashboard.

- Dashboard Screen  
  Fetches and displays a list of albums from the API with artist, title, and genre, using a RecyclerView.

- Album Details Screen  
  Selecting an album shows details like release year, number of tracks, description, and the most popular track.

- API Integration  
  Uses Retrofit and Gson for network communication and parsing.  
  Base URL: https://nit3213api.onrender.com/

- Dependency Injection  
  Modular setup using Koin for injecting the Retrofit instance and API interface.

- Unit Testing  
  Four unit tests included for core data models, JSON parsing, adapter, and ViewModel logic.

Project Structure

MyMusicApplication/  
├── app/  
│   ├── di/  
│   │   └── AppModule.kt          # Koin modules and DI configuration  
│   ├── model/  
│   │   ├── Album.kt  
│   │   ├── LoginRequest.kt  
│   │   ├── LoginResponse.kt  
│   │   └── DashboardResponse.kt  
│   ├── ui/  
│   │   ├── MainActivity.kt  
│   │   ├── DashboardActivity.kt  
│   │   ├── DetailsActivity.kt  
│   │   └── AlbumAdapter.kt  
│   ├── App.kt                    # Initializes Koin  
│   └── res/  
│       └── layout/  
│           ├── activity_main.xml  
│           ├── activity_dashboard.xml  
│           ├── activity_details.xml  
│           └── item_album.xml  
├── src/  
│   └── test/  
│       ├── AlbumAdapterTest.kt  
│       ├── DashboardResponseTest.kt  
│       ├── LoginRequestTest.kt  
│       └── SampleViewModelTest.kt  
└── README.md                     # Project documentation  

Setup Instructions

Requirements

- Android Studio Flamingo or newer  
- Kotlin 1.9+  
- Minimum SDK: 21  
- Add internet permission in AndroidManifest.xml  

Setup Steps

1. Clone the repository:

   git clone https://github.com/yourusername/MyMusicApplication.git

2. Open in Android Studio  
   Let Gradle finish syncing and downloading dependencies.

3. Run the app  
   Use an emulator or real device.

4. Login and explore  
   Login with valid credentials to access the dashboard and album details.

API Integration

- Base URL: https://nit3213api.onrender.com/  
- Login Endpoint: POST /login (returns keypass)  
- Dashboard Endpoint: GET /dashboard/{keypass} (returns list of albums)  

Responses are delivered as JSON in a format matching your data models.

Unit Testing

Test File                   | Component Tested  
----------------------------|------------------  
LoginRequestTest.kt         | Login model and validation  
DashboardResponseTest.kt    | Dashboard JSON parsing  
AlbumAdapterTest.kt         | Adapter list rendering  
SampleViewModelTest.kt      | ViewModel business logic  

Run all tests through Android Studio’s test runner or with:

./gradlew test

Tech Stack

- Language: Kotlin  
- Networking: Retrofit  
- JSON: Gson  
- Dependency Injection: Koin  
- Testing: JUnit4  
- UI: RecyclerView, Activities, XML layouts  

Contact

- Name: Princes Ira Villafana  
- Email: s8146150@live.vu.edu.au 
- GitHub: https://github.com/iraV128

