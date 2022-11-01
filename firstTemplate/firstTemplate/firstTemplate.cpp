#include <iostream>
#include <string>

template<typename T> inline T const& Maximum(T const& x, T const& y) {
	return x < y ? y : x;
}

template<typename T> inline T Add(T const& x, T const& y) {
	return x + y;
}

int main()
{

	int i = 21;
	int e = 15;
	std::cout << Maximum(i, e) << std::endl;
	std::cout << Add(i, e) << std::endl;
	std::cout << std::endl;

	double number = 39.2;
	double number2 = 23.5;
	std::cout << Maximum(number, number2) << std::endl;
	std::cout << Add(number, number2) << std::endl;
	std::cout << std::endl;

	std::string name = "Tobi";
	std::string name2 = "Andreas";
	std::cout << Maximum(name, name2) << std::endl;
	std::cout << Add(name, name2) << std::endl;
	std::cout << std::endl;

}