package homework8.SiteLoader.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ProcessDate {

    /**
     * Преобразует текущую дату в формат, необходимый для составления
     * запроса курса валют.
     * @return строка с датой в необходимом формате.
     */
    public static String transformCurrentDate() {
        Date currentDate = new Date();
        DateFormat dffrom = new SimpleDateFormat(
                "EEE MMM dd HH:mm:ss zzz yyyy");
        DateFormat dfto = new SimpleDateFormat("MM/dd/yyyy");
        Date today = null;
        try {
            today = dffrom.parse(currentDate.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dfto.format(today);
    }

    /**
     * Translate string with date from one format to another format.
     * @param date String with date in dffrom format.
     * @param dffromStr Fate format from. For example "dd.MM.yyyy"
     * @param dftoStr Date format to. For example "MM/dd/yyyy"
     * @return String with date in dftoStr format.
     */
    public static String transformDate(String date, String dffromStr,
                                       String dftoStr) {
        if(!isValid(date, dffromStr)) {
            return null;
        }
        DateFormat dffrom = new SimpleDateFormat(dffromStr);
        DateFormat dfto = new SimpleDateFormat(dftoStr);
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

    /**
     *
     * @param df Date format. "dd-MM-yyyy" for example.
     * @param startEndDates array with start date at 0
     *                      and end date at 1.
     */
    public static void inputStartEndDates(String[] startEndDates, String df) {
        String stringWithDate;
        String oneDate;
        String anotherDate;
        Scanner console = new Scanner(System.in);
        do {
            System.out.println("Введите дату для отображения курса");
            stringWithDate = console.nextLine().replaceAll("\\s","");

            int comma = stringWithDate.indexOf(',');
            int hyphen = stringWithDate.indexOf('-');
            if (comma == 10 && stringWithDate.length() == 21) {
                oneDate = stringWithDate.substring(0, comma);
                anotherDate = stringWithDate.substring(comma + 1);
            } else if (hyphen  == 10 && stringWithDate.length() == 21) {
                oneDate = stringWithDate.substring(0, hyphen);
                anotherDate = stringWithDate.substring(hyphen + 1);
            } else {
                oneDate = stringWithDate;
                anotherDate = oneDate;
            }
            startEndDates[0] = oneDate;
            startEndDates[1] = anotherDate;
        } while (!ProcessDate.isValid(oneDate, df)
                    || !ProcessDate.isValid(anotherDate, df));
    }

    //1 - парсинг даты со строки.
    //2 - определение ранней и поздней даты.
    //3 - создание списка с датами от ранней к поздней.
    public static List<String> allDatesInRange(String[] datesArr, String df) {
        SimpleDateFormat formatter = new SimpleDateFormat(df);
        List<String> dates = new ArrayList<>();
        Date startDate = new Date();
        Date endDate = startDate;
        Date date1 = startDate;
        Date date2 = startDate;
        //1
        try {
            date1 = formatter.parse(datesArr[0]);
            date2 = formatter.parse(datesArr[1]);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
            dates.add(formatter.format(new Date()));
            return dates;
        }
        //2
        if (date1.compareTo(date2) > 0) {
            startDate = date2;
            endDate = date1;
        } else {
            startDate = date1;
            endDate = date2;
        }
        //3
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);
        end.add(Calendar.DATE, 1);  //add 1 day to the end date
        for (Date date = start.getTime();
                 start.before(end);
                 start.add(Calendar.DATE, 1), date = start.getTime()) {
            dates.add(formatter.format(date));
        }
        return dates;
    }

    public static void printDate(String date, String dfsource, String dfprint) {
        if (dfsource.equals(dfprint)) {
            System.out.println(date);
        } else {
            System.out.println(transformDate(date, dfsource, dfprint));
        }
    }

    public static Date stringToDate(String dateStr, String dfsource) {
        DateFormat dffrom = new SimpleDateFormat(dfsource);
        Date date = null;
        try {
            date = dffrom.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
