package CyclesAndArrays;

public class ReturnMain1 {
    public static void main(String[] args) {
        int k = 10;
        new ReturnMain1().printFirstFiveElements(k);
    }

    private void printFirstFiveElements(int count){
        for(int i = 1; i <= count; i++){
            System.out.println(i);
            if(i == 5){
                return;     // 1..5
                //break;    // 1..5 Привет, я закончил.
                //continue; // 1..4, 6..10 Привет, я закончил.
            }
        }
        System.out.println("Привет, я закончил. ");
    }
}
