package jdbc2;

import java.sql.*;

/**
 * @author Nano
 * @ClassName jdbc1
 * @Description TODO
 * @Date 2021/2/15 14:38
 * @Version 1.0
 **/
public class jdbc2 {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/demo";
    static final String USER = "root";
    static final String PASS = "123456";

    public static void main(String[] args) {
        doQuerySql();
        doTradicationalSql();
        doQuerySql();
        doPrepareStatementSql();
        doQuerySql();
        doBatchSql();
        doQuerySql();
    }

    static void doQuerySql() {
        System.out.println("1.开始做查询");
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
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
    }

    static void doTradicationalSql() {
        System.out.println("2.开始做事务操作");
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            conn.setAutoCommit(false);
            try (Statement statement = conn.createStatement()) {
                String sql = "insert into users values(2,'xxxx',3000)";
                int i = statement.executeUpdate(sql);
                if (i > 0) {
                    System.out.println("添加成功");
                } else {
                    System.out.println("添加失败");
                }
            }
            System.out.println("回滚了");
            conn.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("2.结束");
    }

    static void doPrepareStatementSql() {
        System.out.println("3.开始做预处理操作");
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "insert into users values(?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "xxxx");
            preparedStatement.setString(3, "3000");
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("3.结束");
    }

    static void doBatchSql() {
        System.out.println("4.开始做批量操作");
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            conn.setAutoCommit(false);
            String sql = "insert into users values(?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            for (int i = 3; i < 5; i++) {

                preparedStatement.setInt(1, i);
                preparedStatement.setString(2, "xxxx");
                preparedStatement.setString(3, "3000");
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            preparedStatement.clearBatch();
            conn.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("3.结束");
    }
}
