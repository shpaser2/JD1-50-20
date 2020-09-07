package StringAndENUMs;

import static java.lang.String.join;

public class StringMain5 {
    
    public static void main(String[] args) {
//        ... some code before
        String joinStr = join(" Привет: ",
                new String[] {"Илья",
                        "Сергей",
                        "Коля"});
        System.out.println(joinStr);
        System.out.println(join(", ",
                new String[] {"Илья",
                "Сергей",
                "Коля"}));
        System.out.println(joinArrayToString(", ",
                new String[] {"Илья",
                        "Сергей",
                        "Коля"}));
        System.out.println(joinArrayToString(", ",
                new String[] {"Илья", null}));
        System.out.println(joinArrayToString(", ",
                new String[] {null, "Илья"}));
        System.out.println(joinArrayToString(", ", null));
        System.out.println(joinArrayToString(", ", null));
        System.out.println(joinArrayToString(null, null));
    }
    
    /**
     * Метод создаёт новую строку в которую помещает элементы массива
     * разделяя их между собой при помощи разделителя.
     *
     * @param delimiter разделитель. Пример: ", "
     * @param arr массив элементов. Пример: {"Илья", "Сергей", "Коля"}
     * @return итоговая строка с элементами "Илья, Сергей, Коля"
     */
    public static String joinArrayToString(String delimiter, String[] arr) {
        if (delimiter == null) {
            throw new IllegalArgumentException("Делиметр не может быть null");
        }
        if (arr == null || arr.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder(arr[0] == null ? "" : arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != null) {
                if (result.length() > 0) {
                    result.append(delimiter);
                }
                result.append(arr[i]);
            }
        }
        return result.toString();
    }
    
    //конкатенация лучше чем StringBuilder, когда есть ограниченное,
    // небольшое (5-6 конкатенаций) или идёт с литералов.
}
