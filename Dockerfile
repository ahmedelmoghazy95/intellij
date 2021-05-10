FROM openjdk:8-jre-alpine

WORKDIR /usr/share/tag

# Add the project jar & copy dependencies
ADD  target/momra-e2e-ui-testing-0.0.1.jar momra-e2e-ui-testing.jar
ADD  target/momra-e2e-ui-testing-tests-0.0.1-tests.jar momra-e2e-ui-testing-tests.jar
ADD  target/libs libs

# Add the suite xmls
ADD testng.xml testng.xml

# Add the Test Data Excel File
ADD src/main/resources/testData src/main/resources/testData/

# Add All Properties Files
ADD src/main/resources/*.properties src/main/resources/

# Add Test Docs Folder
ADD src/main/resources/testDocs src/main/resources/testDocs/

# Add DB Backup Folder
ADD src/main/resources/dbBackup src/main/resources/dbBackup/

# Command line to execute the test
# Expects below ennvironment variables
# BROWSER = chrome / firefox
# MODULE  = login-module
# GRIDHOST = selenium hub hostname / ipaddress

ENTRYPOINT ["/usr/bin/java", "-cp", "momra-e2e-ui-testing.jar:momra-e2e-ui-testing-tests.jar:libs/*", "-DseleniumHubHost=seleniumhub", "-Dbrowser=chrome", "org.testng.TestNG", "./testng.xml"]