package CyclesAndArrays;

public class CyclesMain2 {
    public static void main(String[] args){
        int n = 5;
        do {
            System.out.println("Sample : " + n);
            n--;
        }while(n > 0);


        int  sum = 0;
        int i = 0;
        while(i < 20){
            if(i % 2 == 0){
                sum += i;
            }
            i++;
        }
        System.out.println("sum = " + sum);
    }
}
