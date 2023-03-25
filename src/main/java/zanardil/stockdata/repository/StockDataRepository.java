package zanardil.stockdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zanardil.stockdata.model.StockData;

public interface StockDataRepository extends JpaRepository<StockData, Long> {
}
