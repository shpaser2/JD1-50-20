package StringAndENUMs;

public class MainForEnum {
    public static void main(String[] args) {
        Day day = Day.MONDAY;
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;
            case FRIDAY:
                System.out.println("Fridays are better.");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekends are best.");
                break;
            default:
                System.out.println("Midweek are so-so.");
                break;
        }
        System.out.println(day.ordinal());  //очень не рекомендуется
        // использовать - при смене порядка в ENUM сломает приложение.
        System.out.println(day.name());     // всегда вернет имя элемента
        System.out.println(day.toString()); // может вернуть имя элемента
        Day day2 = Day.valueOf("MONDAY");
    }
}
