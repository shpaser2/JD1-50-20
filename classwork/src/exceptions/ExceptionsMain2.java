package exceptions;

public class ExceptionsMain2 {
    public static void main(String[] args) {
        selfCall();
    }

    public static void selfCall(){
        selfCall();
    }
}
