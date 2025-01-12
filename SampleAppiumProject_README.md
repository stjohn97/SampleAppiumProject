
# Sample Appium Project

This repository contains a sample project demonstrating the use of Appium for mobile automation testing. The project is structured to follow best practices in test automation, featuring reusable components and a modular design.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [Setup Instructions](#setup-instructions)
- [Running Tests](#running-tests)

## Overview

The **Sample Appium Project** showcases how to automate AnswerConnect app using Appium, a popular open-source tool for cross-platform automation of native, hybrid, and mobile web applications.

## Features

- Automation testing for Android applications.
- Modular framework for reusability and scalability.
- Integration with TestNG and Cucumber BDD for test execution and reporting.
- Handling of dynamic element locators.

## Project Structure

```
src/
├── main/
│   └── java/
│       └── com/answerconnect/
            └── base/              # Base test setup and teardown classes
│           └── utilities/         # Utility classes for reusable functions
├── test/
    └── java/
        └── com/answerconnect/
            ├── runner/            # Runner setup to run the test case
            ├── pages/             # Page Object Model classes
            ├── tests/             # Test cases for the application
            └── feature/           # Feature, properties and configuration files
```

### Key Directories

- **base/**: Contains base classes for initializing Appium drivers and handling common setup/teardown processes.
- **pages/**: Implements the Page Object Model (POM) to separate test logic from UI interactions.
- **tests/**: Includes test cases to validate app functionality.
- **features/**: Stores Cucumber `.feature` files for BDD.
- **utilities/**: Utility classes for handling configurations, reporting, and common actions.

## Setup Instructions

### Prerequisites

1. Install [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) (version 8 or higher).
2. Install [Maven](https://maven.apache.org/download.cgi) for dependency management.
3. Install [Appium Server](https://appium.io/).
4. Ensure the Android SDK is installed and configured.
5. Set up device emulators or connect real devices for testing.

### Clone the Repository

```bash
git clone https://github.com/stjohn97/SampleAppiumProject.git
cd SampleAppiumProject
```

### Install Dependencies

```bash
mvn clean install
```

### Configure Environment Variables

Set the following environment variables:

- `ANDROID_HOME`: Path to the Android SDK.
- `JAVA_HOME`: Path to the JDK installation.
- Add the Android SDK's `tools` and `platform-tools` directories to your system's `PATH`.

## Running Tests

### Start the Appium Server

Start the Appium server on your machine:

```bash
appium
```

### Run Tests Using Maven

Execute the test suite using Maven:

```bash
mvn test
```

### Generate Reports

TestNG generates default HTML reports in the `test-output` directory. You can customize the reports as needed.
