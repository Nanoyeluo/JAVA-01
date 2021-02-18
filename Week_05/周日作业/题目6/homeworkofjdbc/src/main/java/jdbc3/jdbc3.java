package jdbc3;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;

/**
 * @author Nano
 * @ClassName jdbc1
 * @Description TODO
 * @Date 2021/2/15 14:38
 * @Version 1.0
 **/
public class jdbc3 {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/demo";
    static final String USER = "root";
    static final String PASS = "123456";

    public static void main(String[] args) {
        doQuerySql();
    }

    static void doQuerySql() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(JDBC_DRIVER);
        dataSource.setJdbcUrl(DB_URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASS);

        System.out.println("1.开始做查询");
        try (Connection conn = dataSource.getConnection()) {
            try (Statement statement = conn.createStatement()) {
                String sql = "select * from users";
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("Id");
                        String username = resultSet.getString("username");
                        String password = resultSet.getString("password");
                        System.out.println(id + "------" + username + "------" + password);
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("1.结束");
        dataSource.close();
    }


}
