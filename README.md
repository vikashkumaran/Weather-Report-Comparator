# Weather-Report-Comparator
--------PROJECT DESCRIPTION------------------------
Weather-Report-Comparator consists of codes to compare and confirm the data obtained from NDTV website and openweathermap APIs
--------WHO CAN USE IT-----------------------------
DIRECT USAGE: one who needs to compare any city's weather report from NDTV website and openweathermap can directly use it
INDIRECT USAGE: 1) one who needs to get the weather report of a city from any of NDTV website and openweathermap 
                2) one who needs to compare weather report of a city from any of two weather reporting websites
                3) one who needs to compare any data that are obtained from 2 websites
By modifying the code structure,one can achieve the indirect usage by spending very less time for modifications alone.
-------HOW TO USE IT--------------------------------
1)Check out the Weather-Report-Comparator project.
2)Build the project.
3)Make sure the driver version used in the project matches with the browser version in the pc,Otherwise change the driver linked to the project with matchable version.
  (project driver is available inside the "driver" folder)
4)"temperature_configuration.xls" is used to configure the temparature variance limit.If user wants to change the limit,they can change the configuration value.
  ("temperature_configuration.xls" is available inside the "TempConfigFile" folder)
5)"WeatherReportComparator.java" is the main test class used to compare the weather reports.
6)WeatherReportComparator class is mapped in "testng.xml",By executing the testng.xml file,output results will be obtained in "test-output" folder.
-------Project Implementation Details-----------------
Programming Langauge Used: Java
Porject Type: Maven Project
Test Automation Framework: Selenium,TestNg
Test Design Pattern: Page Object Model
Primary Version Control System: Git-Hub [https://github.com/vikashkumaran/Weather-Report-Comparator] 
