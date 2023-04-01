package zanardil.stockdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import zanardil.stockdata.dto.StockDataDTO;
import zanardil.stockdata.exceptions.StockDataNotFoundException;
//import zanardil.stockdata.service.AlphaVantageAPI;
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
