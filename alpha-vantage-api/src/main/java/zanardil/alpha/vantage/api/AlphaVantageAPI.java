package zanardil.alpha.vantage.api;

import lombok.Data;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class AlphaVantageAPI {
    private String name;
    private String symbol;
    private BigDecimal price;
    private Integer volume;
    private LocalDate date;

}
