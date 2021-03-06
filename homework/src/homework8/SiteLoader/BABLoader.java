package homework8.SiteLoader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BABLoader extends SiteLoader{

    /**
     * Метод для запуска загрузки курса валют
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    public double load(Currency currencyName) {
        //weekends not works with BelAgroBank
        //weekday works good
        return load("https://belapb.by/ExCardsDaily.php?ondate=10/23/2020",
                currencyName);
    }

    //weekend not works with BelAgroBank
    public double load(Currency currencyName, String date) {
        return load("https://belapb.by/ExCardsDaily.php?ondate="
                + date, currencyName);
    }

    /**
     * Обработка результата загрузки с сайта банка
     * @param content то что получилось загрузить
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    protected double handle(String content, Currency currencyName) {
        String commonPattern = ".+(\\n\\s+[\\w\\d\\.<>\\/]+){3}";
        Pattern pattern;
        pattern = Pattern.compile(currencyName.name().concat(commonPattern));
        Matcher matcher = pattern.matcher(content);
        String answer;
        if (!matcher.find()) {
            return -1;
        } else {
            answer = content.substring(matcher.start(), matcher.end())
                    .replaceAll(
                    "([a-zA-Z]+)?(\\<[\\w\\/\\s]+\\>)(\\d+\\<[\\w\\/\\s]+\\>)?",
                    "");
            return Double.parseDouble(answer);
        }
    }
}
