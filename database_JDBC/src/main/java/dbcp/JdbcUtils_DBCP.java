package dbcp;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

public class JdbcUtils_DBCP {
  private static DataSource source = null;

  static {
    try {
      InputStream input =
          JdbcUtils_DBCP.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
      Properties properties = new Properties();
      properties.load(input);
      // 创建数据源，工厂模式
      source = BasicDataSourceFactory.createDataSource(properties);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static Connection getConnection() throws SQLException {
    return source.getConnection(); // 从数据源中获取连接
  }

  public static void release(Connection conn, Statement st, ResultSet rs) {
    if (rs != null) {
      try {
        rs.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    if (st != null) {
      try {
        st.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
