package strings;

import java.util.Objects;

public class StringsMain2 {
    public static void main(String[] args) {
        String str1 = "Я изучаю JAVA и английский тоже надо";
        String str2 = "Я изучаю JAVA и английский тоже надо";
        String str3 = new String("Я изучаю JAVA и английский тоже надо");

        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
    }
}
