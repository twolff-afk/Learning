#pragma once

#include <fstream>
#include <iostream>
#include <cstdarg>
#include <string>

// Aufruf als Makro definiert
#define LOGGER Logger::GetLogger()

/**
*   Singleton Logger Class.
*/
class Logger
{

public:

    /**
    *   Logs a message
    *   @param sMessage message to be logged.
    */
    void Log(const std::string& sMessage);

    /**
    *   Variable Length Logger function
    *   @param format string for the message to be logged.
    */
    void Log(const char* format, ...);

    /**
    *   << overloaded function to Logs a message
    *   @param sMessage message to be logged.
    */
    Logger& operator<<(const std::string& sMessage);
    
    /**
    *   Funtion to create the instance of logger class.
    *   @return singleton object of Clogger class..
    */
    static Logger* GetLogger();

private:

    /**
    *    Default constructor for the Logger class.
    */
    Logger();                               // Standardkonstruktor ist private, sodass niemand den Aufrufen kann

    /**
    *   copy constructor for the Logger class.
    */
    Logger(const Logger&) {};               // Copy-Constructor ebenfalls private, sodass niemand den Aufrufen kann

    /**
    *   assignment operator for the Logger class.
    */
    Logger& operator=(const Logger&) { return *this; };  // assignment operator is private

    /**
    *   Log file name.
    **/
    static const std::string m_sFileName;  // filename ist private, braucht niemand wissen

    /**
    *   Singleton logger class object pointer.
    **/
    static Logger* m_pThis;                 // pointer zu der Klasse

    /**
    *   Log file stream object.
    **/
    static std::ofstream m_Logfile;

};