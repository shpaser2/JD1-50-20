package CyclesAndArrays;

public class CyclesMain1 {
    public static void main(String[] args){
        int i = 1;

        while(i < 5){
            System.out.println("i = " + i);
            i++;
        }

        int a = 5;
        int b = 10;
        int c = a++ + a++ + ++b;    //5 + 6 + 11
        System.out.println(c);      //22

        a = 10;                     //10 -> 11 -> 12(not used) -> 21
        a = a++ + a++;              //10 + 11
        System.out.println(a);      //21
    }
}
