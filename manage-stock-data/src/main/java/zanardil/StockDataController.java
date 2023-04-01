package zanardil;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/stock")
public class StockDataController {
    private final StockDataService stockDataService;

    @PostMapping
    public ResponseEntity<Void> saveData(@RequestBody StockDataDTO stockData) {
        if (stockData.getSymbol().isBlank()) {
            throw new StockNotFoundException(stockData.getName(), stockData.getSymbol());
        }
        return ResponseEntity.created(URI.create("/api/stock/" + stockData.getSymbol())).build();
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<StockDataDTO> getById(@PathVariable String symbol) {
        if (symbol == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Symbol not informed");
        }
        StockData entity = stockDataService.getDataById(symbol)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find a stock with this symbol"));
        return ResponseEntity.ok(StockDataDTO.of(entity));
    }

    @DeleteMapping("/symbol")
    public ResponseEntity<Void> deleteStockDataBySymbol(@PathVariable String symbol) {
        stockDataService.deleteStockData(symbol);
        return ResponseEntity.noContent().build();
    }
}
