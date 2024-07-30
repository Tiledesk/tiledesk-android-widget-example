# tiledesk-android-widget-example

This is an example Android app with the Tiledesk Widget.

Before you begin, make sure you have the following installed:

- [Android Studio](https://developer.android.com/studio)
- [JDK 8 or higher](https://www.oracle.com/java/technologies/javase-downloads.html)
- Internet connection to download the necessary dependencies

## Strucutre
The project integrates two different methods of integrating the Tiledesk Widget.
The *MainActiviy* has two different buttons that refer to:
- *TiledeskActivity*: class that manages the integration of the widget by loading the widget deployment url
- *TiledeskInjectActivity*: class that manages the integration of the widget by injecting an html file loaded from asset and containing the js installation script of the tiledesk widget


## Installation

1. **Clone this repository:** 

```bash 
    git clone https://github.com/Tiledesk/tiledesk-android-widget-example.git 
    cd tiledesk-android-widget-example
```    
2. **Open the project in Android Studio**:
- Launch Android Studio.
- Select Open an existing Android Studio project.
- Navigate to the project folder you just cloned and select it.

3. **Set up the project**:
- Make sure you have an Android emulation device configured or connect your physical device via USB.
- Verify that all files and configurations are set up correctly.

4. **Update dependencies**:
Android Studio may prompt you to update the project dependencies. Follow the instructions in the IDE.
Attention the Tiledesk Widget is compatible with Android 13+


## Build and Run
Follow these steps to build and run the project on your device or emulator:

1. **Sync the project with Gradle**:

Go to File > Sync Project with Gradle Files to ensure all dependencies are resolved correctly.

2. **Build the project**:

Click the Build button in the Android Studio toolbar or go to Build > Make Project.

3. **Run the application**:
- Click the Run button in the toolbar or go to Run > Run 'app'.
- Select the device or emulator you want to run the app on.


## Contribute
If you would like to contribute to this project, you are welcome! Please open an issue or pull request to discuss the changes you would like to make.


## License
This project is released under the MIT License. See the LICENSE file for more details.