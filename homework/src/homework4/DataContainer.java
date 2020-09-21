package homework4;

import java.util.Arrays;


public class DataContainer<T> {
    private T[] arr = (T[]) new Object[]{};


    public int add(T item) {
        int indexInsert = 0;
        for (; indexInsert < arr.length; indexInsert++) {
            if (arr[indexInsert] == null) {
                break;
            }
        }
        if (indexInsert == arr.length) {
            this.arr = Arrays.copyOf(this.arr, this.arr.length + 1);
        }
        this.arr[indexInsert] = item;
        return indexInsert;
    }


    public boolean delete(int index) {
        boolean result = false;
        if (index < arr.length - 1) {
            for (int i = index; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr = Arrays.copyOf(arr, arr.length - 1);
            result = true;
        }
        return result;
    }


    public boolean delete(T item) {
        boolean result = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(item)) {
                delete(i);
                result = true;
                break;
            }
        }
        return result;
    }


    public T[] getItems() {
        return arr;
    }


    public T get(int index) {
        return arr[index];
    }


    public void print() {
        for (T t : arr) {
            System.out.println(t);
        }
    }
}
