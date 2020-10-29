package exceptions.elite_exceptions;

import java.util.List;

public class AggregatedException extends RuntimeException{

    private List<String> messages;


    public AggregatedException(List<String> messages) {
        this.messages = messages;
    }

    public AggregatedException() {
        super("Сборная салянка");
    }

    public AggregatedException(String message) {
        super(message);
    }

    public AggregatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AggregatedException(Throwable cause) {
        super(cause);
    }

    public AggregatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getMessage() {
        if(messages != null && messages.size() > 0){
            return String.join("\n", messages);
        }
        return super.getMessage();
    }
}
