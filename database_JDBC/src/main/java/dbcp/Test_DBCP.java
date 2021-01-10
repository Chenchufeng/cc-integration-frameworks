package dbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Test_DBCP {
  public static void main(String[] args) {
    Connection connection = null;
    PreparedStatement st = null;
    try {
      connection = JdbcUtils_DBCP.getConnection(); // 获取数据库连接
      // 使用 ？占位符代替参数
      // 防止sql注入的本质，把传进来的参数当做字符
      String sql =
          "insert into users(`id`,`name`,`password`,`email`,`birthday`)" + "VALUES(?,?,?,?,?)";
      st = connection.prepareStatement(sql); // 预编译sql,先写sql，然后不执行
      // 手动给参数赋值
      st.setInt(1, 10);
      st.setString(2, "christian");
      st.setString(3, "66666666");
      st.setString(4, "437121948@qq.com");
      st.setDate(5, new java.sql.Date(new Date().getTime()));
      int count = st.executeUpdate();
      if (count > 0) {
        System.out.println("插入成功!");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JdbcUtils_DBCP.release(connection, st, null);
    }
  }
}
