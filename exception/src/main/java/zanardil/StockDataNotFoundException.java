package zanardil;

public class StockDataNotFoundException extends RuntimeException {
    public StockDataNotFoundException(String stockName, String symbol) {
        super(String.format("%s not found with %s", stockName, symbol));
    }
}
