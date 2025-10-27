package Exceptions;

public class OverflowException extends RuntimeException {

    public OverflowException() {
        super();
    }

    @Override
    public String getMessage() {
        return "A lista está cheia!";
    }
}
