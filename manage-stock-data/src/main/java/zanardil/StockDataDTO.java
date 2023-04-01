package zanardil;

import lombok.Data;
import zanardil.stockdata.model.StockData;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class StockDataDTO {
    private String name;
    private String symbol;
    private BigDecimal price;
    private Integer volume;
    private LocalDate date;

    public static StockDataDTO of(StockData stockData){
        StockDataDTO stockDataDTO = new StockDataDTO();
        stockDataDTO.setName(stockData.getName());
        stockDataDTO.setSymbol(stockData.getSymbol());
        stockDataDTO.setPrice(stockData.getPrice());
        stockDataDTO.setVolume(stockData.getVolume());
        stockDataDTO.setDate(stockData.getDate());

        return stockDataDTO;
    }

    public StockData toEntity(){
        StockData stockData = new StockData();
        stockData.setName(name);
        stockData.setSymbol(symbol);
        stockData.setPrice(price);
        stockData.setVolume(volume);
        stockData.setDate(date);
        return stockData;
    }
}
