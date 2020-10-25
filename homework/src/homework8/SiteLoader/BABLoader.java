package homework8.SiteLoader;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
        String date = transformDate();
        //weekend not works with BelAgroBank
//        return load("https://belapb.by/ExCardsDaily.php?ondate=" + date, currencyName);
        //weekday works good
        return load("https://belapb.by/ExCardsDaily.php?ondate=10/23/2020", currencyName);
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
        switch (currencyName) {
            case USD:
                pattern = Pattern.compile(Currency.USD.toString().concat(commonPattern));
                break;
            case EUR:
                pattern = Pattern.compile(Currency.EUR.toString().concat(commonPattern));
                break;
            case RUB:
                pattern = Pattern.compile(Currency.RUB.toString().concat(commonPattern));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + currencyName);
        }
        Matcher matcher = pattern.matcher(content);
        String answer;
        if (!matcher.find()) {
            answer = "Это выходной день или он ещё не наступил. Актуальные курсы не доступны";
            System.out.println(answer);
            return -1;
        } else {
            answer = content.substring(matcher.start(), matcher.end())
                    .replaceAll("([a-zA-Z]+)?(\\<[\\w\\/\\s]+\\>)(\\d+\\<[\\w\\/\\s]+\\>)?", "");
            return Double.parseDouble(answer);
        }
    }

    /**
     * Преобразует текущую дату в формат, необходимый для составления
     * запроса курса валют.
     * @return строка с датой в необходимом формате.
     */
    private String transformDate() {
        Date currentDate = new Date();
        DateFormat dffrom = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        DateFormat dfto = new SimpleDateFormat("MM/dd/YYYY");
        Date today = null;
        try {
            today = dffrom.parse(currentDate.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dfto.format(today);
    }
}
