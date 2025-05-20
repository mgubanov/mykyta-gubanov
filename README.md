# Mobile Test Automation Framework

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
```

## Tech Stack

- **Java 17 (LTS)** – chosen for long-term support and modern language features.
- **Gradle (Groovy DSL)** – for build management and dependency handling.
- **TestNG** – for test orchestration and parallel execution.
- **Selenide** – simplifies UI test writing with built-in waits and concise syntax.
- **Appium** – enables cross-platform mobile testing (Android and iOS).
- **Allure** – for generating clear and informative test reports.

## Setup Instructions

1. Connect your Android device or start an emulator.
2. Get your device ID:
   ```bash
   adb devices
   ```
3. Configure the following:
    - App path
    - Device ID
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

## Reporting

To generate and view the Allure report:

```bash
allure serve build/allure-results
```

## Approach and Architecture

This framework is designed to be intuitive, scalable, and easy to maintain.

- **Page Object Model (POM)** is used to structure screen logic. It allows chaining screen transitions and direct interaction with elements in a readable and reusable way.
- **Selenide** was chosen to simplify test code, improve stability with built-in waits, and reduce boilerplate.
- Elements are located using `@AndroidFindBy` annotations. To support iOS, corresponding `@iOSXCUITFindBy` annotations can be added without changing test logic—ensuring cross-platform compatibility while keeping the codebase clean and maintainable.





END:
connect android device
adb devices - get your ID here
setup app path
setup app ID
appium - to run appium server


./gradlew clean test       # run tests and generate allure-results/
./gradlew allureReport     # generate static report in build/reports/allure-report/
./gradlew allureServe      # start server and open report in browser from temp folder


./gradlew clean test --tests "tests.api.*" - run api only
./gradlew clean test --tests "tests.mobile.*" - run mobile only







run petstore
docker pull swaggerapi/petstore3:unstable
docker run --name petstore3 -d -p 8080:8080 swaggerapi/petstore3:unstable