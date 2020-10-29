package exceptions.elite_exceptions;

public class NumberIsNegativeException extends IllegalArgumentException{

    public NumberIsNegativeException() {
        super("Число не может быть негативным");
    }

    public NumberIsNegativeException(String s) {
        super(s);
    }

    public NumberIsNegativeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NumberIsNegativeException(Throwable cause) {
        super(cause);
    }
}
