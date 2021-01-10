package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utils.JdbcUtils;

public class TestQuery {
  public static void main(String[] args) {
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    try {
      conn = JdbcUtils.getConnection();
      st = conn.createStatement();
      String sql = "select * from users where id=1";
      rs = st.executeQuery(sql);
      while (rs.next()) {
        System.out.println(rs.getString("name"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JdbcUtils.release(conn, st, rs);
    }
  }
}
