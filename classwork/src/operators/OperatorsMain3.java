package operators;

public class OperatorsMain3 {

    public static void main(String[] args){
        boolean c = 10 > 5;
//        boolean c = !(10 > 5);
        boolean z = 10 < 5;

//        System.out.println(c);          //it prints true
//        System.out.println(10 > 5);     //it prints true

        System.out.println(c && z);             //false
//        (!c && !z) != (!(c && z))
//        System.out.println(!c && !z);           //false
//        System.out.println(!(c && z));          //true
        System.out.println(c || z);             //true
        System.out.println(10 > 5 && 10 < 5);   //false
        System.out.println(10 > 5 || 10 < 5);   //true

//        int t = 8;
//        int r = 7;
//        System.out.println(t & r);    //it prints 0
    }

}
