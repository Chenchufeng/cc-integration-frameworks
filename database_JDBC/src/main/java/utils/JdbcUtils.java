package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
  private static String driver;
  private static String url;
  private static String username;
  private static String password;

  /**
   * JdbcUtils.class是获得当前对象所属的class对象 getClassLoader()是取得该Class对象的类装载器
   * getResourceAsStream(“database.properties”) 调用类加载器的方法加载 资源，返回的是字节流
   * 使用Properties类是为了可以从.properties属性文件对应的文件输入流中，加载属性列表到Properties类对象，然后通过getProperty方法用指定的键在此属性列表中搜索属性
   */
  static {
    try {
      InputStream input = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
      Properties properties = new Properties();
      properties.load(input);
      driver = properties.getProperty("driver");
      url = properties.getProperty("url");
      username = properties.getProperty("username");
      password = properties.getProperty("password");
      // 驱动只用加载一次
      Class.forName(driver);
    } catch (ClassNotFoundException | IOException e) {
      e.printStackTrace();
    }
  }

  public static Connection getConnection() throws SQLException {

    return DriverManager.getConnection(url, username, password);
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
