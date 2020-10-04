package homework5;

public class EasySearch implements ISearchEngine{
    
    @Override
    public long search(String text, String word) {
        int index = 0;
        long counter = 0;
        StringBuilder stringBuilder = new StringBuilder();
        String[] strArr = new String[3];
        strArr[0] =
                stringBuilder.append(" ").append(word).append(",").toString();
        stringBuilder.setLength(0);
        strArr[1] =
                stringBuilder.append(" ").append(word).append(".").toString();
        stringBuilder.setLength(0);
        strArr[2] =
                stringBuilder.append(" ").append(word).append(" ").toString();
        stringBuilder.setLength(0);
        
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
}
