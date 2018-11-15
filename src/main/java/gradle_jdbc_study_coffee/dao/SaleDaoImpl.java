package gradle_jdbc_study_coffee.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gradle_jdbc_study_coffee.dto.Sale;
import gradle_jdbc_study_coffee.dto.SaleDetail;
import gradle_jdbc_study_coffee.jdbc.ConnectionProvider;
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
		LogUtil.prnLog("insertSale");
		
		String sql = "insert into sale values(?, ?, ?, ?, ?)";
		int res = 0;
		
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			//1 번호, 2 제품코드, 3 제품단가, 4 판매수량, 5 마진율
			pstmt.setInt(1, sale.getNo());
			pstmt.setString(2, sale.getCode());
			pstmt.setInt(3, sale.getPrice());
			pstmt.setInt(4, sale.getSaleCnt());
			pstmt.setInt(5, sale.getMarginRate());
			
			LogUtil.prnLog(pstmt);
			
			res = pstmt.executeUpdate();
		}
		return res;
	}

	@Override
	public List<Sale> selectSaleRank(boolean isSale) throws SQLException {
		LogUtil.prnLog("selectSaleRank");
		List<Sale> list = new ArrayList<>();
		String sql = "{call price_rank(?)}";
		try(Connection conn = ConnectionProvider.getConnection();
				CallableStatement cs = conn.prepareCall(sql);){
			cs.setBoolean(1, isSale);
			LogUtil.prnLog(cs.toString());
			try(ResultSet rs = cs.executeQuery()){
				while(rs.next()) {
					list.add(getSaleDetail(rs));
				}
				
			}

		}
		LogUtil.prnLog("selectSaleRank" + list.size());
		return list;
	}

	private Sale getSaleDetail(ResultSet rs) throws SQLException {
		int no = rs.getInt("no");
		String code = rs.getString("code");
		int price = rs.getInt("price");
		int saleCnt = rs.getInt("saleCnt");
		int marginRate = rs.getInt("marginRate");
		int supplytax = rs.getInt("supplytax");
		int addtax = rs.getInt("addtax");
		int saleprice = rs.getInt("saleprice");
		int marginprice = rs.getInt("marginprice");
		
		SaleDetail detail = new SaleDetail(supplytax, addtax, saleprice, marginprice);
		Sale sale = new Sale(no, code, price, saleCnt, marginRate, detail);
		LogUtil.prnLog(sale.toString());
		return sale;
	}

}
