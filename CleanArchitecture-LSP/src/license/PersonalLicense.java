package license;

public class PersonalLicense implements License {

    public PersonalLicense() {

    }


    @Override
    public void calcLicenseFee() {
        System.out.println("License fee is 100 Euros");
    }
}
