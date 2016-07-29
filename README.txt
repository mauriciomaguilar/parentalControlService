Developed by Maurício Moreira de Aguilar - mauriciomoreira2006@gmail.com

Java Version = 1.7
IDE = Eclipse Version: Luna Service Release 2 (4.4.2)


Steps:
1 - Import the project as a 'Maven project'
2 - Go to 'com.parentalControl.controller.ApplicationController' class and Run
3 - On your WebBrowser type: http://localhost:8080/parentalControlService?controlLevel='X'&movieId='Y'
4 - Replace parameters 'X' and 'Y' with one of respective parameters values below:
	- X: U, PG, 12 or 18
	- Y: 1, 2, 3, 4 or 5
5 - The return will be 'true' or 'false'
6 - If you use no parameters the return will be always 'false'

Unit Test: ParentalControlControllerTests.java