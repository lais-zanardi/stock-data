package zanardil.alpha.vantage.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/alpha-vantage")
public class AlphaVantageController {

    private final AlphaVantageService alphaVantageService;

    @GetMapping("/{symbol}")
    public ResponseEntity<AlphaVantageDTO> getStockData(@PathVariable String symbol) {
        if (symbol == null || symbol.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Stock symbol missing");
        }
        return ResponseEntity.ok(alphaVantageService.getStockData(symbol));

    }

}
