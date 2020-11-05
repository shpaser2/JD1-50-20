package homework8.SiteLoader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

//dates for test 23.09.2020-29.09.2020 03.10.2020-13.10.2020

public class Test {
    private static TreeMap<Date, HashMap<String, Double>> ratesBAB = new TreeMap<>();
    private static TreeMap<Date, HashMap<String, Double>> ratesNBRB = new TreeMap<>();
    private static String filePath;

    public static void main(String[] args) {
        askFilePath();
        workWithBanks();
        readAllFile();
        workWithBanks();
        readAllFile();
    }

    private static void workWithBanks() {
        TreeMap<Date, HashMap<String, Double>> rates = null;
        int bank = chooseBank();
        boolean allowWrite = false;
        switch (bank) {
            case 1:
                System.out.println("продажа, НБРБ");
                rates = loadRatesNBRB();
                ratesNBRB.putAll(rates);
                allowWrite = checkFile(bank);
                if (allowWrite) {
                    writeToFile(bank, ratesNBRB);
                } else {
                    System.out.println("файл содержит курсы другого банка");
                }
                break;
            case 2:
                System.out.println("продажа, БелАгропромБанк");
                rates = loadRatesBAB();
                ratesBAB.putAll(rates);
                allowWrite = checkFile(bank);
                if (allowWrite) {
                    writeToFile(bank, ratesBAB);
                } else {
                    System.out.println("файл содержит курсы другого банка");
                }
                break;
            case 3:
                System.out.println("продажа, на текущий день, БПС");
                printRates(new BPSLoader());
                break;
            default:
                break;
        }
    }

    private static boolean checkFile(int bank) {
        Integer bankName = 0;
        boolean fileExists = false;
        Path p = Paths.get(getFilePath());
        System.out.println(p.toAbsolutePath());
        do {
            //check if exists
            fileExists = Files.exists(Paths.get(getFilePath()));
            //create if not exist
            if (!fileExists) {
                try {
                    Path testFile1 = Files.createFile(Paths.get(getFilePath()));
                } catch (IOException e) {
                    e.printStackTrace();
                    setFilePath("rates.txt");
                }
            }
        } while(!fileExists);
        //write
        try (FileInputStream fis = new FileInputStream(getFilePath());
                ObjectInputStream ois = new ObjectInputStream(fis)){
            bankName = ois.readInt();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bankName == bank ? true : false;
    }

    private static void printRates(SiteLoader loader){
        System.out.println(SiteLoader.Currency.EUR.toString() + " "
                + loader.load(SiteLoader.Currency.EUR));
        System.out.println(SiteLoader.Currency.RUB.toString() + " "
                + loader.load(SiteLoader.Currency.RUB));
        System.out.println(SiteLoader.Currency.USD.toString() + " "
                + loader.load(SiteLoader.Currency.USD));
    }

    private static void printRates(BABLoader loader, String date,
                                   String bankDateFormat){
        if (ProcessDate.isWeekend(date, bankDateFormat)) {
            System.out.println("Это выходной день. Актуальные курсы не доступны");
        } else {
            System.out.println(SiteLoader.Currency.EUR.toString() + " "
                    + loader.load(SiteLoader.Currency.EUR, date));
            System.out.println(SiteLoader.Currency.RUB.toString() + " "
                    + loader.load(SiteLoader.Currency.RUB, date));
            System.out.println(SiteLoader.Currency.USD.toString() + " "
                    + loader.load(SiteLoader.Currency.USD, date));
        }
    }

    private HashMap<String, Double> loadRatesOnDate(BABLoader loader,
                                                    String date) {
        HashMap<String, Double> rates = new HashMap<>();
        rates.put(SiteLoader.Currency.EUR.toString(),
                loader.load(SiteLoader.Currency.EUR, date));
        rates.put(SiteLoader.Currency.RUB.toString(),
                loader.load(SiteLoader.Currency.RUB, date));
        rates.put(SiteLoader.Currency.USD.toString(),
                loader.load(SiteLoader.Currency.USD, date));
        return rates;
    }

    private HashMap<String, Double> loadRatesOnDate(NBRBLoader loader,
                                                    String date) {
        HashMap<String, Double> rates = new HashMap<>();
        rates.put(SiteLoader.Currency.EUR.toString(),
                loader.load(SiteLoader.Currency.EUR, date));
        rates.put(SiteLoader.Currency.RUB.toString(),
                loader.load(SiteLoader.Currency.RUB, date));
        rates.put(SiteLoader.Currency.USD.toString(),
                loader.load(SiteLoader.Currency.USD, date));
        return rates;
    }

    private static void printRates(NBRBLoader loader, String date){
            System.out.println(SiteLoader.Currency.EUR.toString() + " "
                    + loader.load(SiteLoader.Currency.EUR, date));
            System.out.println(SiteLoader.Currency.RUB.toString() + " "
                    + loader.load(SiteLoader.Currency.RUB, date));
            System.out.println(SiteLoader.Currency.USD.toString() + " "
                    + loader.load(SiteLoader.Currency.USD, date));
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
        for (String allDate : allDates) {
            ProcessDate.printDate(allDate, dfbank, dfsource);
            printRates(loader, allDate);
        }
        //3
        Test t = new Test();
        TreeMap<Date, HashMap<String, Double>> ratesDatesRange = t.getRatesBAB();
        Date key;
        for (String allDate : allDates) {
            key = ProcessDate.stringToDate(allDate, dfbank);
            ratesDatesRange.put(key, t.loadRatesOnDate(loader, allDate));
        }
        return ratesDatesRange;
    }

    private static void printRatesTree(TreeMap<Date, HashMap<String, Double>> rates) {
        Set<Date> keys = rates.keySet();
        for (Date date : keys) {
            System.out.println(date);
            System.out.println(rates.get(date));
        }
    }

    private static void askFilePath() {
//        Test test = new Test();
//        test.getClass().getResource("Test.java");
        System.out.println("Введите путь к файлу с курсами валют: ");
        Scanner scanner = new Scanner(System.in);
        String maybePath = scanner.nextLine();
        File f = new File(maybePath);
        //C:\IntellijWorkspace\JD1-50-20\homework\src\homework8\SiteLoader\rates.txt
        String[] files = f.list((dir, name) -> {
            return name.equals("rates.txt");
        });
    }

    //пробный путь - C:\IntellijWorkspace\JD1-50-20\homework\src\homework8\SiteLoader\rates.txt
    //1 - проверка пути,
    //ломается при ch < '\u0020' || "<>:\"|?*".indexOf(ch) != -1
    private static Path achievePathToRates() {
        System.out.println("Введите путь к файлу с курсами валют: ");
        Scanner scanner = new Scanner(System.in);
        String maybePath = scanner.nextLine().strip();
        Path usedPath;
        try {
            Paths.get(maybePath);                               //1
            usedPath = handlePathForRates(maybePath);
        } catch (InvalidPathException e) {
            System.out.println("Введенный путь содержит запрещенные символы: " +
                    "<>:\\\"|?* или любой символ из ASCII до 20го");
            System.out.println("Будет использован путь к папке с " +
                    "исходным кодом данной программы.");
            String pathToSrc = createFileInSrcPath();
            usedPath = handlePathForRates(pathToSrc);
        }
        return usedPath;
    }

    //1 - корневой абсолютный, root/
    //2 - путь внутри к директории с исходниками,
    //      JD1-50-20/homework/src/
    //3 - путь к пакету с исзодниками классов, package
    //создание пути к файлу рядом с исходником независимо от ОС и пк
    private static String createFileInSrcPath() {
        //1
        String root = Paths.get(TestCl1.class.getTypeName())
                .toAbsolutePath().toString()
                .replaceAll(TestCl1.class.getName(),"");
        //2
        String src = "JD1-50-20" + File.separator + "homework"
                + File.separator + "src" + File.separator;
        //3
        String pckg = TestCl1.class.getPackageName()
                .replace('/', '\\');
        String all = root + src + pckg;
        String separatorRegex = "\\" + File.separator;
        all = all.replaceAll("/|\\.|\\\\", separatorRegex);
        return all;
    }

    /**
     * Проверяется путь на файл rates.txt или на папку,
     * где есть файл rates.txt. Если по указанному пути нет rates.txt
     * или нет папок с таким путем, тогда создаются все директории
     * указанного пути и в папке по указанному пути создается rates.txt.
     * @param path путь пользователя, где хранится файл с курсами
     *             или путь прямо к файлу с курсами
     * @return  существующей путь с существующим файлом rates.txt
     */
    private static Path handlePathForRates(String path) {
        String fileName = "rates.txt";
        try {
            Path dest = Paths.get(path);
            if (Files.isDirectory(dest)) {
                if (!Files.exists(dest)) {
                    Files.createDirectories(dest);
                }
                path = path + File.separator + fileName;
                dest = Paths.get(path);
                if (!Files.exists(dest)) {
                    Files.createFile(dest);
                }
            } else {
                if (!Files.exists(dest)) {
                    Files.createFile(dest);
                }
            }
            return dest;
        } catch (IOException e) {
            System.out.println("Не удалось создать файл " +
                    "rates.txt в дикертории: " + path);
            return Paths.get("rates.txt");
        }
    }

    private static void writeToFile(Integer bankNumber,
                                    TreeMap<Date, HashMap<String, Double>> rates) {
        try (FileOutputStream fos = new FileOutputStream(getFilePath());
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeInt(bankNumber);
            oos.writeObject(rates);
        } catch (FileNotFoundException e){
            System.out.println("Что-то не так с файлом, " + e.getMessage());
        } catch (IOException e){
            System.out.println("Что-то совсем не так, " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private static void readAllFile() {
        try (FileInputStream fis = new FileInputStream(getFilePath());
                ObjectInputStream ois = new ObjectInputStream(fis)){

            Integer bankName = ois.readInt();
            System.out.println(bankName);

            TreeMap<Date, HashMap<String, Double>> rates  =
                    (TreeMap<Date, HashMap<String, Double>>) ois.readObject();

            if (bankName == 1) {
                ratesNBRB.putAll(rates);
            } else if (bankName == 2) {
                ratesBAB.putAll(rates);
            }
            printRatesTree(rates);  //TODO delete this line
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static TreeMap<Date, HashMap<String, Double>> loadRatesBAB() {
        String dfsource = "dd.MM.yyyy";
        String dfbank = "MM/dd/yyyy";
        //1
        List<String> allDates = prepareDates(dfsource,
                dfbank);
        //2
        BABLoader loader = new BABLoader();
        for (String allDate : allDates) {
            ProcessDate.printDate(allDate, dfbank, dfsource);
            printRates(loader, allDate, dfbank);
        }
        //3
        Test t = new Test();
        TreeMap<Date, HashMap<String, Double>> ratesDatesRange = t.getRatesBAB();
        Date key;
        for (String allDate : allDates) {
            key = ProcessDate.stringToDate(allDate, dfbank);
            ratesDatesRange.put(key, t.loadRatesOnDate(loader, allDate));
        }
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
        System.out.println("1. Национальный Банк - курс по дате или " +
                "диапазону дат. \n Для любых дней недели и года.");
        System.out.println("2. БелАгропромБанк - курс по дате или " +
                "диапазону дат. \n Только для рабочих дней.");
        System.out.println("3. БПС-Банк - только текущий курс, актуальный" +
                "на сегодня.");
        System.out.println("Выберите порядковое число банка для " +
                "запроса курса валют.");
    }

    public TreeMap<Date, HashMap<String, Double>> getRatesBAB() {
        return ratesBAB;
    }

    public TreeMap<Date, HashMap<String, Double>> getRatesNBRB() {
        return ratesNBRB;
    }

    public void setRatesBAB(TreeMap<Date, HashMap<String, Double>> ratesBAB) {
        this.ratesBAB = ratesBAB;
    }

    public void setRatesNBRB(TreeMap<Date, HashMap<String, Double>> ratesNBRB) {
        this.ratesNBRB = ratesNBRB;
    }

    public static String getFilePath() {
        return filePath;
    }

    public static void setFilePath(String filePath) {
        Test.filePath = filePath;
    }
}
