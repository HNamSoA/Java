package domain.exceptions;

public class ItemPlacedDirectlyException extends Exception {
    
    public ItemPlacedDirectlyException(String message) {
        super(message+" (EX: 5 )");
    }

    public ItemPlacedDirectlyException() {
        super("Exception: Item connot placed directly on the container.(EX: 5 )");
    }
}