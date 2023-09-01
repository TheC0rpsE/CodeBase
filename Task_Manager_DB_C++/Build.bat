@echo off

REM Compilation des fichiers source C++
g++ main.cpp TaskManagerDB.cpp Task.cpp -o Main -lsqlite3

REM Vérification du statut de la compilation
if %errorlevel% equ 0 (
    echo Compilation réussie.
    REM Exécution du programme
    Main.exe
) else (
    echo Erreur de compilation.
)

