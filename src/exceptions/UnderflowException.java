package exceptions;

public class UnderflowException extends RuntimeException {
    @Override
    public String getMessage() {
        return "A lista está vazia!";
    }
}
