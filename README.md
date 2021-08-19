# Selenium_Test_BH_Room
Testsuite for BH-Room

___

## Ausführung der Tests:
Erstellen Sie die DB mit den Testdaten neu. Die Skripte finden Sie im Projekt "Business-Hotel-Roommanager" im Ordner "database"

1. Erstellen Sie die Datenbank neu mit dem SQL Skript "DatabaseCreate.sql"
2. Füllen Sie die Datenbank mit dem Skript "Testdatensatz.sql"

1. Führen Sie zunächst den Ordner PageTest aus.
2. Führen Sie danach den Ordner DatabaseTest aus.

Obwohl der PageTest bereits einige Datenbanktests integriert hat, wird die Funktion des Eintrages in die Datenbank im gesamten nur durch die DatabaseTest abgedeckt.
Innerhalb der PageTest finden Sie jeweils ein Element mit der Bezeichnung der Page (z.B. RegisterPage) und eine Datei mit den Test (z.B. RegisterPageTest).
In der Page-Datei der jeweiligen Seite finden Sie die xpath-Variablen der Seite. Jedes Element was im Test verwendet wurde, wird hier vorhergehend definiert, zur Übersichtlichkeit und Strukturierung des Codes.
In den Klassen die mit "Test" im Namen enden, finden Sie die eigentlichen Tests. 
