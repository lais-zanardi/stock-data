package zanardil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zanardil.stockdata.exceptions.StockDataNotFoundException;

import java.util.List;

@Service
public class StockDataService {
        @Autowired
        private StockDataRepository stockDataRepository;

        public List<StockData> getAllStockData() {
            return stockDataRepository.findAll();
        }

        public StockData getStockDataById(Long id) {
            return stockDataRepository.findById(id).orElseThrow(() -> new StockDataNotFoundException("StockData", "id"));
        }

        public StockData createStockData(StockData stockData) {
            return stockDataRepository.save(stockData);
        }

        public StockData updateStockData(Long id, StockData stockDataDetails) {
            StockData stockData = stockDataRepository.findById(id).orElseThrow(() -> new StockDataNotFoundException("StockData", "id"));

            stockData.setSymbol(stockDataDetails.getSymbol());
            stockData.setPrice(stockDataDetails.getPrice());
            stockData.setVolume(stockDataDetails.getVolume());
            stockData.setDate(stockDataDetails.getDate());

            return stockDataRepository.save(stockData);
        }

        public void deleteStockData(Long id) {
            StockData stockData = stockDataRepository.findById(id).orElseThrow(() -> new StockDataNotFoundException("StockData", "id"));
            stockDataRepository.delete(stockData);
        }
}
