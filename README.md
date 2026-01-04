# FurniCart

A modern Android furniture shopping application built with Kotlin, providing a seamless e-commerce experience for browsing and purchasing furniture items.

## 📱 Overview

FurniCart is a fully-featured Android application that allows users to discover, browse, and purchase furniture items. The app features a beautiful Material Design interface with smooth navigation through product categories, detailed product views, shopping cart management, and checkout functionality.

## ✨ Features

### User Onboarding
- **Splash Screen**: Engaging splash screen with app branding
- **Onboarding Flow**: Three informative onboarding screens introducing app features
  - Discover Furniture That Feels Like Home
  - Shop with Ease, Style with Confidence
  - Transform Your Space Effortlessly
- **Skip Option**: Users can skip onboarding to directly access login

### Authentication
- **User Registration**: Complete registration form with validation
  - Username validation
  - Email validation with format checking
  - Password validation (8 characters required)
  - Password confirmation matching
- **User Login**: Secure login with credential validation
- **Form Validation**: Comprehensive client-side validation with user-friendly error messages

### Shopping Experience
- **Home Screen**: 
  - Personalized welcome message with user's name
  - Hot deals section with discount offers
  - Product categories (Armchairs, Tables, Beds, Dressers)
  - Quick navigation to product listings
- **Product Details**: 
  - Detailed product information
  - Product images and descriptions
  - Color options
  - Reviews section
  - Add to cart functionality
- **Shopping Cart**: 
  - View cart items
  - Manage quantities
  - Proceed to checkout
- **Checkout**: Complete order placement process
- **Order Success**: Confirmation screen after successful order placement

## 🛠️ Technology Stack

- **Language**: Kotlin 1.9.24
- **Platform**: Android
- **Minimum SDK**: API 25 (Android 7.1)
- **Target SDK**: API 35 (Android 15)
- **Compile SDK**: API 35
- **Build System**: Gradle 8.8.1

### Dependencies

- **AndroidX Core KTX**: 1.15.0
- **AndroidX AppCompat**: 1.7.0
- **Material Design Components**: 1.12.0
- **AndroidX Activity**: 1.10.1
- **AndroidX ConstraintLayout**: 2.2.1
- **Testing**: JUnit, AndroidX JUnit, Espresso Core

## 📁 Project Structure

```
FurniCart/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/furnicart/
│   │   │   │   ├── Cart.kt                 # Shopping cart activity
│   │   │   │   ├── Checkout.kt             # Checkout activity
│   │   │   │   ├── Home.kt                 # Home screen activity
│   │   │   │   ├── Login.kt                # Login activity
│   │   │   │   ├── Product.kt              # Product details activity
│   │   │   │   ├── Register.kt             # Registration activity
│   │   │   │   ├── SplashScreen.kt         # Splash screen activity
│   │   │   │   ├── SuccessOrder.kt         # Order success activity
│   │   │   │   ├── Onbord_screen01.kt      # First onboarding screen
│   │   │   │   ├── Onboard_screen02.kt     # Second onboarding screen
│   │   │   │   ├── Onboard_screen03.kt     # Third onboarding screen
│   │   │   │   └── models/
│   │   │   │       ├── FormData.kt         # Login form data model
│   │   │   │       ├── MyCredentials.kt    # Credential management
│   │   │   │       └── validations/
│   │   │   │           ├── RegFormData.kt  # Registration form validation
│   │   │   │           └── ValidationResult.kt  # Validation result sealed class
│   │   │   ├── res/
│   │   │   │   ├── layout/                 # XML layout files
│   │   │   │   ├── drawable/               # Images and drawable resources
│   │   │   │   ├── values/                 # Strings, colors, themes
│   │   │   │   └── mipmap/                 # App icons
│   │   │   └── AndroidManifest.xml
│   │   ├── test/                           # Unit tests
│   │   └── androidTest/                    # Instrumented tests
│   └── build.gradle.kts
├── gradle/
│   └── libs.versions.toml                  # Version catalog
├── build.gradle.kts                        # Root build file
├── settings.gradle.kts                     # Project settings
└── gradle.properties                       # Gradle properties
```

## 🚀 Getting Started

### Prerequisites

- **Android Studio**: Hedgehog (2023.1.1) or later
- **JDK**: 11 or higher
- **Android SDK**: API 35
- **Gradle**: Included (Gradle Wrapper)

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd FurniCart
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an existing project"
   - Navigate to the FurniCart directory
   - Click "OK"

3. **Sync Gradle**
   - Android Studio will automatically sync Gradle
   - Wait for dependencies to download

4. **Run the app**
   - Connect an Android device or start an emulator (API 25 or higher)
   - Click the "Run" button or press `Shift+F10`
   - Select your target device
   - The app will build and install automatically

### Building the APK

To build a release APK:

```bash
./gradlew assembleRelease
```

The APK will be located at: `app/build/outputs/apk/release/app-release.apk`

## 🎨 Design Features

- **Material Design 3**: Modern Material Design components and guidelines
- **Edge-to-Edge UI**: Full-screen immersive experience
- **Custom Color Scheme**: 
  - Primary: #EAE3D3 (Beige background)
  - Secondary: #B8A896 (Brown overlay)
  - Accent: #57361A (Dark brown buttons)
- **Custom Fonts**: Montserrat Alternates, Readex Pro
- **Responsive Layouts**: Support for various screen sizes

## 📋 User Flow

1. **Launch** → Splash Screen (3 seconds)
2. **Onboarding** → Three informational screens (can be skipped)
3. **Authentication** → Login or Register
4. **Home** → Browse categories and hot deals
5. **Product Details** → View product information
6. **Cart** → Review selected items
7. **Checkout** → Complete order
8. **Success** → Order confirmation

## 🔐 Authentication Details

The app uses in-memory credential storage (`MyCredentials` object) for demonstration purposes. In a production environment, this should be replaced with secure authentication mechanisms such as:
- SharedPreferences with encryption
- Room database
- Remote authentication API
- OAuth/Token-based authentication

### Default Credentials (for testing)

Register a new account through the app's registration flow. Credentials are stored in memory during the app session.

## 🧪 Testing

### Running Tests

**Unit Tests:**
```bash
./gradlew test
```

**Instrumented Tests:**
```bash
./gradlew connectedAndroidTest
```

Test files are located in:
- `app/src/test/java/` - Unit tests
- `app/src/androidTest/java/` - Instrumented tests

## 📝 Code Architecture

### Models Package

The app uses a clean separation of concerns with a dedicated models package:

- **FormData**: Handles login form data and validation
- **RegFormData**: Handles registration form data and validation
- **MyCredentials**: Manages user credentials (in-memory storage)
- **ValidationResult**: Sealed class for validation outcomes (Valid, Invalid, Empty)

### Validation System

The app implements a robust validation system:
- Field-level validation
- Error message display
- Real-time validation feedback
- Sealed class pattern for type-safe validation results

## 🔧 Configuration

### Version Information

- **App Version**: 1.0
- **Version Code**: 1
- **Package Name**: com.example.furnicart

### ProGuard

ProGuard rules are configured in `app/proguard-rules.pro`. Currently, minification is disabled for the release build. Enable it in `app/build.gradle.kts` if needed.

## 🐛 Known Issues

- Credentials are stored in memory and will be lost when the app is closed
- The "Track your order" button in SuccessOrder activity is not yet implemented
- Product data is static (no backend integration)

## 🔮 Future Enhancements

- Backend API integration
- Persistent database storage (Room)
- User profile management
- Order history and tracking
- Payment gateway integration
- Push notifications
- Product search functionality
- Wishlist feature
- User reviews and ratings
- Social media integration

## 📄 License

This project is created for educational/demonstration purposes.

## 👥 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## 📞 Contact

For questions or support, please open an issue in the repository.

---

**Note**: This is a demonstration project. For production use, implement proper security measures, backend integration, and data persistence.

