package homework5;

public class EasySearch implements ISearchEngine{
    
    @Override
    public long search(String text, String word) {
        int index = 0;
        long counter = 0;
        StringBuilder stringBuilder = new StringBuilder();
        String[] strArr = new String[6];    //length was 12 with capitilize
        String[] postStrings = {",", ".", " "};
        String[] preStrings = {" ", ""};
        boolean capitalize;
        for (int i = 0; i < strArr.length; i++) {
        //    capitalize = (i % 6) < 3;
            strArr[i] = createWordForSearch(preStrings[i / 6], word,
                        postStrings[i % 3], stringBuilder, false);
        }
       
        for (int i = 0; i < strArr.length; i++) {
            index = 0;
            do {
                index++;
                index = text.indexOf(strArr[i], index);
                if (index != -1) {
                    counter++;
                }
            } while (index != -1);
        }
        return counter;
    }
    
    
    private String createWordForSearch(String preStr, String word,
                                       String postStr,
                                       StringBuilder strBuilder,
                                       Boolean capitalize){
        String buf;
        if (capitalize) {
            buf = word.substring(0, 1).toUpperCase() + word.substring(1);
        } else {
            buf = word;
        }
        String result =
                strBuilder.append(preStr).append(buf)
                        .append(postStr).toString();
        strBuilder.setLength(0);
        return result;
    }
}
