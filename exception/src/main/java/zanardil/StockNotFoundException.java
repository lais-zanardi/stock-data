package zanardil;

public class StockNotFoundException extends RuntimeException {
    public StockNotFoundException(String message, String symbol) {
        super(String.format(message + symbol));
    }
}
