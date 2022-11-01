// FirstFunctionPointer.cpp : Diese Datei enthält die Funktion "main". Hier beginnt und endet die Ausführung des Programms.
//

#include "encryptData.h"

#include <iostream>

// typedef definiert eigene Typen, diese können wiederverwendet werden, wie in 'buildCompleteMessage'
// In diesem Fall ist 'ptrReturnString' der Name des Typs
typedef std::string(*ptrReturnString)(std::string);

// Definiere Typen mit dem Namen 'ptrEncryptData' mit Rückgabewert 'std::string', Argument 'std::string' der Klasse 'encryptData'
typedef std::string(encryptData::* ptrEncryptData) (std::string);

// 'using' erzeugt hier den allgemeinen Typen 'str_func_str'
// Funktionen 'returnString' und 'addSomeToString' haben die gleichen Rückgabewerte und Argumente
// Dadurch kann ein Typ erzeugt werden und dieser öfter im Code benutzt werde
using str_func_str =  std::string(*)(std::string);

std::string addSomeToString(std::string msg)
{
    return "other String func " + msg;
}

std::string returnString(std::string msg)
{
    return "returnString " + msg;
}

// Funktion mit einem function-pointer als Argument
// Dieses Argument wurde mit typedef abgekürzt
// ptrReturnString ist hier der Typ und ptrReStr ist der Wert
std::string buildCompleteMessage(std::string rawData, ptrReturnString ptrReStr)
{
    // Add some header and footer to data to make it complete message
    rawData = "[HEADER]" + rawData + "[FooTER]";

    // Aufruf der Funktion, die im function-pointer gespeichert ist mit dem Argument 'rawData'
    rawData = ptrReStr(rawData);
    return rawData;
}


int main()
{
    //__________________________________________________________________________________________________________
    // TypeDef definiert ptrReturnString und wird mit der Adresse von der Funktion 'returnString' beschrieben
    ptrReturnString ptrReStr = &returnString;

    // Aufruf des function-pointers
    std::cout << ptrReStr("typeDef function pointer!") << std::endl;
    
    //___________________________________________________________________________________________________________
    // Erzeuge Objekt 'ed2' von der Klasse encryptData
    encryptData ed2;

    // Mit 'typedef' von oben wurde der Typ 'ptrEncryptData' erstellt und mit der Adresse von der Funktion 'encryptDataByLetter' der Klasse 'encryptData' belegt
    ptrEncryptData ptrEnData = &encryptData::encryptDataByLetterInc;
    std::cout << (ed2.*ptrEnData)("typeDef function pointer of encryptData!") << std::endl;

    //___________________________________________________________________________________________________________
    // Hier wird 'ptrAddSome' vom Typ 'str_func_str' erzeugt und mit der Adresse von der Funktion 'addSomeToString belegt
    str_func_str ptrAddSome = &addSomeToString;
    std::cout << ptrAddSome("using to declare a generic typ, here addSomeToString!") << std::endl;

    // Hier wird 'str_func_str' nochmals benutzt, um einen neuen function-pointer zu erzeugen und ihn mit der Adresse
    // der Funktion 'returnString' zu belegen
    str_func_str ptrReString = &returnString;
    std::cout << ptrReString("using to declare a generic typ, here returnString!") << std::endl;

    //___________________________________________________________________________________________________________
    // Objekt 'ed' der Klasse 'encryptData'
    encryptData ed;

    // Das Objekt 'ed' hat einen function-pointer
    // Dieser wird mit der Adresse der Funktion 'encryptDataByLetterInc' der Klasse 'encryptData' belegt
    //ed.ptrEncryptData = &encryptData::encryptDataByLetterInc;

    // Aufruf der Funktion des function-pointer
    // Objekt 'ed'. gibt den Member der Klasse wieder
    // Aufruf eines function-pointers kann durch * erfolgen
    // (ed.ptrEncryptDara) gibt den function-pointer wieder
    // std::cout << (ed.*(ed.ptrEncryptData))("Hello World!") << std::endl;

    //___________________________________________________________________________________________________________
    // Aufruf der Funktion 'buildCompleteMessage' mit string und ptrReStr als Adresse zur Funktion 'returnString'
    std::cout << buildCompleteMessage("function with function-pointer as arg", ptrReStr) << std::endl;

}