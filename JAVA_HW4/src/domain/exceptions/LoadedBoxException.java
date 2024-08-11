package domain.exceptions;

public class LoadedBoxException extends Exception {
    
    public LoadedBoxException() {
        super("The box is loaded (EX: 7 )");
    }

    public LoadedBoxException(String message) {
        super(message+" (EX: 7 )");
    }
}