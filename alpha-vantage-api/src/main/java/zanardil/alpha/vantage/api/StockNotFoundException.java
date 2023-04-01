package zanardil.alpha.vantage.api;

public class StockNotFoundException extends RuntimeException {
    public StockNotFoundException(String stockName, String symbol) {
        super(String.format("%s not found with %s", stockName, symbol));
    }
}
