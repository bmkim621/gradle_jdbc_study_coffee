package gradle_jdbc_study_coffee.dao;

import java.sql.SQLException;
import java.util.List;

import gradle_jdbc_study_coffee.dto.Product;

public interface ProductDao {
	List<Product> selectProductByAll() throws SQLException;

	Product selectProductByCode(Product pdt) throws SQLException;
	
}
