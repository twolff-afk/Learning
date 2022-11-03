package singleton;

public class LazySingleton {

    private static LazySingleton lazySingleton;
    private String message;

    /*
    Here again, only one instance of a singleton should be created
    therefore constructor is private.
     */
    private LazySingleton() {
        message = "I'm a lazySingleton";
    }

    /*
    This method returns lazySingleton, but checks first whether lazySingleton is initialized or not.
    synchronized means here only one thread at a time can access the resource.
     */
    public static LazySingleton getLazySingleton() {

        if (lazySingleton == null) {
            synchronized (LazySingleton.class) {
                lazySingleton = new LazySingleton();
            }
        }
        return lazySingleton;
    }

    public String getMessage() {
        return this.message;
    }

}
