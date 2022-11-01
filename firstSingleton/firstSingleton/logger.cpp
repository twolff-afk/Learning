#include "Logger.h"
#include "Logger.h"
#include"Utilities.h"

const std::string Logger::m_sFileName = "Log.txt";
Logger* Logger::m_pThis = NULL;
std::ofstream Logger::m_Logfile;

// Standardkonstruktor kann einfach leer bleiben
Logger::Logger()
{

}

// GetLogger prüft, ob der Pointer zu dem Loggerobjekt Null ist
// Man kann Pointer die Null sind vergleichen
// Wenn sie gelöscht werden, kommt es zu einem Programmabsturz
Logger* Logger::GetLogger() {

    if (m_pThis == NULL) {
        m_pThis = new Logger(); // Falls der Pointer Null ist, gibt es gerade kein Loggerobjekt, also wird ein neues erzeugt
                                // new lokalisiert neuen Speicher und gibt einen Pointer zu der Klasse Logger zurück
        m_Logfile.open(m_sFileName.c_str(), std::ios::out | std::ios::app);
    }
    
    return m_pThis;
}

// three dots (...) is a template parameter pack, 
void Logger::Log(const char* format, ...)
{
    char* sMessage = NULL;
    int nLength = 0;
    va_list args;
    va_start(args, format);
    //  Return the number of characters in the string referenced the list of arguments.
    // _vscprintf doesn't count terminating '\0' (that's why +1)
    nLength = _vscprintf(format, args) + 1;
    sMessage = new char[nLength];
    vsprintf_s(sMessage, nLength, format, args);
    //vsprintf(sMessage, format, args);
    m_Logfile << Util::CurrentDateTime() << ":\t";
    m_Logfile << sMessage << "\n";
    va_end(args);

    delete[] sMessage;
}

void Logger::Log(const std::string& sMessage)
{
    m_Logfile << Util::CurrentDateTime() << ":\t";
    m_Logfile << sMessage << "\n";
}

Logger& Logger::operator<<(const std::string& sMessage)
{
    m_Logfile << "\n" << Util::CurrentDateTime() << ":\t";
    m_Logfile << sMessage << "\n";
    return *this;
}