package strings;

public class EnumsMain2 {

    public static void main(String[] args) {
        Day day555 = Day.FRIDAY;
        System.out.println(getRusName(day555));
        System.out.println(getRusName(Day.THURSDAY));
    }

    public static String getRusName(Day day){
        switch (day){
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
}
