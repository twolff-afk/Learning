package service;

public class Service implements ServiceInterface {

    private String serviceName;

    public Service(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public void executeService() {
        System.out.println("Service executed");
    }

}
