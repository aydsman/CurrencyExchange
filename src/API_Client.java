import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class API_Client {

    public String fetchData(String url) throws Exception {
        // 1. Create an HTTP client
        HttpClient client = HttpClient.newHttpClient();

        // 2. Build the HTTP request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        // 3. Send the request and get the response
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        // 4. Return the raw response body (JSON text)
        return response.body();
    }

    public Currency_Rates parseData(String json) {

        // 1. Turn the raw string into a JSON object
        JSONObject root = new JSONObject(json);

        // 2. Get base currency
        String baseCurrency = root.optString("base", "USD");

        // 3. Get the rates object
        JSONObject ratesJson = root.getJSONObject("rates");

        // 4. Create map to store currency -> rate
        Map<String, Double> ratesMap = new HashMap<>();

        // 5. Loop through all currency codes
        for (String currencyCode : ratesJson.keySet()) {
            String rateStr = ratesJson.getString(currencyCode);
            double rate = Double.parseDouble(rateStr);
            ratesMap.put(currencyCode, rate);
        }

        // 6. Create and return your model object
        return new Currency_Rates(ratesMap, baseCurrency);
    }
}
