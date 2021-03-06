package gradle_jdbc_study_coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gradle_jdbc_study_coffee.dto.Product;
import gradle_jdbc_study_coffee.jdbc.ConnectionProvider;
import gradle_jdbc_study_coffee.jdbc.LogUtil;
import gradle_jdbc_study_coffee.jdbc.MySQLjdbcUtil;

public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> selectProductByAll() throws SQLException {
		LogUtil.prnLog("selectProductByAll()");
		
		List<Product> list = new ArrayList<>();
		String sql = "select code, name from product";
		try(Connection conn = MySQLjdbcUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			LogUtil.prnLog(pstmt);
			while(rs.next()) {
				list.add(getProduct(rs));
			}
		} 
		return list;
	}

	private Product getProduct(ResultSet rs) throws SQLException {
		String code = rs.getString("code");
		String name = rs.getString("name");
		
		return new Product(code, name);
	}

	//제품코드로 검색
	@Override
	public Product selectProductByCode(Product pdt) throws SQLException {
		String sql = "select code, name from product where code = ?";
		
		Product product = null;
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, pdt.getCode());
			LogUtil.prnLog(pstmt);
			
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					product = getProduct(rs);
				}
			}
		} catch(SQLException e1) {
			e1.printStackTrace();
		}
		return product;
	}

}
