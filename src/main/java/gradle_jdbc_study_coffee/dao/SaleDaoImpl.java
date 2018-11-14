package gradle_jdbc_study_coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gradle_jdbc_study_coffee.dto.Sale;
import gradle_jdbc_study_coffee.jdbc.LogUtil;
import gradle_jdbc_study_coffee.jdbc.MySQLjdbcUtil;

public class SaleDaoImpl implements SaleDao {

	@Override
	public List<Sale> selectSaleByAll() throws SQLException {
		LogUtil.prnLog("selectSaleByAll()");
		
		List<Sale> list = new ArrayList<>();
		String sql = "select no, code, price, saleCnt, marginRate from sale";
		try(Connection conn = MySQLjdbcUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			LogUtil.prnLog(pstmt);
			while(rs.next()) {
				list.add(getSale(rs));
			}
		}
		return list;
	}

	private Sale getSale(ResultSet rs) throws SQLException {
		int no = rs.getInt("no");
		String code = rs.getString("code");
		int price = rs.getInt("price");
		int saleCnt = rs.getInt("saleCnt");
		int marginRate = rs.getInt("marginRate");
		
		return new Sale(no, code, price, saleCnt, marginRate);
	}

	@Override
	public int insertSale(Sale sale) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
