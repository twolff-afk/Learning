
#include <cpprest/http_client.h>

#include <iostream>

int main()
{

	// Create http_client to send the request.
	web::http::client::http_client client(U("http://www.bing.com/"));

	// Build request URI and start the request.
	web::uri_builder builder(U("/search"));
	builder.append_query(U("q"), U("cpprestsdk github"));

	pplx::task<web::http::http_response> resp = client.request(web::http::methods::GET, builder.to_string());

	
	resp.then([=](web::http::http_response response)
	{

		std::cout << "Statuscode: " << std::to_string(response.status_code()) << std::endl;

		std::cout << "Request done" << std::endl;


	});
	
	// Wait for all the outstanding I/O to complete and handle any exceptions
	try
	{
		resp.wait();
	}
	catch (const std::exception& e)
	{
		printf("Error exception:%s\n", e.what());
	}

	return 0;

}
