set myProjectpath=C:\Users\dedua\workspace\Sel-26April
cd %myProjectpath%
set classpath=%myProjectpath%\bin;%myProjectpath%\lib\*;
java org.testng.TestNG %myProjectpath%\testng.xml
pause