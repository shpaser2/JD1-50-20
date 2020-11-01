package homework8.SiteLoader;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransformDate {

    /**
     * Преобразует текущую дату в формат, необходимый для составления
     * запроса курса валют.
     * @return строка с датой в необходимом формате.
     */
    public static String transformCurrentDate() {
        Date currentDate = new Date();
        DateFormat dffrom = new SimpleDateFormat(
                "EEE MMM dd HH:mm:ss zzz yyyy");
        DateFormat dfto = new SimpleDateFormat("MM/dd/YYYY");
        Date today = null;
        try {
            today = dffrom.parse(currentDate.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dfto.format(today);
    }

    /**
     * Translate from "dd.MM.yyyy" to "MM/dd/yyyy" format.
     * @param date
     * @return
     */
    public static String transformDate(String date) {
        if(!isValid(date, "dd.MM.yyyy")) {
            return null;
        }
        DateFormat dffrom = new SimpleDateFormat("dd.MM.yyyy");
        DateFormat dfto = new SimpleDateFormat("MM/dd/yyyy");
        String outputDate = null;
        try {
            Date date1 = dffrom.parse(date);
            outputDate = dfto.format(date1);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return outputDate;
    }

    /**
     * Date in format to week day 1..7, where 7 = Sunday.
     * @param date String with date.
     * @param format String, "dd.MM.yyyy" for example.
     * @return true if day is in a weekend, false if not.
     */
    public static boolean isWeekend(String date, String format) {
        boolean result = false;
        DateFormat dffrom = new SimpleDateFormat(format);
        DateFormat dfto = new SimpleDateFormat("u");
        String outputDate = "6";
        try {
            Date date1 = dffrom.parse(date);
            outputDate = dfto.format(date1);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        switch (outputDate) {
            case "6":
            case "7":
                result = true;
                break;
            default:
                break;
        }
        return result;
    }

    /**
     * Check date with format and with calendar.
     * @param dateStr String with date in selected format.
     * @param dateFormat String, "dd-MM-yyyy" for example.
     * @return true if ok, false if not valid date
     */
    public static boolean isValid(String dateStr, String dateFormat) {
        DateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
