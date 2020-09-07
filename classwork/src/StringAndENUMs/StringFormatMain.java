package StringAndENUMs;

import org.w3c.dom.ls.LSOutput;

public class StringFormatMain {
    
    public static void main(String[] args) {
        String str = String.format("Привет %s, я тебя так долго ждал", "Илья");
        System.out.println(str);
        System.out.println(String.format("Привет %s, я тебя так долго ждал. " +
                "Мне %d лет.", "Илья", 27));
        String name = "Name";
        String lastName = "Lasd";
        String midname = "";

        if (midname != null) {
            System.out.println(String.format("%s %s %s", name, lastName,
                    midname));
        } else {
            System.out.println(String.format("%s %s", name, lastName));
        }
    }
}
