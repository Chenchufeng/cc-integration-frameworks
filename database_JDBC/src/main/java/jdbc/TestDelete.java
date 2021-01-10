package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import utils.JdbcUtils;

public class TestDelete {

  public static void main(String[] args) {
    Connection connection = null;
    Statement st = null;
    try {
      connection = JdbcUtils.getConnection(); // 获取数据库连接
      st = connection.createStatement(); // 获得执行sql的对象 Statement
      String sql = "DELETE from users WHERE id=4";
      int count = st.executeUpdate(sql);
      if (count > 0) {
        System.out.println("删除成功");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JdbcUtils.release(connection, st, null);
    }
  }
}
