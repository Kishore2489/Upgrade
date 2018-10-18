# Upgrade

#### Pre-requisite:
1.	You should be having JAVA 1.8 as I have used Streams
2.	You should be having maven

#### To run the Tests
1. Open Command Prompt(for windows) or Terminal (Path) 
2. Go the path where the file is downloaded
3. Open the project
4. Type the following command
>mvn clean test


#### To view the reports
Reports will be available in following path:
>path of the project\target\surefire-reports\index.html

In index.html click Reporter Output to see name of that state has a min age of 19 and a state with min loan amount requirement of $3,005


#### Note:
The build will fail because ValidateStateCode method in ApiTestValidation fails. 
The reason being “district of Colombia” is not considered as a state in the United States. 
