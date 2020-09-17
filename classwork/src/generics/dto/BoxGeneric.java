package generics.dto;

public class BoxGeneric<ITEM> {
    private ITEM item;

    public ITEM getItem() {
        return item;
    }

    public void setItem(ITEM item) {
        this.item = item;
    }
}
