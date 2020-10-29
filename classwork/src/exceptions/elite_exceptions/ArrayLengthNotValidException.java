package exceptions.elite_exceptions;

/**
 *  Данный эксепшен выбрасывается если не прошли проверку длинны массива. Сам дурак.
 */
public class ArrayLengthNotValidException extends IllegalArgumentException{
    public ArrayLengthNotValidException() {
        super("Длинна массива не валидна");
    }

    public ArrayLengthNotValidException(int length) {
        super("Длинна массива: " + length + ". Данная длинна не валидна");
    }

    public ArrayLengthNotValidException(int currentLength, int exceptedLength) {
        super("Длинна массива: " + currentLength + ". Данная длинна не валидна, мы ожидали " + exceptedLength);
    }

    public ArrayLengthNotValidException(String s) {
        super(s);
    }

    public ArrayLengthNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayLengthNotValidException(Throwable cause) {
        super(cause);
    }
}
