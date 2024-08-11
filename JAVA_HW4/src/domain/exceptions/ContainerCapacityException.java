package domain.exceptions;

public class ContainerCapacityException extends Exception {
    
    public ContainerCapacityException(String message) {
        super(message+" (EX: 4 )");
    }

    public ContainerCapacityException() {
        super("Exception: More than capacity (EX: 4 )");
    }
}