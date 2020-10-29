package exceptions;

import exceptions.elite_exceptions.ArrayLengthNotValidException;
import exceptions.elite_exceptions.NumberIsNegativeException;

public class ExceptionsMain4 {

    public static final String ARRAY_LENGTH_ERROR_MESSAGE = "длина массива не 2";

    public static void main(String[] args) {
        try{
            validateArgument(args);
        } catch (ArrayLengthNotValidException | NumberIsNegativeException e){
            System.exit(12);
        } catch (IllegalArgumentException ex){
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
        if (args.length!=1){
            throw new ArrayLengthNotValidException(args.length, 1);
        }

        String str = args[0];

        Long x = null;
        try{
            x = Long.parseLong(str);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Вы передали не число", e);
//            throw new IllegalArgumentException("Вы передали не число");
        }

        if(x == null){
            throw new IllegalArgumentException("Передана пустота");
        }

        if(x < 0){
//            throw new RuntimeException("Всё очень плохо");
            throw new NumberIsNegativeException();
        }

        if(str.length() > 21){
            throw new IllegalArgumentException("Число содержит более 21 цифры. Это не допустимо");
        }
    }
}
