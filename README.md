App Icons Downloader
=====================

![App Store](https://www.apple.com/v/ios/app-store/d/images/overview/app_store_icon__fngcxe43zo2u_large.jpg)
![Google Play](https://www.gstatic.com/android/market_images/web/play_prism_hlock_2x.png)

Download app icons for any App Store or Play Store app. 

This executable is built using the [java-app-icons](https://github.com/petarov/java-app-icons) library.

# Installation

// TODO

# Development

Install [GraalVM](https://www.graalvm.org/docs/getting-started-with-graalvm).

Install [Native Image](https://www.graalvm.org/reference-manual/native-image).

To build a binary run:

    ./gradlew nativeImage 

The executable can be found at `build/native-image`. 

# License

[MIT](LICENSE)


