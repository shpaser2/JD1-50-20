package StringAndENUMs;

public enum Day {
    MONDAY("Понедельник", true),
    TUESDAY("Вторник", true),
    WEDNESDAY("Среда", true),
    THURSDAY("Четверг", true),
    FRIDAY("Пятница", true),
    SATURDAY("Суббота", false),
    SUNDAY("Воскресенье", false),
    unknown("неизвестный день", false); //да так можно, но не по конвенции
    // это (то что маленькими буквами название)
    
    private String rusName;
    private boolean isWorkName;
    
    Day(String rus, boolean isWork) {
        this.rusName = rus;
        this.isWorkName = isWork;
    }
    
    public String getRusName() {
        return this.rusName;
    }
    
    public boolean isWorkDay() {
        return this.isWorkName;
    }
    
    public static Day valueOfIgnoreCase(String dayName) {
        String dayUppers = dayName.toUpperCase();
        for (Day value : values()) {
            if (value.name().toUpperCase().equals(dayUppers)) {
                return value;
            }
        }
        return unknown;
    }
}
