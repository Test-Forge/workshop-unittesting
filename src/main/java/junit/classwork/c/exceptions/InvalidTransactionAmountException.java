package junit.classwork.c.exceptions;
// custom exception
public class InvalidTransactionAmountException extends RuntimeException{

    public InvalidTransactionAmountException(String message) {
        super(message);
    }
}
