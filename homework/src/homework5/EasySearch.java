package homework5;

public class EasySearch implements ISearchEngine{
    
    @Override
    public long search(String text, String word) {
        boolean caseInsensitive = false;
        long counter = 0;
        StringBuilder stringBuilder = new StringBuilder();
        String[] postStrings = {",", ".", " ", ":", ";", "\"", "!", "?", "\n"
            , ")", "\t", "\f", "*", "\'"};
        String[] preStrings = {" ", "\n", " -", "\"", "(", "\t", "\f", "*"
            , "\'", ",", "."};
        int length = preStrings.length * postStrings.length;
        length = caseInsensitive ? length * 2 : length;
        //length * 2 if with capitalize
        String[] strArr = new String[length];
        if (caseInsensitive) {
            //In lines below case insensitive array build of keys for search
            // in text
            int halfLength = strArr.length / 2;
            for (int i = 0; i < halfLength; i++) {
                strArr[i] =
                    createWordForSearch(preStrings[(i / (halfLength / preStrings.length))],
                        word, postStrings[(i % postStrings.length)],
                        stringBuilder, 1);
            }
            for (int i = halfLength; i < strArr.length; i++) {
                strArr[i] =
                    createWordForSearch(preStrings[(i / (halfLength / preStrings.length))],
                        word, postStrings[(i % postStrings.length)],
                        stringBuilder, 2);
            }
        } else {
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] =
                    createWordForSearch(preStrings[(i / (strArr.length / preStrings.length))],
                        word, postStrings[(i % postStrings.length)],
                        stringBuilder, 0);
            }
        }

        int index = 0;
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
                                       int capitalize){
        String buf;
        switch (capitalize) {
            default:
            case 0:
                buf = word;
                break;
            case 1:
                buf = word.substring(0, 1).toUpperCase() + word.substring(1);
                break;
            case 2:
                buf = word.substring(0, 1).toLowerCase() + word.substring(1);
                break;
        }
        String result =
                strBuilder.append(preStr).append(buf)
                        .append(postStr).toString();
        strBuilder.setLength(0);
        return result;
    }
}
