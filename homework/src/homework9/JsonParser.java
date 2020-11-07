package homework9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static homework5.warEndPeace.WarAndPeace.readAllBytesJava7;
import static homework8.SiteLoader.service.FilesHandling.getPathToSrcDir;
import static homework8.SiteLoader.service.FilesHandling.pathWithFileInside;

public class JsonParser {
    public static void main(String[] args) {
        JsonParser jp = new JsonParser();
        String strPath = getPathToSrcDir(jp);
        String namesPath = pathWithFileInside(strPath,
                "russian_names.json").toString();
        String surnamesPath = pathWithFileInside(strPath,
                "russian_surnames.json").toString();

        String namesJson = readAllBytesJava7(namesPath);
        String surnamesJson = readAllBytesJava7(surnamesPath);

        String regexNamePrefix = "\"Name\":\"";
        String regexSurnamePrefix = "\"Surname\":\"";
        String regexWord = "[А-Яа-яЁё]*";

        ArrayList<String> names = parseStringsInJsonWithKey(
                regexNamePrefix, regexWord, namesJson);
        ArrayList<String> surnames = parseStringsInJsonWithKey(
                regexSurnamePrefix, regexWord, surnamesJson);

        System.out.println(names);
        System.out.println(surnames);
    }

    /**
     * Извлекает список с одним параметром из множества параметров
     * в JSON.
     * @param regexPrefix Example - "\"Surname\":\"".
     * @param regexWord Example for russian - "[А-Яа-яЁё]*".
     * @param jsonStr One json String with different params.
     * @return ArrayList c искомыми параметрами одного типа.
     */
    public static ArrayList<String> parseStringsInJsonWithKey(
            String regexPrefix,
            String regexWord,
            String jsonStr) {
        Pattern pattern = Pattern.compile(regexPrefix + regexWord);
        Matcher matcher = pattern.matcher(jsonStr);
        LinkedList<String> buffer = new LinkedList<>();
        while (matcher.find()) {
            buffer.add(matcher.group());
        }
        ArrayList<String> data = new ArrayList<>(buffer);
        int prefix = regexPrefix.length();
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i).substring(prefix));
        }
        return data;
    }
}
