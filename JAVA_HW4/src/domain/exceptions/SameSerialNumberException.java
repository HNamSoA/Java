package domain.exceptions;

public class SameSerialNumberException extends Exception{
    
    public SameSerialNumberException(String message){
        super(message+" (EX: 1 )");
    }
    
    public SameSerialNumberException(){
        super("Item cannot be produced because of same serial number of already produced object  (EX: 1 )");
    }
}
