setlocal

cd ./server
call mvn jib:dockerBuild

endlocal