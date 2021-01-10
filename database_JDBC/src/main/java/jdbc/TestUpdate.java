package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import utils.JdbcUtils;

public class TestUpdate {
  public static void main(String[] args) {
    Connection connection = null;
    Statement st = null;
    try {
      connection = JdbcUtils.getConnection(); // 获取数据库连接
      st = connection.createStatement(); // 获得执行sql的对象 Statement
      String sql = "UPDATE users SET `name`='Jamesssssss',`password`='4970579809375' where id=1";
      int count = st.executeUpdate(sql);
      if (count > 0) {
        System.out.println("更新成功");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JdbcUtils.release(connection, st, null);
    }
  }
}
