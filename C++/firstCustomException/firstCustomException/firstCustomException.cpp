
#include <exception>
#include <iostream>

struct DivisonByZeroException : public std::exception
{
    const char* errorMessage = "Division by zero";

    void toUpperCase()
    {
        errorMessage = "DIVISON BY ZERO";
    }

    const char* getMessage() const throw ()
    {
        return errorMessage;
    }
};

bool isNotZero(int value)
{
    if (value == 0)
    {
        return false;
    }
    else
    {
        return true;
    }
}

int divison(int a, int b) throw (DivisonByZeroException)
{
    if (isNotZero(a) && isNotZero(b))
    {
        return a / b;
    }
    else
    {
        throw DivisonByZeroException();
    }
}

int alternativeDivision(int a, int b) throw (DivisonByZeroException)
{
    // So geht es leider nicht
    try
    {
        return a / b;
    }
    catch (DivisonByZeroException)
    {
        throw DivisonByZeroException();
    }
}

void logError(DivisonByZeroException errorMessage)
{
    // kleine Logger Funktion
    errorMessage.toUpperCase();

    std::cout << errorMessage.getMessage() << std::endl;
}

int main()
{

    int a = 10;
    int b = 0;

    try
    {
        // Hier wird einfach die Funktion aufgerufen
        int result = divison(a, b);
    }
    catch (DivisonByZeroException& e)
    {
        logError(e);
    }
}