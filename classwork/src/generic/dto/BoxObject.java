package generic.dto;

import java.io.Serializable;

public class BoxObject implements Serializable {
    private Object item;
    private Object itemTwo;
    
    public Object getItem() {
        return item;
    }
    
    public void setItem(Object item) {
        this.item = item;
    }
}
