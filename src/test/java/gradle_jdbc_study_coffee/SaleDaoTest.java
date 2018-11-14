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

import gradle_jdbc_study_coffee.dao.SaleDao;
import gradle_jdbc_study_coffee.dao.SaleDaoImpl;
import gradle_jdbc_study_coffee.dto.Sale;
import gradle_jdbc_study_coffee.jdbc.LogUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SaleDaoTest {
	static SaleDao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("START SaleDaoTest");
		dao = new SaleDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("END SaleDaoTest");
		dao = null;
	}

	@Before
	public void setUp() throws Exception {
		System.out.println();
	}

	//select
	@Test
	public void test() throws SQLException {
		LogUtil.prnLog("selectSaleByAll()");
		List<Sale> list = dao.selectSaleByAll();
		LogUtil.prnLog(list.toString());
		Assert.assertNotNull(list);
	}

}
