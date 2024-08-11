package domain.exceptions;

public class ShippedContainerException extends Exception {
    
    public ShippedContainerException() {
        super("Containers That Have Already Shipped Exception (EX: 8 existing serial number)");
    }
    
    public ShippedContainerException(String message) {
        super(message+" (EX: 8)");
    }
}