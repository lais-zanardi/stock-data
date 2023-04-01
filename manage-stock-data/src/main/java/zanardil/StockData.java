package zanardil;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class StockData {
    @Id
    private String symbol;
    private String name;
    private BigDecimal price;
    private Integer volume;
    private LocalDate date;
}
