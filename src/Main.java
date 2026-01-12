public class Main {
    public static void main(String[] args) {

        // Initialize API Client object
        API_Client apiClient = new API_Client();

        // Assign URL for the API in String
        String url = "https://api.currencyfreaks.com/v2.0/rates/latest?apikey=a13777c1ace84b068316e5566182be24";

        try {
            // Fetch and parse JSON into object
            String jsonData = apiClient.fetchData(url);
            Currency_Rates currency = apiClient.parseData(jsonData);

            // Initialize display object
            Display display = new Display(currency.returnBase(), currency.returnMap());
            display.displayCurrencies();

        } catch (Exception e) {
            // Handles any exceptions thrown during fetching/parsing
            System.out.println("An error occurred while fetching or parsing data:");
            e.printStackTrace();
        }
    }
}