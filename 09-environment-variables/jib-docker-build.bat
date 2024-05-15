@REM this `echo off` prevents the batch file from showing used commands in console. 
@echo off

setlocal

set directories=spring-boot

for %%s in (%directories%) do (
    cd %%s
    call mvn clean compile jib:dockerBuild
    cd ..
)

@if "%~1%" == "-c" (
    call docker-compose up -d --build
)

endlocal