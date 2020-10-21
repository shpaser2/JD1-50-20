/*
 * Сергей Шпаковский
 *
 * Это программное обеспечение является публичной и открытой
 * информацией.
 *
 * АВТОР НЕ ДАЁТ НИКАКИХ ГАРАНТИЙ, ЯВНЫХ ИЛИ КОСВЕННЫХ (ВКЛЮЧАЯ - НО
 * НЕ ОГРАНИЧИВАЯСЬ ИМИ - ГАРАНТИИ РЕАЛИЗУЕМОСТИ), СООТВЕТСТВИЯ
 * ОПРЕДЕЛЁННОМУ НАЗНАЧЕНИЮ ИЛИ НЕНАРУШЕНИЯ УСЛОВИЙ, ЧТО СОДЕРЖИМОЕ
 * ДАННОГО ФАЙЛА ПОДХОДИТ ДЛЯ КАКИХ-ЛИБО ЦЕЛЕЙ ИЛИ ЧТО ЛЮБОЕ
 * ИСПОЛЬЗОВАНИЕ ИЛИ РЕАЛИЗАЦИЯ ТАКОГО СОДЕРЖИМОГО НЕ БУДЕТ НАРУШАТЬ
 * КАКИХ-ЛИБО ПАТЕНТОВ ТРЕТЬЕЙ СТОРОНЫ, АВТОРСКИХ ПРАВ, КОММЕРЧЕСКОЙ
 * ТАЙНЫ ИЛИ ИНЫХ ПРАВ.
 */
package homework6.service;

import java.util.Objects;

/**
 * Класс описывающий пользователя.
 */
public class Person implements Comparable<Person> {
    private String nick;
    private String password;

    /**
     * Конструктор для сохдания нового пользователя.
     * @param nick - никнейм пользователя.
     * @param password - пароль пользователя.
     */
    public Person(String nick, String password) {
        this.nick = nick;
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(nick, person.nick) &&
                Objects.equals(password, person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nick, password);
    }

    /**
     * Строка с данными о пользователе в формате:
     * {nick: "Анатолий", password: "dsfEFdsfaE12FDSf"}.
     * @return Строка с полями пользователя в определенном формате.
     */
    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n{nick: \"").append(nick)
                .append("\", password: \"").append(password).append("\"}");
        return stringBuffer.toString();
    }

    /**
     * Реализация интерфейса Comparable для использования данного
     * класса в коллекциях унаследованных от Set типа TreeSet.
     * Реализация сравнения аналогична {@link PersonComparator}.
     * @param o пользователь, с которым сравнивается
     *          текущий пользователь от объекта которого вызывается
     *          данный метод.
     * @return  целочисленное знаковое значение.
     */
    @Override
    public int compareTo(Person o) {
        if (this == o) {
            return 0;
        }
        int passwordsCompareResult = this.getPassword().length()
                - o.getPassword().length();
        if (passwordsCompareResult == 0) {
            return this.getNick().compareToIgnoreCase(o.getNick());
        } else {
            return passwordsCompareResult;
        }
    }
}
