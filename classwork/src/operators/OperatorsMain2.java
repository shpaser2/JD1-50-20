package operators;

public class OperatorsMain2 {

    public static void main(String[] args){
        int a = 10;
        long b = 5;
//        int c = a + b;
        int c = a + (int)b; //bad example

        System.out.println(c);
        System.out.println(10 + 5);
        System.out.println(a + b);

    }
}
