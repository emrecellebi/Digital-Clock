@echo off

REM set PLATFORM_IMPL=../lib/platform-impl.jar;
REM set CLASS_PATH=-cp ../bin;%PLATFORM_IMPL%
set CLASS_PATH=-cp ../bin;

java.exe -Dparent.directory=../ %CLASS_PATH% com.emrecellebi.Console %*