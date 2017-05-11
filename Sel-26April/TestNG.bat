set myProjectpath=C:\Users\dedua\git\App-V1\Sel-26April
cd %myProjectpath%
set classpath=%myProjectpath%\bin;%myProjectpath%\lib\*;
java org.testng.TestNG %myProjectpath%\testng.xml
pause