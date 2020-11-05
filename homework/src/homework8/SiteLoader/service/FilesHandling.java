package homework8.SiteLoader.service;

import homework8.SiteLoader.Test;
import homework8.SiteLoader.closedSandbox.TestCl1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

import static homework8.SiteLoader.Test.*;

public class FilesHandling {

    public static void suggestWatchFile() {
        System.out.println("Желаете просмотреть сохраненные ранее курсы?");
        System.out.println("1 - да, любой другой символ - нет");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        int result = answer.indexOf('1');
        if (result > -1) {
            Banks bank = getBankNumber();
            switch (bank) {
                case NBRB:
                    PrintRates.printRatesTree(getRatesNBRB());
                    break;
                case BAB:
                    PrintRates.printRatesTree(getRatesBAB());
                    break;
                case BPS:
                default:
                    System.out.println("у выбранного банка нет такой опции");
                    break;
            }
        }
    }

    public static boolean checkFile(Banks bank, String path) {
        Banks bankBuf = Banks.UNKNOWN;
        File f = new File(path);
        if (f.length() == 0) {
            bankBuf = getBankNumber();
        } else {
            try (FileInputStream fis = new FileInputStream(path);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {
                int bankInFile = ois.readInt();
                for (Banks b : Banks.values()) {
                    if (bankInFile == b.getNumber()) {
                        bankBuf = b;
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bankBuf.equals(bank) ? true : false;
    }

    //пробный путь - C:\IntellijWorkspace\JD1-50-20\homework\src\homework8\SiteLoader\rates.txt
    //1 - проверка пути,
    //ломается при ch < '\u0020' || "<>:\"|?*".indexOf(ch) != -1
    public static void enterPathToRates() {
        boolean allowWrite = false;
        Path usedPath = Paths.get("");
        Banks bank = getBankNumber();
        int attempts = 0;
        final int ATTEMPTS_LIMIT = 5;
        do {
            System.out.println("Введите путь к файлу с курсами " +
                    "валют выбранного ранее банка: ");

            Scanner scanner = new Scanner(System.in);
            String maybePath = scanner.nextLine().strip();
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

            allowWrite = checkFile(bank, usedPath.toString());
            if (!allowWrite) {
                attempts++;
                System.out.println("файл содержит курсы другого банка");
            }
        } while (!allowWrite && attempts < ATTEMPTS_LIMIT);
        if (attempts >= ATTEMPTS_LIMIT && !allowWrite) {
            throw new IllegalArgumentException("Код ошибки: -42");
        }
        setFilePath(usedPath.toString());
    }

    //1 - корневой абсолютный, root/
    //2 - путь внутри к директории с исходниками,
    //      JD1-50-20/homework/src/
    //3 - путь к пакету с исзодниками классов, package
    //создание пути к файлу рядом с исходником независимо от ОС и пк
    private static String createFileInSrcPath() {
        //1
        String root = Paths.get(Test.class.getTypeName())
                .toAbsolutePath().toString()
                .replaceAll(TestCl1.class.getName(),"");
        //2
        String src = "JD1-50-20" + File.separator + "homework"
                + File.separator + "src" + File.separator;
        //3
        String pckg = Test.class.getPackageName()
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

    public static void writeToFile(Banks bank,
                                    TreeMap<Date, HashMap<String, Double>> rates) {
        try (FileOutputStream fos = new FileOutputStream(getFilePath());
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            Integer bankNumber = bank.getNumber();
            oos.writeInt(bankNumber);
            oos.writeObject(rates);
        } catch (FileNotFoundException e){
            System.out.println("Что-то не так с файлом, " + e.getMessage());
        } catch (IOException e){
            System.out.println("Что-то совсем не так, " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void readAllFile() {
        File f = new File(getFilePath());
        if (f.length() == 0) {
            return;
        }
        try (FileInputStream fis = new FileInputStream(getFilePath());
             ObjectInputStream ois = new ObjectInputStream(fis)){
            Integer bankName = ois.readInt();
            System.out.println(bankName);
            TreeMap<Date, HashMap<String, Double>> rates  =
                    (TreeMap<Date, HashMap<String, Double>>) ois.readObject();
            if (bankName == Banks.NBRB.getNumber()) {
                TreeMap<Date, HashMap<String, Double>> nbrb =
                        getRatesNBRB();
                nbrb.putAll(rates);
                Test.setRatesNBRB(nbrb);
            } else if (bankName == Banks.BAB.getNumber()) {
                TreeMap<Date, HashMap<String, Double>> bab =
                        Test.getRatesBAB();
                bab.putAll(rates);
                Test.setRatesBAB(bab);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
