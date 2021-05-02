# Battleship-Game
Final project of Ubiqum's Code Academy Full Stack Web Development with Java program.

## Table of contents
* [App Description](#app-description)
* [Technologies](#technologies)
* [Quick Start](#quick-start)

# App Description

This is an online multiplayer Battleship game with authentication and a real-time chat using javascript for the front end and Java with Springboot and Spring Security for the back end

## Technologies
Project is created with:
* Springboot
* Spring Security
* Java 11
* Gradle
* H2 (Development)
* MySql (Production)
* ES6
* SVG (Automation Effects)
* Bootstrap 4

# Quick Start

### JDK
You 'll need a current version of a JDK. If you don't already have one, go to Oracle or Amazon Coretto and follow the instructions acording to your OS. 

### Install Gradle

**For Mac Users:**

If you have previously installed Homebrew, you can use that to install the latest Gradle package.
```
brew install gradle
```
If you have not installed Homebrew, then follow the advice at the Gradle site and use sdkman.  sdkman is like Homebrew, but implemented
in and for Java programs.

Get sdkman with
```
curl -s https://get.sdkman.io | bash
```
Then open a new Terminal window -- the simplest way to make sure sdk is now available – and execute
```
sdk install gradle 2.14.1
```

**For Windows/Linux:**

* Download the latest binaries from Gradle's download page
* Unpack the zip to folder (e.g. "C:/Program Files").  
* Add the GRADLE_HOME/bin folder to your PATH environment variable.
* Open the system properties (WinKey + Pause), select the "Advanced" tab, and the "Environment Variables" button
* Then add "C:\Program Files\gradle-x.x\bin", or wherever you unzipped Gradle to, to the end of your "Path" variable under
* System Properties 

**TIP:**
Remember to replace the x.x in the example with the gradle version number you downloaded.  Be sure to omit any quotation marks around
the path even if it contains spaces. Also make sure you separated from previous PATH entries with a semicolon ";".
