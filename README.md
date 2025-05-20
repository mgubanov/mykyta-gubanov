# 1. Exploratory testing of Monefy App
📄 **[Task 1](exploratory_testing.md)**

# 2. Mobile Test Automation Framework of Monefy App

## Project structure

```
project-root/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── api/
│   │   │   │   └── models/
│   │   │   └── mobile/
│   │   │       ├── core/
│   │   │       ├── screens/
│   │   │       └── utils/
│   │   └── resources/
│   │       └── apps/
│
├── test/
│   ├── java/
│   │   └── tests/
│   │       ├── api/
│   │       └── mobile/
└── resources/
│   │       ├── apireport/
│   │       └── mobilereport/
```

## Tech Stack

- **Java 17 (LTS)** – chosen for long-term support and modern language features.
- **Gradle (Groovy DSL)** – for build management and dependency handling.
- **TestNG** – for test orchestration and parallel execution.
- **Selenide** – simplifies UI test writing with built-in waits and concise syntax.
- **Appium** – enables cross-platform mobile testing (Android and iOS).

## Setup Instructions

1. Connect your Android device or start an emulator.
2. Get your device ID:
   ```bash
   adb devices
   ```
3. Configure the following under `src/main/resources/config.properties`:
    - app.path
    - device.name
    - platform.version
4. Start the Appium server:
   ```bash
   appium
   ```
5. Run mobile tests:
   ```bash
   ./gradlew clean test --tests "tests.mobile.*"
   ```

## Test Structure

Main test classes:

- `ExpenseTest.java`
- `IncomeTest.java`
- `SearchTest.java`

These cover the three most important E2E user flows identified during exploratory testing:

1. **Expense Flow** – Creating and verifying expense flow.
2. **Income Flow** – Creating and verifying income flow.
3. **Search Flow** – Searching and filtering existing transactions.

## Approach and Architecture

This framework is designed to be intuitive, scalable, and easy to maintain.

- **Page Object Model (POM)** is used to structure screen logic. It allows chaining screen transitions and direct interaction with elements in a readable and reusable way.
- **Selenide** was chosen to simplify test code, improve stability with built-in waits, and reduce boilerplate.
- Elements are located using `@AndroidFindBy` annotations. To support iOS, corresponding `@iOSXCUITFindBy` annotations can be added without changing test logic—ensuring cross-platform compatibility while keeping the codebase clean and maintainable.

## Report
📄 **[Test Report](src/test/resources/mobilereport/reports/tests/test/index.html)**
📄 **[Test Screenshot](src/test/resources/mobilereport/screenshot.png)**
You can view the test report by opening this link in the repo.


# 3. Api Test Automation Framework of Petstore

## Tech Stack

- **Java 17 (LTS)** – chosen for long-term support and modern language features.
- **Gradle (Groovy DSL)** – for build management and dependency handling.
- **TestNG** – for test orchestration and parallel execution.
- **REST-assured** – Java library for testing and validating REST APIs with a simple and fluent syntax.
- **Lombok** – Reduces boilerplate code by auto-generating getters, setters, constructors, and more using annotations.

## How to install & run

* Pull service
   ```bash
   docker pull swaggerapi/petstore3:unstable
   ```
* Remove old containers(Optional)
  ```bash
  docker rm -f $(docker ps -a -q)
  ```
* Start service
  ```bash
  docker run --name petstore3 -d -p 8080:8080 swaggerapi/petstore3:unstable
  ```
* Run tests
   ```bash
  ./gradlew clean test --tests "tests.api.*"
  ```

## Approach and Architecture

I chose this tech stack because it’s powerful, easy to use, and helps me write API tests quickly and clearly. Java 17 gives me modern features and good stability. Gradle with Groovy makes building and managing tests simple and smooth.

TestNG is a reliable testing framework that lets me organize tests well, run them in parallel, and get detailed results.

REST-assured is a great Java library made for testing REST APIs. It has a clean, easy-to-read syntax that makes writing and understanding tests much easier.

Lombok helps cut down on repetitive code by automatically creating things like getters and setters, so I can focus more on writing the tests themselves.

## Report
📄 **[Test Report](src/test/resources/apireport/reports/tests/test/index.html)**
📄 **[Test Screenshot](src/test/resources/apireport/screenshot.png)**
You can view the test report by opening this link in the repo.