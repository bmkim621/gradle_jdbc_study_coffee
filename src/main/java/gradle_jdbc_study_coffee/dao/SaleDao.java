package gradle_jdbc_study_coffee.dao;

import java.sql.SQLException;
import java.util.List;

import gradle_jdbc_study_coffee.dto.Sale;

public interface SaleDao {
	List<Sale> selectSaleByAll() throws SQLException;
	
	int insertSale(Sale sale) throws SQLException;
	
	List<Sale> selectSaleRank(boolean isSale) throws SQLException;
}
