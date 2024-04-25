package day_one.exceptions_testing;

public class InvalidTransactionAmountException extends RuntimeException{

    public InvalidTransactionAmountException(String message) {
        super(message);
    }
}
