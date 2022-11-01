package singleton;

/*
This singleton version is created at load time. The call of "new" happens right after loading.
 */
public class EarlySingleton {

    private static EarlySingleton earlySingleton = new EarlySingleton();
    String message;

    /*
    Constructor should not be used and is therefore not visible from the outside
     */
    private EarlySingleton() {
        message = "Hello, I'm an earlySingleton";
    }

    public static EarlySingleton getSingleton() {
        return earlySingleton;
    }

    public String getMessage() {
        return this.message;
    }
}
