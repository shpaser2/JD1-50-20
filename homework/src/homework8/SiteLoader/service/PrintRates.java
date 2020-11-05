package homework8.SiteLoader.service;

import homework8.SiteLoader.BABLoader;
import homework8.SiteLoader.NBRBLoader;
import homework8.SiteLoader.SiteLoader;

import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

public class PrintRates {

    public static void printRatesTree(TreeMap<Date, HashMap<String, Double>> rates) {
        Set<Date> keys = rates.keySet();
        for (Date date : keys) {
            System.out.println(date);
            System.out.println(rates.get(date));
        }
    }

    public static void printRates(SiteLoader loader){
        System.out.println(SiteLoader.Currency.EUR.toString() + " "
                + loader.load(SiteLoader.Currency.EUR));
        System.out.println(SiteLoader.Currency.RUB.toString() + " "
                + loader.load(SiteLoader.Currency.RUB));
        System.out.println(SiteLoader.Currency.USD.toString() + " "
                + loader.load(SiteLoader.Currency.USD));
    }

    public static HashMap<String, Double> loadRatesOnDate(BABLoader loader,
                                                    String date) {
        HashMap<String, Double> rates = new HashMap<>();
        rates.put(SiteLoader.Currency.EUR.toString(),
                loader.load(SiteLoader.Currency.EUR, date));
        rates.put(SiteLoader.Currency.RUB.toString(),
                loader.load(SiteLoader.Currency.RUB, date));
        rates.put(SiteLoader.Currency.USD.toString(),
                loader.load(SiteLoader.Currency.USD, date));
        return rates;
    }

    public static HashMap<String, Double> loadRatesOnDate(NBRBLoader loader,
                                                    String date) {
        HashMap<String, Double> rates = new HashMap<>();
        rates.put(SiteLoader.Currency.EUR.toString(),
                loader.load(SiteLoader.Currency.EUR, date));
        rates.put(SiteLoader.Currency.RUB.toString(),
                loader.load(SiteLoader.Currency.RUB, date));
        rates.put(SiteLoader.Currency.USD.toString(),
                loader.load(SiteLoader.Currency.USD, date));
        return rates;
    }
}
