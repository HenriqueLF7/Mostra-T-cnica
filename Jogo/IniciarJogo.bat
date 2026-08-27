@echo off

title Jogo Zumbi

echo ================================
echo       JOGO ZUMBI
echo ================================
echo.

echo Compilando o jogo...

javac -cp "backend\lib\sqlite-jdbc-3.53.4.0.jar" backend\src\*.java

if errorlevel 1 (
    echo.
    echo ERRO: Nao foi possivel compilar o Java.
    echo.
    pause
    exit
)

echo.
echo Java compilado com sucesso!
echo.
echo Iniciando servidor...

start "" cmd /k "java -cp "backend\src;backend\lib\sqlite-jdbc-3.53.4.0.jar" Main"

timeout /t 2 /nobreak >nul

echo Abrindo o jogo...

start "" http://localhost:8080

exit