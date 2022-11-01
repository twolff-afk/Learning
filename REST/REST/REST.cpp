
#include <cpprest/http_client.h>
#include <cpprest/filestream.h>

#include <iostream>
#include <fstream>
#include <string>
#include <typeinfo>

using namespace utility;                    // Common utilities like string conversions
using namespace web;                        // Common features like URIs.
using namespace web::http;                  // Common HTTP functionality
using namespace web::http::client;          // HTTP client features
using namespace concurrency::streams;       // Asynchronous streams


int main()
{

    // Create http_client to send the request.
    uri url(U("http://www.bing.com/"));
    http_client client(url);

    // Build request URI and start the request.
    uri request(U("/search"));
    uri_builder b(request);
    // web::uri_builder builder(U("/search"));
    b.append_query(U("q"), U("cpprestsdk github"));


    pplx::task<web::http::http_response> response = client.request(web::http::methods::GET, b.to_string());

    std::cout << "Get" << std::endl;

    response.then([=](web::http::http_response response)
    {
        std::cout << "repsonse" << std::endl;

    });

    std::cout << "start wait" << std::endl;

    // Wait for all the outstanding I/O to complete and handle any exceptions
    try
    {
        response.wait();
    }
    catch (const std::exception& e)
    {
        std::string error = e.what();

        std::cout << "error" << std::endl;

    }














    auto fileStream = std::make_shared<ostream>();

    // Open stream to output file.
    pplx::task<void> requestTask = fstream::open_ostream(U("results_nba.html"))
        
        .then([=](ostream outFile)
        {
            *fileStream = outFile;

            // Create http_client to send the request.
            http_client client(U("http://www.bing.com/"));
            // http://localhost:1336/api/lego/openView


            // Build request URI and start the request.
            uri_builder builder(U("/search"));


            builder.append_query(U("q"), U("cpprestsdk github"));
            // :scannerId/:produktId
            // scannerID und ProduktID ersetzen durch dann realen Werte
            
            return client.request(methods::GET, builder.to_string());
        })

        // Handle response headers arriving.
        .then([=](http_response response)
        {
            printf("Received response status code:%u\n", response.status_code());

            // Write response body into the file.
            return response.body().read_to_end(fileStream->streambuf());
        })

        // Close the file stream.
        .then([=](size_t)
        {
            return fileStream->close();
        })
    ;

    // Wait for all the outstanding I/O to complete and handle any exceptions
    try
    {
        requestTask.wait();
    }
    catch (const std::exception& e)
    {
        printf("Error exception:%s\n", e.what());
    }

    return 0;
}
