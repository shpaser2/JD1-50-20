package homework8.SiteLoader.service;

public enum Banks {
    NBRB(1),
    BAB(2),
    BPS(3),
    UNKNOWN(4);

    private Integer number;

    Banks(int number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}
