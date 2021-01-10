package jdbc;

import java.sql.*;

public class Myconnect {
  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    // 1.加载驱动
    /**
     * //DriverManager.registerDriver(new com.mysql.jdbc.Driver()); 不用此方法，因为会注册两次驱动
     * 因为静态代码块中已经静态生成了一个驱动对象并使用DriverManager.registerDriver注册了，所以上面两种都是浪费。使用forName后，可以使用DriverManager.getConnection来获取数据库连接对象。
     */
    Class.forName("com.mysql.jdbc.Driver");
    // 2.创建连接，连接数据库 DriverManager
    String url =
        "jdbc:mysql://localhost:3306/jdbc_study?useUnicode=true&characterEncoding=utf8&useSSL=true";
    String username = "root";
    String password = "12345678";
    // 连接成功，数据库对象，connection代表数据库,可以设置数据库自动提交，事务提交，事务回滚
    Connection connection = DriverManager.getConnection(url, username, password);
    // 3.获得执行sql的对象 Statement
    Statement statement = connection.createStatement();
    // 4.获得返回的结果集，只有查询才有结果集
    String sql = "SELECT * from users";
    ResultSet resultSet = statement.executeQuery(sql); // 查询操作返回resultset
    while (resultSet.next()) {
      System.out.println("id=" + resultSet.getObject("id"));
      System.out.println("name=" + resultSet.getObject("name"));
      System.out.println("password=" + resultSet.getObject("password"));
      System.out.println("email=" + resultSet.getObject("email"));
      System.out.println("birthday=" + resultSet.getObject("birthday"));
      System.out.println("=============================================");
    }
    // 5.释放连接
    resultSet.close();
    statement.close();
    connection.close(); // 耗资源，用完关掉
  }
}
