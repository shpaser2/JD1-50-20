package homework9;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static homework5.warEndPeace.WarAndPeace.readAllBytesJava7;
import static homework8.SiteLoader.service.FilesHandling.getPathToSrcDir;
import static homework8.SiteLoader.service.FilesHandling.pathWithFileInside;


public class Test {
    private static final String txtFileNameByDefault = "students.txt";
    private static final String binFileNameByDefault = "students.bin";

    public static void main(String[] args) {
        //2. При загрузке приложения запрашивать адрес файла из которого
        // мы будем десериализовать данные о студентах.
        //	2.1. Если ничего не указать то проверяется наличие файла
        //	students.bin относительно места запуска программы.
        //	2.2. Если файл не найден то генерируем в указанное место файл.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу с расширением .bin");
        String maybePath = scanner.nextLine().strip();
        Path usedPathTxt;
        Path usedPathBin;
        usedPathTxt = processPath("", txtFileNameByDefault);
        usedPathBin = processPath(maybePath, binFileNameByDefault);

        //Парсинг имен и фамилий из файлов
        Test test = new Test();
        String strPath = getPathToSrcDir(test);
        String namesPath = pathWithFileInside(strPath,
                "russian_names.json").toString();
        String surnamesPath = pathWithFileInside(strPath,
                "russian_surnames.json").toString();
        String namesJson = readAllBytesJava7(namesPath);
        String surnamesJson = readAllBytesJava7(surnamesPath);
        String regexNamePrefix = "\"Name\":\"";
        String regexSurnamePrefix = "\"Surname\":\"";
        String regexWord = "[А-Яа-яЁё]*";
        ArrayList<String> names = parseStringsInJsonWithKey(
                regexNamePrefix, regexWord, namesJson);
        ArrayList<String> surnames = parseStringsInJsonWithKey(
                regexSurnamePrefix, regexWord, surnamesJson);

        //2.2.1 При помощи Stream.generate() создать 10000 студентов
        Random rnd = new Random();
        Supplier<Student> studentSupplier = ()->{
            int randomExclusiveBoundCompensation = 1;
            int MAX_MARK = 10 + randomExclusiveBoundCompensation;
            String name = names.get(rnd.nextInt(names.size()));
            String surname = surnames.get(rnd.nextInt(surnames.size()));;
            String secName = names.get(rnd.nextInt(names.size()));
            int mark = rnd.nextInt(MAX_MARK);
            return new Student(name, surname, secName, mark);
        };
        int STUDENTS_LIMIT = 10_000;
        //2.2.2 Сохранить в коллекцию
        List<Student> students = Stream.generate(studentSupplier)
                .limit(STUDENTS_LIMIT)
                .collect(Collectors.toList());

        //2.2.3 Коллекцию сохранить в файл
        //2.2.3.2 При помощи сохранения каждого поля отдельно в текстовый файл
        try (FileWriter writer = new FileWriter(
                usedPathTxt.toString(), false)) {
            for (Student student : students) {
                writer.write(student.getSurname());
                writer.append('\n');
                writer.write(student.getFirstName());
                writer.append('\n');
                writer.write(student.getFathersName());
                writer.append('\n');
                writer.write(student.getFio());
                writer.append('\n');
                writer.write(String.valueOf(student.getMark()));
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //2.2.3.1 При помощи механизма сериализации в бинарный файл
        try(ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(usedPathBin.toString()))) {
            for (Student student : students) {
                oos.writeObject(student);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

        //3. Вывести top N по оценке, осортировать по имени
        int nElements = 20;
        students.sort(new MarksComparator());
        NameComparator nameComparator = new NameComparator();
        List<Student> topStudents = students.stream().limit(nElements).sorted(nameComparator)
                .collect(Collectors.toList());
        topStudents.stream().forEach(System.out::println);

        //4. Записать получившийся результат (топ N) в файл
        String pathToSrcDir = getPathToSrcDir(test);
        String pathToTopStudents = pathToSrcDir + File.separator
                + "topStudents.bin";
        try(ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(pathToTopStudents))) {
            for (Student student : topStudents) {
                oos.writeObject(student);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }


    /**
    Если ничего не указать то проверяется наличие файла students.bin относительно места запуска программы.
    2.2. Если файл не найден то генерируем в указанное место файл.
     */
    private static Path processPath(String maybePath, String checkedFileName) {
        Path path;
        try {
            path = Paths.get(maybePath);
//            boolean isExisting = Files.exists(path);
            boolean isFolder = Files.isDirectory(path);
            boolean isFile = Files.isRegularFile(path);
            boolean isWriteable = Files.isWritable(path);
            boolean isReadable = Files.isReadable(path);

            if (isFile && isWriteable && isReadable) {
                return path;
            } else if (isFolder && isWriteable && isReadable
                    && (maybePath.length() != 0)) {
                path = pathWithFileInside(maybePath, checkedFileName);
                Files.createFile(path);
                return path;
            } else {
                Test t = new Test();
                String pathToSrcDir = getPathToSrcDir(t);
                path = pathWithFileInside(pathToSrcDir, checkedFileName);
                if (!Files.exists(path)) {
                    Files.createFile(path);
                }
                return path;
            }
        } catch (InvalidPathException | IOException e) {
            e.printStackTrace();
            System.out.println("Будет использован путь к папке с " +
                    "исходным кодом данной программы.");
            path = Paths.get(checkedFileName);
            return path;
        }
    }

    /**
     * Извлекает список с одним параметром из множества параметров
     * в JSON.
     * @param regexPrefix Example - "\"Surname\":\"".
     * @param regexWord Example for russian - "[А-Яа-яЁё]*".
     * @param jsonStr One json String with different params.
     * @return ArrayList c искомыми параметрами одного типа.
     */
    public static ArrayList<String> parseStringsInJsonWithKey(
            String regexPrefix,
            String regexWord,
            String jsonStr) {
        Pattern pattern = Pattern.compile(regexPrefix + regexWord);
        Matcher matcher = pattern.matcher(jsonStr);
        LinkedList<String> buffer = new LinkedList<>();
        while (matcher.find()) {
            buffer.add(matcher.group());
        }
        ArrayList<String> data = new ArrayList<>(buffer);
        int prefix = regexPrefix.length();
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i).substring(prefix));
        }
        return data;
    }
}
