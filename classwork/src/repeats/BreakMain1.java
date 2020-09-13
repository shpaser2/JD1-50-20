package repeats;

public class BreakMain1 {
    public static void main(String[] asdqwfcbkr){
        printFirstFiveElement(10);
    }

    static void printFirstFiveElement(int count){
        for (int i = 1; i <= count; i++) {
            System.out.println(i);
            if(i == 5) {
//                break;
                break;
            }
        }
        System.out.println("Привет, я закончил");
    }
}
