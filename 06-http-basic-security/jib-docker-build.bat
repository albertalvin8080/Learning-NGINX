@REM this `echo off` prevents the batch file from showing used commands in console. 
@echo off

setlocal

cd spring-boot

@REM The style.css inside the static\ needs to be inside both Spring App and NGINX containers. 
copy ..\static src\main\resources\static

call mvn clean compile jib:dockerBuild

@REM executes this block only if the flag `-c` was provided.
@if "%~1%" == "-c" (
    cd ..
    call docker-compose up -d --build
)

endlocal