package zanardil.stockdata.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class StockData {
    @Id
    private Long id;
    private String symbol;
    private BigDecimal price;
    private Integer volume;
    private LocalDate date;
}
