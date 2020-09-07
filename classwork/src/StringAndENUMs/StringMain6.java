package StringAndENUMs;

import static java.lang.String.join;

public class StringMain6 {
    
    public static void main(String[] args) {
        //по UTF-16BE result = "b" - "a"
        System.out.println("a".compareTo("b"));
        System.out.println("а".compareTo("б"));
        System.out.println("a".compareTo("б"));
    }
}
