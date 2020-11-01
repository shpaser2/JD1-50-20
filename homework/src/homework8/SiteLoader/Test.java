package homework8.SiteLoader;

import java.util.Scanner;


public class Test {
    public static void main(String[] args) {
//        System.out.println("продажа, НБРБ");
//        printRates(new NBRBLoader());
//        System.out.println("продажа, БПС");
//        printRates(new BPSLoader());
        loadRatesBAB();
    }

    private static void printRates(SiteLoader loader){
        System.out.println(SiteLoader.Currency.EUR.toString() + " "
                + loader.load(SiteLoader.Currency.EUR));
        System.out.println(SiteLoader.Currency.RUB.toString() + " "
                + loader.load(SiteLoader.Currency.RUB));
        System.out.println(SiteLoader.Currency.USD.toString() + " "
                + loader.load(SiteLoader.Currency.USD));
    }

    private static void printRates(BABLoader loader, String date){
        System.out.println(SiteLoader.Currency.EUR.toString() + " "
                + loader.load(SiteLoader.Currency.EUR, date));
        System.out.println(SiteLoader.Currency.RUB.toString() + " "
                + loader.load(SiteLoader.Currency.RUB, date));
        System.out.println(SiteLoader.Currency.USD.toString() + " "
                + loader.load(SiteLoader.Currency.USD, date));
    }

    private static void loadRatesBAB() {
        String date;
        String stringWithDate;
        Scanner console = new Scanner(System.in);
        do {
            System.out.println("Введите дату для отображения курса");
            stringWithDate = console.nextLine();
            date = TransformDate.transformDate(stringWithDate);
        } while(date == null);
        System.out.println("продажа, БелАгроБанк");
        if (TransformDate.isWeekend(date, "MM/dd/yyyy")) {
            System.out.println("Это выходной день. Актуальные курсы не доступны");
        } else {
            printRates(new BABLoader(), date);
        }
    }


//    private static void loadRatesInRange() {
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date startDate = formatter.parse("2010-12-20");
//        Date endDate = formatter.parse("2010-12-26");
//
//        Calendar start = Calendar.getInstance();
//        start.setTime(startDate);
//        Calendar end = Calendar.getInstance();
//        end.setTime(endDate);
//
//        for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
//            // Do your job here with `date`.
//            System.out.println(date);
//        }
//    }
}
