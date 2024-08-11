package domain.exceptions;

public class BoxCapacityException extends Exception {
    public BoxCapacityException(String message) {
        super(message+" (EX: 3)");
    }

    public BoxCapacityException() {
        super("Exception: More than capacity (EX: 3 )");
    }
}