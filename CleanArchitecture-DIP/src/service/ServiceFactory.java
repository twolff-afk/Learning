package service;

public class ServiceFactory implements ServiceFactoryInterface {
    
    public ServiceFactory() {

    }

    @Override
    public Service createService(String name) {
        Service service = new Service(name);
        return service;
    }
}
