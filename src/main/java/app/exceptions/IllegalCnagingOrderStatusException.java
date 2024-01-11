package app.exceptions;

public class IllegalCnagingOrderStatusException extends RuntimeException{
    public IllegalCnagingOrderStatusException(String message){
        super(message);
    }
}
