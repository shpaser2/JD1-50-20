package generics.dto;

public class BoxGenericTwo<ITEM1 extends String, ITEM2 extends Number> {
    private ITEM1 item;
    private ITEM2 itemTwo;

    public ITEM1 getItem() {
        return item;
    }

    public void setItem(ITEM1 item) {
        this.item = item;
    }

    public void setItem(ITEM2 itemTwo) {
        this.itemTwo = itemTwo;
    }

    public ITEM2 getItemTwo() {
        return itemTwo;
    }
}
