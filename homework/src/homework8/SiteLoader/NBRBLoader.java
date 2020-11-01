package homework8.SiteLoader;

/**
 * Загрузчик курса с сайта Нац. Банка
 */
public class NBRBLoader extends SiteLoader{

    /**
     * Метод для запуска загрузки курса валют
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    public double load(SiteLoader.Currency currencyName) {
        return load("https://www.nbrb.by/api/exrates/rates/"
                + currencyName.getId() + "?ondate=2020-10-27", currencyName);
    }

    public double load(SiteLoader.Currency currencyName, String date) {
        return load("https://www.nbrb.by/api/exrates/rates/"
                + currencyName.getId() + "?ondate=" + date, currencyName);
    }

    /**
     * Обработка результата загрузки с сайта банка
     * @param content то что получилось загрузить
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    protected double handle(String content, SiteLoader.Currency currencyName) {
        int currencyIndex = content.indexOf("Cur_OfficialRate\":")
                + "Cur_OfficialRate\":".length();
        String buf = content.substring(currencyIndex);
        buf = buf.replace('}',' ');
        buf = buf.replace('{',' ');
        buf = buf.replace('\"',' ');
        return Double.parseDouble(buf);
    }
}
