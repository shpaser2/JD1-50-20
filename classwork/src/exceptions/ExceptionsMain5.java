package exceptions;

import exceptions.elite_exceptions.AggregatedException;
import exceptions.elite_exceptions.ArrayLengthNotValidException;
import exceptions.elite_exceptions.NumberIsNegativeException;

import java.util.ArrayList;
import java.util.List;

public class ExceptionsMain5 {

    public static final String ARRAY_LENGTH_ERROR_MESSAGE = "длина массива не 2";

    public static void main(String[] args) {
        try{
            validateArgument(args);
        } catch (ArrayLengthNotValidException | NumberIsNegativeException e){
            System.exit(12);
        } catch (IllegalArgumentException | AggregatedException ex){
            String message = ex.getMessage();
            if(message != null){
                System.out.println(message);
            } else {
                System.out.println("Внутренняя ошибка сервера");
            }
        }

    }

    /**
     * 1. Проверяет что длинна массива 1
     * 2. Проверяет что аргумент число
     * 3. Проверяет что аргумент не отрицательный
     * 4. Проверяет что аргумент это число состоящее не более чем из 21 цифр
     * @param args
     */
    public static void validateArgument(String[] args){
        List<String> messages = new ArrayList<>();
        if (args.length!=1){
            messages.add("Длинна массива не равняется 1");
        }

        String str = args[0];

        Long x = null;
        try{
            x = Long.parseLong(str);
        } catch (NumberFormatException e){
            messages.add("Первый аргумент не число");
        }

        if(x == null){
            messages.add("Первый аргумент пустой");
        }

        if(x != null && x < 0){
//            throw new RuntimeException("Всё очень плохо");
            messages.add("Первый аргумент отрицательный");
        }

        if(str.length() > 21){
            messages.add("Первый аргумент больше 21 символа");
        }

        if(messages.size() > 0){
            AggregatedException aggException = new AggregatedException(messages);
            throw aggException;
        }

    }
}
