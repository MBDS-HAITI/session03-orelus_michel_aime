@echo off
setlocal

set JAVA_HOME=C:\Java\jdk_25
set JAVAC=%JAVA_HOME%\bin\javac.exe
set JAVA=%JAVA_HOME%\bin\java.exe

set SRC_DIR=%~dp0src\main\java
set OUT_DIR=%~dp0target\classes
set MAIN_CLASS=org.example.Main

echo ========================================
echo   BATTLE ARENA - Compilation...
echo ========================================

if not exist "%OUT_DIR%" mkdir "%OUT_DIR%"

:: List all .java files into a temp file, then pass it to javac
dir /b /s "%SRC_DIR%\*.java" > "%TEMP%\sources.txt"

"%JAVAC%" -d "%OUT_DIR%" @"%TEMP%\sources.txt"

if %ERRORLEVEL% neq 0 (
    echo.
    echo [ERREUR] La compilation a echoue. Verifiez les sources.
    pause
    exit /b 1
)

echo Compilation reussie !
echo.
echo ========================================
echo   BATTLE ARENA - Lancement du jeu...
echo ========================================
echo.

"%JAVA%" -cp "%OUT_DIR%" %MAIN_CLASS%

echo.
pause
endlocal
