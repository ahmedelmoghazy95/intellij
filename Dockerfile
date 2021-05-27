FROM openjdk:8-jre-alpine

WORKDIR /usr/share/tag

# Add the project jar & copy dependencies
ADD  target/momra-e2e-tests-*.*.?.jar momra-e2e.jar
ADD  target/momra-e2e-tests-*-tests.jar momra-e2e-tests.jar
ADD  target/libs libs

# Add the suite xmls
ADD *.xml /

# Add the Test Data Excel File
ADD src/main/resources/testdata src/main/resources/testdata/

# Add All Properties Files
ADD src/main/resources/*.properties src/main/resources/

# Add Test Docs Folder
#ADD src/main/resources/testdocs src/main/resources/testdocs/

# Command line to execute the test
# Expects below ennvironment variables
# BROWSER = chrome / firefox
# MODULE  = login-module
# GRIDHOST = selenium hub hostname / ipaddress

ENTRYPOINT ["/usr/bin/java", "-cp", "momra-e2e.jar:momra-e2e-tests.jar:libs/*", "-DseleniumHubHost=seleniumhub", "-Dbrowser=chrome", "org.testng.TestNG", "./TEST_SUITE.xml"]