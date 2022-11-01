package license;

public class BusinessLicense implements License {

    private String user;

    public BusinessLicense(String user) {
        this.user = user;
    }

    @Override
    public void calcLicenseFee() {
        System.out.println("License fee is about 20 Euros for " + user);
    }
}
