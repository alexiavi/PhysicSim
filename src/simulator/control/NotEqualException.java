package simulator.control;

import org.json.JSONObject;

public class NotEqualException extends Exception {

    public NotEqualException( JSONObject obj, JSONObject cur, int steps) {
        super("States are not equal. States are :" + obj + cur + " Execution step: " + steps);
    }

}
