package gradle_jdbc_study_coffee;

import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import gradle_jdbc_study_coffee.dao.ProductDao;
import gradle_jdbc_study_coffee.dao.ProductDaoImpl;
import gradle_jdbc_study_coffee.dto.Product;
import gradle_jdbc_study_coffee.jdbc.LogUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest {
	static ProductDao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("START ProductDaoTest");
		dao = new ProductDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("END ProductDaoTest");
		dao = null;
	}

	@Before
	public void setUp() throws Exception {
		System.out.println();
	}

	@Test
	public void test01selectProductByAll() throws SQLException {
		List<Product> list = dao.selectProductByAll();
		LogUtil.prnLog(list.toString());
		Assert.assertNotNull(list);
	}

}
