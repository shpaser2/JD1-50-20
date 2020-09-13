package oop;

public abstract class APhone {
    private String ownerName;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void call(String number){
        System.out.println("Модный телефон " + getModel() + " владельца " + ownerName + " звонит " + number);
    }

    public abstract String getModel();
}
