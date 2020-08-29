package CyclesAndArrays;

public class CyclesMain3 {
    public static void main(String[] args){
        int i = 0;
        while(i < 5){
            System.out.println("i = " + i);
            i++;
        }

        for(int j = 0; j < 5; j++){
            System.out.println("j = " + j);
        }

        for(;;){
            System.out.println("Infinite loop");
            break;
        }

        String[] values = new String[10];
        for(String element:values){
            System.out.println(element);
        }
    }
}
