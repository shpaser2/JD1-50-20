package generic.dto;

public class BoxGenericTwo<ITEM1, ITEM2> {
    private ITEM1 item;
    private ITEM2 itemTwo;
    
    public ITEM1 getItem() {
        return item;
    }
    
    public void setItem(ITEM1 item) {
        this.item = item;
    }
    
    public ITEM2 getItemTwo() {
        return itemTwo;
    }
    
    public void setItemTwo(ITEM2 itemTwo) {
        this.itemTwo = itemTwo;
    }
}
