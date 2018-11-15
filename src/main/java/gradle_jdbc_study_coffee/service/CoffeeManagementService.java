package gradle_jdbc_study_coffee.service;

import java.sql.SQLException;

import gradle_jdbc_study_coffee.dao.ProductDao;
import gradle_jdbc_study_coffee.dao.ProductDaoImpl;
import gradle_jdbc_study_coffee.dao.SaleDao;
import gradle_jdbc_study_coffee.dao.SaleDaoImpl;
import gradle_jdbc_study_coffee.dto.Product;
import gradle_jdbc_study_coffee.dto.Sale;

public class CoffeeManagementService {
	private SaleDao saleDao;
	private ProductDao pdtDao;
	
	public CoffeeManagementService() {
		saleDao = new SaleDaoImpl();
		pdtDao = new ProductDaoImpl();
	}
	
	public int registerSale(Sale sale) throws SQLException {
		return saleDao.insertSale(sale);
	}

	
	public Product searchProduct(Product product) throws SQLException {
		return pdtDao.selectProductByCode(product);
	}
}
