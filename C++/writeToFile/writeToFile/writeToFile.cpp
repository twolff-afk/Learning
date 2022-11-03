// writeToFile.cpp : Diese Datei enthält die Funktion "main". Hier beginnt und endet die Ausführung des Programms.
//

#include <iostream>
#include <fstream>
#include <string>


void writeFile()
{
    std::ofstream myfile;
    myfile.open("example.txt");
    myfile << "log this to a file.\n";
    myfile << "error this to a file.\n";
    myfile << "info this to a file.\n";
    myfile << "debug this to a file.\n";
    myfile.close();
}

void reopenFile()
{
    std::ofstream reopenFile;
    reopenFile.open("example.txt", std::ios_base::app);
    reopenFile << "Append this to existig text.\n";
    reopenFile.close();
}

void processFile()
{
    std::ifstream file("example.txt");
    std::string str;
    while (std::getline(file, str))
    {

        if (str.find("info") != std::string::npos)
        {
            std::cout << str << std::endl;
        }
    }
}

int main()
{
    writeFile();
    reopenFile();
    processFile();
}

// Programm ausführen: STRG+F5 oder Menüeintrag "Debuggen" > "Starten ohne Debuggen starten"
// Programm debuggen: F5 oder "Debuggen" > Menü "Debuggen starten"

// Tipps für den Einstieg: 
//   1. Verwenden Sie das Projektmappen-Explorer-Fenster zum Hinzufügen/Verwalten von Dateien.
//   2. Verwenden Sie das Team Explorer-Fenster zum Herstellen einer Verbindung mit der Quellcodeverwaltung.
//   3. Verwenden Sie das Ausgabefenster, um die Buildausgabe und andere Nachrichten anzuzeigen.
//   4. Verwenden Sie das Fenster "Fehlerliste", um Fehler anzuzeigen.
//   5. Wechseln Sie zu "Projekt" > "Neues Element hinzufügen", um neue Codedateien zu erstellen, bzw. zu "Projekt" > "Vorhandenes Element hinzufügen", um dem Projekt vorhandene Codedateien hinzuzufügen.
//   6. Um dieses Projekt später erneut zu öffnen, wechseln Sie zu "Datei" > "Öffnen" > "Projekt", und wählen Sie die SLN-Datei aus.
