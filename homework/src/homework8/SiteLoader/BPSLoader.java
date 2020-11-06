package homework8.SiteLoader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Загрузчик курса с основного сайта БПС-Банка
 */
public class BPSLoader extends SiteLoader{

    /**
     * Метод для запуска загрузки курса валют
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    public double load(Currency currencyName) {
        return load("https://www.bps-sberbank.by/page/currency-exchange-cards", currencyName);
    }

    /**
     * Обработка результата загрузки с сайта банка
     * @param content то что получилось загрузить
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    protected double handle(String content, Currency currencyName) {
        String commonPattern = "[\\w\\/\\>\\<\\s=\\\"]+(\\d,\\d{3,5})";
        Pattern pattern;
        pattern = Pattern.compile(currencyName.name().concat(commonPattern));
        Matcher matcher = pattern.matcher(content);
        matcher.find();
        String buf = content.substring(matcher.start(),
                matcher.end()).replaceAll("[^\\d,\\d{3,5}]","")
                .replace(',', '.');
        return Double.parseDouble(buf);
    }
}
