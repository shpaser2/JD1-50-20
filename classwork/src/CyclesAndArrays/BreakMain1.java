package CyclesAndArrays;

public class BreakMain1 {
    public static void main(String[] args) {
        int i = 17;
        while (i <= 28){
            if(i % 13 == 0){
                break;
            }
            i++;
        }
        System.out.println(i);
    }
}
