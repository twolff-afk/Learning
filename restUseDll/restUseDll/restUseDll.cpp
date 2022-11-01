// MathClient.cpp : Client app for MathLibrary DLL.
// #include "pch.h" Uncomment for Visual Studio 2017 and earlier
#include <iostream>
#include "restApi.h"

int main()
{
    std::cout << "Start application" << std::endl;

    std::cout << "Call Bing" << std::endl;

    // call bing macht eine suche bei der suchmaschine bing nach cpprestsdk und druckt das in einer html aus
    callBing();

    std::cout << "End" << std::endl;
    return 0;
}