@echo off

title Jogo Zumbi

echo ================================
echo       JOGO ZUMBI
echo ================================
echo.

echo Compilando o jogo...

javac backend\src\Main.java

if errorlevel 1 (
    echo.
    echo ERRO: Nao foi possivel compilar o Java.
    echo Verifique se o Java JDK esta instalado.
    echo.
    pause
    exit
)

echo.
echo Java compilado com sucesso!
echo.
echo Iniciando servidor...

start "" cmd /k "java -cp backend\src Main"

timeout /t 2 /nobreak >nul

echo Abrindo o jogo...

start "" http://localhost:8080

exit