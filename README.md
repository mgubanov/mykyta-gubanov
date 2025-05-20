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