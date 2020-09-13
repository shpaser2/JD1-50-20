package strings;

import java.util.Scanner;

public class EnumsMain4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dayName = scanner.nextLine();
        Day day = Day.valueOfIgnoreCase(dayName);
        System.out.println("Русское наименование " + day.getRusName());
        System.out.println("Рабочий день? " + day.isWorkDay());
        System.out.println("Наименование элемента " + day.name());
    }
}
