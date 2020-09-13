package strings;

public class StringsMain4 {
    public static void main(String[] args) {
        System.out.println(String.format("Привет %s, я тебя так долго ждал", "Илья"));
        System.out.println(String.format("Привет %s, я тебя так долго ждал. Мне %x лет", "Илья", 27));
        String name = "Илья";
        String lastName = "LAsd";
        String midName = null;
        if(midName != null) {
            System.out.println(String.format("%s %s %s", lastName, name, midName));
        } else {
            System.out.println(String.format("%s %s", lastName, name));
        }
    }
}
