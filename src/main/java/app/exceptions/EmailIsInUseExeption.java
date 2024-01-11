package app.exceptions;

public class EmailIsInUseExeption extends RuntimeException{
    public EmailIsInUseExeption(String message) {super(message);}
}
