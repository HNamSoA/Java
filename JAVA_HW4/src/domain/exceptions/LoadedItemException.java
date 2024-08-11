package domain.exceptions;

public class LoadedItemException extends Exception {
    
    public LoadedItemException(String message) {
        super(message+" (EX: 6 )");
    }

    public LoadedItemException() {
        super("Item is already loaded (EX: 6 ");
    }
}