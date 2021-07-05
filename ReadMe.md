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
https://github.com/PujaAroraad/RedBusAssignment.git

**Note:There is hard wait of 3 seconds used on driver within the code as src\main\java\utils.waits.hardWait() function. In case of good network reduce that wait to zero by going to above file location. It is used as without this test cases were failing.**

