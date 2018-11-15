package gradle_jdbc_study_coffee.service;

import java.sql.SQLException;
import java.util.List;

import gradle_jdbc_study_coffee.dao.ProductDao;
import gradle_jdbc_study_coffee.dao.ProductDaoImpl;
import gradle_jdbc_study_coffee.dao.SaleDao;
import gradle_jdbc_study_coffee.dao.SaleDaoImpl;
import gradle_jdbc_study_coffee.dto.Product;
import gradle_jdbc_study_coffee.dto.Sale;

public class OutputService {
	private SaleDao saleDao;

	public OutputService() {
		saleDao = new SaleDaoImpl();
	}
	
	public List<Sale> outputOrder(boolean isSale) throws SQLException {
		return saleDao.selectSaleRank(isSale);
	}
}
