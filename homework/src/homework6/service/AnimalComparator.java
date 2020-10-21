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

import java.util.Comparator;

/**
 * Класс компаратор для сравнения объектов Animal.
 * Критерии сравнения - возраст животных и клички животных
 * по алфавиту.
 */
public class AnimalComparator implements Comparator<Animal> {

    /**
     * Сравнение идёт по двум полям - сначала по возрасту, затем в
     * алфавитном порядке по кличке без учета регистра.
     * @param o1 первое животное для сравнения.
     * @param o2 второе животное для сравнения.
     * @return знаковое целочисленное значение.
     */
    @Override
    public int compare(Animal o1, Animal o2) {
        if (o1 == o2) {
            return 0;
        }
        int ageCompareResult = o1.getAge() - o2.getAge();
        if (ageCompareResult == 0) {
            return o1.getNick().compareToIgnoreCase(o2.getNick());
        } else {
            return ageCompareResult;
        }
    }
}
