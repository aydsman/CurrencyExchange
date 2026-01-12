import java.util.Map;

public class Currency_Rates {
    private Map<String, Double> rates; // Map storing parsed rate data from API
    private String base; // Base currency code

    public Currency_Rates(Map<String, Double> rates, String base) {
        this.rates = rates;
        this.base = base;
    }

    // Returns base currency
    public String returnBase() {
        return this.base;
    }

    // Returns the rate of a specific currency
    public Double returnRate(String code) {
        return this.rates.get(code);
    }

    Map<String, Double> returnMap() {
        return this.rates;
    }

    public Double convert(String codeConv, double money) {
        Double rateConv = this.rates.get(codeConv);
        return money * rateConv;
    }
}
