package homework8.SiteLoader;

import java.util.Scanner;


public class Test {
    public static void main(String[] args) {
        switch (chooseBank()) {
            case 1:
                System.out.println("продажа, НБРБ");
                printRates(new NBRBLoader());
                break;
            case 2:
                loadRatesBAB();
                break;
            case 3:
                System.out.println("продажа, БПС");
                printRates(new BPSLoader());
                break;
            default:
                break;
        }
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
        System.out.println("продажа, БелАгропромБанк");
        if (TransformDate.isWeekend(date, "MM/dd/yyyy")) {
            System.out.println("Это выходной день. Актуальные курсы не доступны");
        } else {
            printRates(new BABLoader(), date);
        }
    }

    public static int chooseBank() {
        int bankNumber = 0;
        String buffer;
        Scanner scanner = new Scanner(System.in);
        do {
            printBanksList();
            try {
                buffer = scanner.nextLine();
                bankNumber = Integer.parseInt(buffer);
            } catch (NumberFormatException e) {
                System.out.println("Введите число от 1 до 3");
            }
        } while (bankNumber != 1 && bankNumber != 2 && bankNumber != 3);
        return bankNumber;
    }

    private static void printBanksList() {
        System.out.println("Выберите порядковое число банка для " +
                "запроса курса валют.");

        System.out.println("1. Национальный Банк - курс по дате или " +
                "диапазону дат. Для любых дней недели и года.");
        System.out.println("2. БелАгропромБанк - курс по дате или " +
                "диапазону дат. Только для рабочих дней.");
        System.out.println("3. БПС-Банк - только текущий курс, актуальный" +
                "на сегодня.");
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
