package zanardil;

import jakarta.ws.rs.WebApplicationException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StockDataService {
        @Autowired
        private StockDataRepository stockDataRepository;
        private final AlphaVantageAPIClient alphaVantageApiClient;

        public void saveData(StockData data) {
            try {

                if(!alphaVantageApiClient.isAvaiable(data.getSymbol())) {
                    throw new StockNotFoundException(data.getName(), data.getSymbol());
                }
            } catch (RestClientException e) {
                throw new WebApplicationException();
            }

            stockDataRepository.save(data);
        }

        public List<StockData> getAllStockData() {
            return stockDataRepository.findAll();
        }



        public Optional<StockData> getDataById(String symbol) {
            return stockDataRepository.findById(symbol);
        }


        public void deleteStockData(String symbol) {
            StockData stockData = stockDataRepository.findById(symbol)
                    .orElseThrow(() -> new StockNotFoundException("Stock not found for symbol: ", symbol));
            stockDataRepository.delete(stockData);
        }

}
