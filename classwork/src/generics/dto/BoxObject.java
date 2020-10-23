package generics.dto;

import java.io.Serializable;

public class BoxObject implements Serializable {
    private Object item;

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }
}
