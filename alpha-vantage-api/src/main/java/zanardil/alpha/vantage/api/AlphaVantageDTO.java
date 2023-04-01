package zanardil.alpha.vantage.api;

import lombok.Data;


import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class AlphaVantageDTO {
    private String name;
    private String symbol;
    private BigDecimal price;
    private Integer volume;
    private LocalDate date;

    public static AlphaVantageDTO of(AlphaVantageAPI alphaVantageAPI){
        AlphaVantageDTO alphaVantageDTO = new AlphaVantageDTO();
        alphaVantageDTO.setName(alphaVantageAPI.getName());
        alphaVantageDTO.setSymbol(alphaVantageAPI.getSymbol());
        alphaVantageDTO.setPrice(alphaVantageAPI.getPrice());
        alphaVantageDTO.setVolume(alphaVantageAPI.getVolume());
        alphaVantageDTO.setDate(alphaVantageAPI.getDate());

        return alphaVantageDTO;
    }

    public AlphaVantageAPI toEntity(){
        AlphaVantageAPI alphaVantageAPI = new AlphaVantageAPI();
        alphaVantageAPI.setName(name);
        alphaVantageAPI.setSymbol(symbol);
        alphaVantageAPI.setPrice(price);
        alphaVantageAPI.setVolume(volume);
        alphaVantageAPI.setDate(date);
        return alphaVantageAPI;
    }
}
