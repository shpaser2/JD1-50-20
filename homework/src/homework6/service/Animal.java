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
 * Класс описывающий питомца.
 */
public class Animal implements Comparable<Animal> {
    private int age;
    private String nick;

    /**
     * Конструктор для сохдания нового питомца.
     * @param age - возраст животного.
     * @param nick - кличка животного.
     */
    public Animal(int age, String nick) {
        this.age = age;
        this.nick = nick;
    }

    public int getAge() {
        return age;
    }

    public String getNick() {
        return nick;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age &&
                Objects.equals(nick, animal.nick);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, nick);
    }

    /**
     * Реализация интерфейса Comparable для использования данного
     * класса в коллекциях унаследованных от Set типа TreeSet.
     * Реализация сравнения аналогична {@link AnimalComparator}.
     * @param o животное, с которым сравнивается
     *          текущее животное от объекта которого вызывается
     *          данный метод.
     * @return  целочисленное знаковое значение.
     */
    @Override
    public int compareTo(Animal o) {
        if (this == o) {
            return 0;
        }
        int ageCompareResult = this.getAge() - o.getAge();
        if (ageCompareResult == 0) {
            return this.getNick().compareToIgnoreCase(o.getNick());
        } else {
            return ageCompareResult;
        }
    }

    /**
     * Строка с данными о питомце в формате:
     * {age: 1, nick: "Люцифер"}.
     * @return Строка с описанием животного в определенном формате.
     */
    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n{age: ").append(age).append(", \"")
                .append(nick).append("\"}");
        return stringBuffer.toString();
    }
}
