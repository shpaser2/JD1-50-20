package StringAndENUMs;

import java.util.Scanner;

public class EnumsMain4 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dayName = scanner.nextLine();
        Day day = Day.valueOfIgnoreCase(dayName);
        System.out.println("Название дня на русском: " + day.getRusName());
        System.out.println("Является ли рабочим днём: " + day.isWorkDay());
        System.out.println("Название дня в оригинале: " + day.name());
    }
}
