package zanardil.stockdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import zanardil.stockdata.dto.StockDataDTO;
import zanardil.stockdata.service.AlphaVantageAPI;
import zanardil.stockdata.service.StockDataService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/stock")
public class StockDataController {


    private final StockDataService stockDataService;
    private final AlphaVantageAPI alphaVantageAPI;

    @GetMapping("/{symbol}")
    public ResponseEntity<StockDataDTO> getStockData(@PathVariable String symbol) {
        if (symbol == null || symbol.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Stock symbol missing");
        }
        return ResponseEntity.ok(alphaVantageAPI.getStockData(symbol));

    }

}
