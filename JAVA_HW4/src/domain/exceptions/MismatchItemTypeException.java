package domain.exceptions;

public class MismatchItemTypeException extends Exception{

     public MismatchItemTypeException(String message){
        super(message+" (EX: 2)");
    }

    public MismatchItemTypeException(){
        super("EXCEPTION: Item type mismatch.(EX: 2 )");
    }
}