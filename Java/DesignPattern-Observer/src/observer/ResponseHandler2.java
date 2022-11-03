package observer;

import java.util.Observable;
import java.util.Observer;

public class ResponseHandler2 implements Observer {

    private String response;

    public void update(Observable object, Object argument) {

        if (argument instanceof String) {
            response = (String) argument;

            System.out.println("Received response: " + argument);
        }

    }

}
