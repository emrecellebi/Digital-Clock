@echo off

REM set PLATFORM_IMPL=../lib/platform-impl.jar;
REM set CLASS_PATH=-d ../bin -cp %PLATFORM_IMPL%
set CLASS_PATH=-d ../bin

javac.exe %CLASS_PATH% com/emrecellebi/Console.java
jar.exe cfvm ../DigitalClock.jar META-INF/MANIFEST.MF -C ../bin/ .