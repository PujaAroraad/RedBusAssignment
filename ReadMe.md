#ReadMe file 
Prerequisites are maven, eclipseIDE, git, jenkins setup<br>

####View generated Reports from previous run
Step1:go to \Reports\<br>
Step2:open the .html reports using browsers<br>

####View failed test screenshot from previous run
Step1:go to \FailedScreenshots\<br>
Step2:open the various .jpg files<br>

####View generated Logs from previous run
go to logs folder and open executionLog.log file<br>

####To run the project with all tests
Step1:right click on project run as maven clean<br>
Step2:right click on project run as maven install<br>
OR<br>
click ClickToRunProjectOnCmd.bat file<br>
OR<br>
run via testng.xml file \testng.xml\ as testngSuite<br>
OR<br>
run via jenkins PFA document<br>

####GitHub repository link
https://github.com/PujaAroraad/RedBusAssignment.git<br>

**Note:There is hard wait of 3 seconds used on driver within the code as src\main\java\utils.waits.hardWait() function. In case of good network reduce that wait to zero by going to above file location. It is used as without this test cases were failing.**<br>

####About project
1.The failed screenshots get attached to FailedScreenShots folder and extent report as well.<br>
2.The Data folder contains the .xlsx files<br>
3.The src\test\java\tests-> contains the tests files<br>
4.The src\test\java\reusables-> contains the data fetch operations and reusable test methods as all test cases are independent which uses flow.<br>
5.The src\main\java\pages->POM implementations<br>
6.The src\main\java\utils->contains reusable code like screenshots, scroll operation, error_msg, waits <br>
7.The Resources folder contains .properties files for drivers and other for values. <br>
8.For browser choice go to \Resources\driver.properties and choose browser as per comments.<br>
9.Driver folder contains drivers for various browsers.<br>
10.The project is up and running with all test cases pass.<br>



please reach out to me in case of test failures. As there may occur login failures with sample accounts email.
