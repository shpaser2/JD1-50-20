package strings;

import java.util.Arrays;

public class StringsMain5 {
    public static void main(String[] args) {
        String name = "Илья";
        String result = name.concat(", научи меня писать код");

        System.out.println(name);
        System.out.println(result);
        System.out.println("Илья".concat(", научи меня писать код"));

//        String number = 1;
        String number = String.valueOf(1);

        System.out.println(1);
        System.out.println(number);
        System.out.println(String.valueOf(true));

        String joinStr = String.join(" Привет:", new String[] {"Илья", "Сергей", "Коля"} );

        System.out.println(joinStr);
        System.out.println(joinArrayToString(", ", new String[] {"Илья", "Сергей", "Коля"}));
        System.out.println(joinArrayToString(", ", new String[] {"Илья",null}));
        System.out.println(joinArrayToString(", ", new String[] {null, "Илья"}));
        String joinResult = joinArrayToString(", ", null);
        System.out.println(joinResult);
        System.out.println(joinArrayToString(", ", null));
    }

    /**
     * Метод создаёт новую строку в которую помещает элементы массива разделяя
     * их между собой при помощи разделителя
     * @param delimiter разделитель. Пример: ", "
     * @param arr массив элементов. Пример: {"Илья", "Сергей", "Коля"}
     * @return итоговая строка с элементами "Илья, Сергей, Коля"
     */
    public static String joinArrayToString(String delimiter, String[] arr){
        if(arr == null || arr.length == 0){
            return "";
        }
        if(delimiter == null){
            throw new IllegalArgumentException("Делиметр не может быть null");
        }

        String result = arr[0] == null ? "" : arr[0];

        for(int i = 1; i < arr.length; i++){
            if(arr[i] != null){
                if(result.length() > 0){
                    result += delimiter;
                }
                result += arr[i];
            }
        }

        return result;
    }
}
