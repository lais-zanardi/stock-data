package zanardil.alpha.vantage.api;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

public class AlphaVantageService {
    private static final String API_KEY = "2I8I88SQ0T7GFUKM";
    private static final String BASE_URL = "https://www.alphavantage.co/query";
    private final RestTemplate restTemplate;

    public AlphaVantageService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public AlphaVantageDTO getStockData(String symbol) {
        String url = BASE_URL + "?function=TIME_SERIES_DAILY_ADJUSTED&symbol=" + symbol + "&apikey=" + API_KEY;
        return restTemplate.getForObject(url, AlphaVantageDTO.class);
    }
}
