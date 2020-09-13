package strings;

import java.util.Scanner;

public class StringsMain3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cat = "кошка";
        for (int i = 0; i < 10; i++) {
            String catFromConsole = scanner.nextLine();
            System.out.println(cat == catFromConsole);
            catFromConsole = catFromConsole.intern();
            System.out.println(cat == catFromConsole);
        }
    }
}
