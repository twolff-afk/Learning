package main;

import service.ServiceFactory;
import service.ServiceFactoryInterface;
import service.ServiceInterface;


/*
This example is about the dependency inversion principle. In code you should not rely on
concrete implementations.
You want to create some services, but you do not want to use concrete code.
So you use factories, of course at one point you need to implement the code, in this case
the service factory

 */
public class Main {

    public static void main(String[] args) {

        ServiceFactoryInterface factory = new ServiceFactory();
        ServiceInterface service = factory.createService("FirstService");
        service.executeService();

    }

}
