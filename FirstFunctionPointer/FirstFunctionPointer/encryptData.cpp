#include "encryptData.h"

std::string encryptData::encryptDataByLetterInc(std::string data)
{
    for (int i = 0; i < data.size(); i++)
    {
        if ((data[i] >= 'a' && data[i] <= 'z') || (data[i] >= 'A' && data[i] <= 'Z'))
            data[i]++;
    }
    return data;
}
