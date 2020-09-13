package operators;

public class OperatorsMain5 {
    public static void main(String[] args) {
        //(5 + 2++) / 8
        int b = 2;
        System.out.println((5 + b++) / 8);
        //(5 + 2++) / --8
        b = 2;
        int c = 8;
        System.out.println((5 + b++) / --c);

        int z = 42;
        int g = 15;

        int f = z << g;

        z<<=g;

        z = 42;

        //(5 + 7 > 20 ? 68 >= 68 : 22 * 2 >> 2++) / --8
        /*

         */
        int h;
        if(b + c == 45){
            h = 10;
        } else {
            h = 89;
        }

        int h1 = b + c == 45 ? 10 : 89;
    }
}
