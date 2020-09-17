package generics.dto;

public class BoxNumber<T extends Number> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public double plus(T a, T b){
        double num1 = a.doubleValue();
        double num2 = b.doubleValue();

        this.item.doubleValue();

        return num1 + num2;
    }
}
