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
        switch (currencyName) {
            case USD: //USD[\w\/\>\<\s="]+(\d,\d{3,5})
                pattern = Pattern.compile(currencyName.USD.toString().concat(commonPattern));
                break;
            case EUR:
                pattern = Pattern.compile(currencyName.EUR.toString().concat(commonPattern));
                break;
            case RUB:
                pattern = Pattern.compile(currencyName.RUB.toString().concat(commonPattern));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + currencyName);
        }
        Matcher matcher = pattern.matcher(content);
        matcher.find();
        String buf = content.substring(matcher.start(),
                matcher.end()).replaceAll("[^\\d,\\d{3,5}]","")
                .replace(',', '.');
        return Double.parseDouble(buf);
    }
}
