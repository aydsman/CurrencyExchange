import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

import java.util.Map;

public class Display {
    private Map<String, Double> rates;
    private String base;

    public Display(String base, Map<String, Double> rates) {
        this.rates = rates;
        this.base = base;
    }

    public List<String> returnSortedList() {
        List<String> list = new ArrayList<>();
        for (String code : rates.keySet()) {
            list.add(code);
        }
        Collections.sort(list);
        return list;
    }

    public boolean checkLen3(String s) {
        if (s.length() == 3) {
            return true;
        }
        else return false;
    }

    // Do later
    public void sortCurrencyCodes() {}

    public void displayCurrencies() {
        System.out.println("Base currency: " + this.base + "\n----------------------");
        List<String> list = returnSortedList();
        for (String code : list) {
            System.out.println("Currency: " + code + " || Exchance Rate: " + rates.get(code));
        }
    }
}
