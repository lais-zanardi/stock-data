package zanardil.stockdata.service;

import org.springframework.web.client.RestTemplate;
import zanardil.stockdata.dto.StockDataDTO;

public class AlphaVantageAPI {
    private static final String API_KEY = "2I8I88SQ0T7GFUKM";
    private static final String BASE_URL = "https://www.alphavantage.co/query";
    private RestTemplate restTemplate;

    public StockDataDTO getStockData(String symbol) {
        String url = BASE_URL + "?function=TIME_SERIES_DAILY&symbol=" + symbol + "&apikey=" + API_KEY;
        StockDataDTO response = restTemplate.getForObject(url, StockDataDTO.class);
        return response;

    }
}
