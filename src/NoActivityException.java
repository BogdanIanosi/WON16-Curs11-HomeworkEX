// NoActivityException.java
public class NoActivityException extends RuntimeException {
    public NoActivityException(String message) {
        super(message);
    }
}
// NoActivitiesForDayException.java
class NoActivitiesForDayException extends Exception {
    public NoActivitiesForDayException(String message) {
        super(message);
    }
}

