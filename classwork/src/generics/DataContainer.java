package generics;

import java.util.Arrays;
import java.util.Comparator;

public class DataContainer<T> {
    private T[] data;

    public DataContainer(T[] data) {
        this.data = data;
    }

    public int add(T item){
        for (int i = 0; i < this.data.length; i++) {
            if(this.data[i] == null){
                this.data[i] = item;
                return i;
            }
        }
        return -1;
    }

    public void sort(Comparator<T> comparator){
        T tmp;
        for (int i = 0; i < this.data.length - 1; i++) {
            for (int j = 0; j < this.data.length - 1; j++) {
                if (comparator.compare(this.data[j], this.data[j + 1]) > 0) {
                    tmp = this.data[j];
                    this.data[j] = this.data[j + 1];
                    this.data[j + 1] = tmp;
                }
            }
        }
    }

    public static <V extends Comparable> void sort(DataContainer<V> container){
        V tmp;
        for (int i = 0; i < container.data.length - 1; i++) {
            for (int j = 0; j < container.data.length - 1; j++) {
                if (container.data[j].compareTo(container.data[j + 1]) > 0) {
                    tmp = container.data[j];
                    container.data[j] = container.data[j + 1];
                    container.data[j + 1] = tmp;
                }
            }
        }
    }

    public static <V> void sort(DataContainer<V> container, Comparator<V> comparator){
        V tmp;
        for (int i = 0; i < container.data.length - 1; i++) {
            for (int j = 0; j < container.data.length - 1; j++) {
                if (comparator.compare(container.data[j], container.data[j + 1]) > 0) {
                    tmp = container.data[j];
                    container.data[j] = container.data[j + 1];
                    container.data[j + 1] = tmp;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "generics.DataContainer{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
