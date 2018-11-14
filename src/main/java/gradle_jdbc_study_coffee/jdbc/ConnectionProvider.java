package gradle_jdbc_study_coffee.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionProvider {
				//java.sql(import)
	public static Connection getConnection() throws SQLException {
				//MyDataSource ~ getDataSource()가 connection과 같음
		return MyDataSource.getInstance().getDataSource().getConnection();
	}
}
