package homework8.SiteLoader;

import homework8.SiteLoader.service.Banks;
import homework8.SiteLoader.service.PrintRates;
import homework8.SiteLoader.service.ProcessDate;

import java.util.*;

import static homework8.SiteLoader.service.FilesHandling.*;

//dates for test 23.09.2020-29.09.2020 03.10.2020-13.10.2020

public class Test {
    private static TreeMap<Date, HashMap<String, Double>> ratesBAB = new TreeMap<>();
    private static TreeMap<Date, HashMap<String, Double>> ratesNBRB = new TreeMap<>();
    private static Banks bankNumber;
    private static String filePath;

    public static void main(String[] args) {
        Banks bank = chooseBank();
        Test.setBankNumber(bank);
        enterPathToRates();
        readAllFile();
        suggestWatchFile();
        workWithBanks();
    }

    private static void workWithBanks() {
        TreeMap<Date, HashMap<String, Double>> rates = null;
        Banks bank = Test.getBankNumber();
        boolean allowWrite = false;
        switch (bank) {
            case NBRB:
                System.out.println("\n продажа, НБРБ");
                rates = loadRatesNBRB();
                ratesNBRB.putAll(rates);
                allowWrite = checkFile(bank, Test.getFilePath());
                if (allowWrite) {
                    writeToFile(bank, ratesNBRB);
                } else {
                    System.out.println("файл содержит курсы другого банка");
                }
                break;
            case BAB:
                System.out.println("\n продажа, БелАгропромБанк");
                rates = loadRatesBAB();
                ratesBAB.putAll(rates);
                allowWrite = checkFile(bank, Test.getFilePath());
                if (allowWrite) {
                    writeToFile(bank, ratesBAB);
                } else {
                    System.out.println("файл содержит курсы другого банка");
                }
                break;
            case BPS:
                System.out.println("\n продажа, на текущий день, БПС");
                PrintRates.printRates(new BPSLoader());
                break;
            default:
                break;
        }
    }

    //1 - подготавливаем даты для запросов курсов в банк.
    //2 - выводим в консоль курс на диапазон дат.
    //3 - сохраняем курсы в коллекцию
    // Например 13.10.2020-23.10.2020 или 13.10.2020,23.10.2020.
    // Последнее число включительно.
    private static TreeMap<Date, HashMap<String, Double>> loadRatesNBRB() {
        String dfsource = "dd.MM.yyyy";
        String dfbank = "yyyy-MM-dd";
        //1
        List<String> allDates = prepareDates(dfsource, dfbank);
        //2
        NBRBLoader loader = new NBRBLoader();
        TreeMap<Date, HashMap<String, Double>> ratesDatesRange = getRatesBAB();
        Date key;
        HashMap<String, Double> value;
        for (String allDate : allDates) {
            key = ProcessDate.stringToDate(allDate, dfbank);
            value = PrintRates.loadRatesOnDate(loader, allDate);
            ratesDatesRange.put(key, value);
        }
        //3
        PrintRates.printRatesTree(ratesDatesRange);
        return ratesDatesRange;
    }

    //1 - готовит даты для запроса по диапазону
    //2 - делает запросы, наполняет TreeMap курсами
    //3 - выводит в консоль полученные курсы по диапазону дней,
    // 1 день это тоже диапазон, минимальный.
    private static TreeMap<Date, HashMap<String, Double>> loadRatesBAB() {
        String dfsource = "dd.MM.yyyy";
        String dfbank = "MM/dd/yyyy";
        //1
        List<String> allDates = prepareDates(dfsource,
                dfbank);
        //2
        BABLoader loader = new BABLoader();
        TreeMap<Date, HashMap<String, Double>> ratesDatesRange = new TreeMap<>();
        Date key;
        HashMap<String, Double> value;
        Double loadError = -1D;
        for (String allDate : allDates) {
            key = ProcessDate.stringToDate(allDate, dfbank);
            value = PrintRates.loadRatesOnDate(loader, allDate);
            if (value.get(SiteLoader.Currency.EUR.toString()) != loadError) {
                ratesDatesRange.put(key, value);
            }
        }
        //3
        PrintRates.printRatesTree(ratesDatesRange);
        return ratesDatesRange;
    }

    //1 - получаем дату старта и окончания просмотра курсов валют
    //2 - получаем лист дат в том же формате, в каком был ввод
    //3 - преобразуем в формат для банка
    private static List<String> prepareDates(String dfsource,
                                             String dfbank) {
        String[] dates = new String[2];
        //1
        ProcessDate.inputStartEndDates(dates, dfsource);
        //2
        List<String> allDates =
                ProcessDate.allDatesInRange(dates, dfsource);
        //3
        for (int i = 0; i < allDates.size(); i++) {
            allDates.set(i, ProcessDate.transformDate(allDates.get(i),
                    dfsource, dfbank));
        }
        return allDates;
    }

    public static Banks chooseBank() {
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
        Banks bank = Banks.UNKNOWN;
        for (Banks b : Banks.values()) {
            if (bankNumber == b.getNumber()) {
                bank = b;
            }
        }
        return bank;
    }

    private static void printBanksList() {
        System.out.println("1. Национальный Банк - курс по дате или " +
                "диапазону дат. \n Для любых дней недели и года.");
        System.out.println("2. БелАгропромБанк - курс по дате или " +
                "диапазону дат. \n Только для рабочих дней.");
        System.out.println("3. БПС-Банк - только текущий курс, актуальный" +
                "на сегодня.");
        System.out.println("Выберите порядковое число банка для " +
                "запроса курса валют.");
    }

    public static TreeMap<Date, HashMap<String, Double>> getRatesBAB() {
        return ratesBAB;
    }

    public static TreeMap<Date, HashMap<String, Double>> getRatesNBRB() {
        return ratesNBRB;
    }

    public static void setRatesBAB(TreeMap<Date, HashMap<String, Double>> ratesBAB) {
        Test.ratesBAB = ratesBAB;
    }

    public static void setRatesNBRB(TreeMap<Date, HashMap<String, Double>> ratesNBRB) {
        Test.ratesNBRB = ratesNBRB;
    }

    public static String getFilePath() {
        return filePath;
    }

    public static void setFilePath(String filePath) {
        Test.filePath = filePath;
    }

    public static Banks getBankNumber() {
        return bankNumber;
    }

    public static void setBankNumber(Banks bankNumber) {
        Test.bankNumber = bankNumber;
    }
}
