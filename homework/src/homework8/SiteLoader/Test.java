package homework8.SiteLoader;

public class Test {
    public static void main(String[] args) {
        System.out.println("продажа, НБРБ");
        printRates(new NBRBLoader());
        System.out.println("продажа, БПС");
        printRates(new BPSLoader());
    }

    public static void printRates(SiteLoader loader){
        System.out.println(SiteLoader.Currency.EUR.toString() + " "
                + loader.load(SiteLoader.Currency.EUR));
        System.out.println(SiteLoader.Currency.RUB.toString() + " "
                + loader.load(SiteLoader.Currency.RUB));
        System.out.println(SiteLoader.Currency.USD.toString() + " "
                + loader.load(SiteLoader.Currency.USD));
    }
}
