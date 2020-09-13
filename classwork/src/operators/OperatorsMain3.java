package operators;

public class OperatorsMain3 {
    public static void main(String[] asssss){
        boolean c = !(10 > 5);
        boolean z = 10 < 5;
        boolean f = !true;

        System.out.println(!(c && z));
        System.out.println(!c && !z);
        System.out.println(c || z);
        System.out.println(10 > 5 && 10 < 5);
        System.out.println(10 > 5 || 10 < 5);
    }
}
