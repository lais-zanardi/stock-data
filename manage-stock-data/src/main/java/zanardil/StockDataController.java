package zanardil;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zanardil.stockdata.dto.StockDataDTO;
import zanardil.stockdata.exceptions.StockDataNotFoundException;
import zanardil.stockdata.service.StockDataService;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/stock")
public class StockDataController {


    private final StockDataService stockDataService;

    @PostMapping
    public ResponseEntity<Void> saveStockData(@RequestBody StockDataDTO stockData) {
        if(stockData.getSymbol().isBlank()) {
            throw new StockDataNotFoundException(stockData.getName(), stockData.getSymbol());
        }
        return ResponseEntity.created(URI.create("/api/stock/" + stockData.getSymbol())).build();
    }


}
