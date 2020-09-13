package operators;

import java.util.Objects;
import java.util.Scanner;

public class OperatorsMain6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Вы ввели " + name);


        String friend = "Вася";
        String girlFriend = "Анастасия";

        boolean checkFriend = Objects.equals(friend, name);
        if(checkFriend){
            System.out.println("Привет");
            System.out.println("Я тебя так долго ждал");
            return;
        }

        boolean checkGirlFriend = Objects.equals(girlFriend, name);
        if(checkGirlFriend){
            System.out.println("Я тебя так долго ждал");
            return;
        }

        System.out.println("Ты кто?");
    }
}
