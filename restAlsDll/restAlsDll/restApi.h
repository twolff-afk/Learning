// restApi.h - Contains declarations of math functions
#pragma once

/*
When the RESTAPI_EXPORTS macro is defined, the RESTAPI_API macro sets the __declspec(dllexport) modifier on the function declarations.
This modifier tells the compiler and linker to export a function or variable from the DLL for use by other applications.
When MATHLIBRARY_EXPORTS is undefined, for example, when the header file is included by a client application,
RESTAPI_API applies the __declspec(dllimport) modifier to the declarations.
This modifier optimizes the import of the function or variable in an application.
*/
#ifdef RESTAPI_EXPORTS
#define RESTAPI_API __declspec(dllexport)
#else
#define RESTAPI_API __declspec(dllimport)
#endif

extern "C" RESTAPI_API void callBing();
