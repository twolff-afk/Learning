#include <string>
#include "Logger.h"

/*
* Dieses Projekt enthält einen Logger als Singleton. Dadurch wird im gesamten Projekt nur eine Instanz eines Loggers erzeugt und verwendet.
*/

int main(int argc, char* argv[])
{

    std::string message1 = "logg message 1 ...";
    std::string message2 = "logg message 2 ...";
    int    nNum = 10;
    Logger::GetLogger()->Log("message to be logged");
    Logger::GetLogger()->Log(message1);

    LOGGER->Log(" Message is:%s Number is:%d", message2.c_str(), nNum);
    
    return 0;

}