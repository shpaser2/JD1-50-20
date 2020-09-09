package StringAndENUMs;

public class EnumsMain2 {
//    Day day = Day.MONDAY;
//    static Day day2 = Day.WEDNESDAY;
    
    public static void main(String[] args) {
//        Day day = Day.MONDAY;
//        System.out.println(getRusName(day));
//        Day day2 = Day.WEDNESDAY;
//        new EnumsMain2().day2 = Day.FRIDAY;
//        EnumsMain2 obj = new EnumsMain2();
//        obj.day2 = Day.FRIDAY;
//        System.out.println(getRusName());
        Day day555 = Day.FRIDAY;
        System.out.println(getRusName(day555));
        System.out.println(getRusName(Day.THURSDAY));
    }
    
    /**
     * Идемпотентный метод - результат всегда один и тот же при
     * одинаковом аргументе.
     * @param day
     * @return
     */
    public static String getRusName(Day day) {
        switch (day) {
            case MONDAY: return "Понедельник";
            case TUESDAY: return "Вторник";
            case WEDNESDAY: return "Среда";
            case THURSDAY: return "Четверг";
            case FRIDAY: return "Пятница";
            case SATURDAY: return "Суббота";
            case SUNDAY: return "Воскресенье";
            default: return "неизвестно";
        }
    }
    
//    public static String getRusName() {
//        switch (new EnumsMain2().day2) {
//            case MONDAY: return "Понедельник";
//            case TUESDAY: return "Вторник";
//            case WEDNESDAY: return "Среда";
//            case THURSDAY: return "Четверг";
//            case FRIDAY: return "Пятница";
//            case SATURDAY: return "Суббота";
//            case SUNDAY: return "Воскресенье";
//            default: return "неизвестно";
//        }
//    }
    
//    public static String getRusName() {
//        EnumsMain2 obj = new EnumsMain2();
//        switch (obj.day2) {
//            case MONDAY: return "Понедельник";
//            case TUESDAY: return "Вторник";
//            case WEDNESDAY: return "Среда";
//            case THURSDAY: return "Четверг";
//            case FRIDAY: return "Пятница";
//            case SATURDAY: return "Суббота";
//            case SUNDAY: return "Воскресенье";
//            default: return "неизвестно";
//        }
//    }
}
