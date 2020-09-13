package operators;

public class OperatorsMain2 {

    public static void main(String[] ar){
        int a = 10;
        long b = 5;
        int c = a + (int) b; //плохо
        double z = .5;

        System.out.println(z);
        System.out.println((int) z);

        System.out.println(c);
        System.out.println(10 + 5);
        System.out.println(a + b);
    }
}
