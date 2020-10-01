App Icons Downloader
=====================

![App Store](https://www.apple.com/v/ios/app-store/d/images/overview/app_store_icon__fngcxe43zo2u_large.jpg)
![Google Play](https://www.gstatic.com/android/market_images/web/play_prism_hlock_2x.png)

Download app icons for any App Store or Play Store app. 

This executable is built using the [java-app-icons](https://github.com/petarov/java-app-icons) library.

# Installation

Binaries for `Linux x86_64` and `macOS` are available in [releases](https://github.com/petarov/java-app-icons-bin/releases).

Linux binaries were tested on Ubuntu and CentOS.

# Usage

Download Instagram's Google Play icon to the current directory.

```
% ./app-icons-bin -a com.instagram.android -s PLAYSTORE 
1 icon files downloaded to /home/users/someone/java-app-icons-bin/.
``` 

Download Instagram and TikTok's App Store icons to `/tmp`.

```
% ./app-icons-bin -a 389801252 -a 835599320 -s APPSTORE -o /tmp
6 icon files downloaded to /tmp
``` 

Display Instagram and TikTok's App Store icon download urls.

```
% ./app-icons-bin -a 389801252 -a 835599320 -s APPSTORE -u
https://is3-ssl.mzstatic.com/image/thumb/Purple114/v4/c9/1e/a9/c91ea95d-be7f-bbc4-6da1-9fa6d1e149e7/source/512x512bb.jpg
https://is3-ssl.mzstatic.com/image/thumb/Purple114/v4/c9/1e/a9/c91ea95d-be7f-bbc4-6da1-9fa6d1e149e7/source/100x100bb.jpg
https://is3-ssl.mzstatic.com/image/thumb/Purple114/v4/c9/1e/a9/c91ea95d-be7f-bbc4-6da1-9fa6d1e149e7/source/60x60bb.jpg
https://is3-ssl.mzstatic.com/image/thumb/Purple114/v4/6b/13/61/6b1361de-67c8-6423-39d7-6631a763eaad/source/512x512bb.jpg
https://is3-ssl.mzstatic.com/image/thumb/Purple114/v4/6b/13/61/6b1361de-67c8-6423-39d7-6631a763eaad/source/100x100bb.jpg
https://is3-ssl.mzstatic.com/image/thumb/Purple114/v4/6b/13/61/6b1361de-67c8-6423-39d7-6631a763eaad/source/60x60bb.jpg
``` 

# Development

Install [GraalVM](https://www.graalvm.org/docs/getting-started-with-graalvm).

Install [Native Image](https://www.graalvm.org/reference-manual/native-image).

To build a binary run:

    ./gradlew nativeImage 

The executable can be found at `build/native-image`. 

# License

[MIT](LICENSE)


