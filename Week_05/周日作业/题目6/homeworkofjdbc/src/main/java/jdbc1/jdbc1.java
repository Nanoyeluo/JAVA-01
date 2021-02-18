package jdbc1;

import java.sql.*;

/**
 * @author Nano
 * @ClassName jdbc1
 * @Description TODO
 * @Date 2021/2/15 14:38
 * @Version 1.0
 **/
public class jdbc1 {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/demo";
    static final String USER = "root";
    static final String PASS = "123456";

    public static void main(String[] args) {
        doQuerySql();
        doAddSql();
        doQuerySql();
        doUpdateSql();
        doQuerySql();
        doDeteleSql();
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

    static void doAddSql() {
        System.out.println("2.开始做添加操作");
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            try (Statement statement = conn.createStatement()) {
                String sql = "insert into users values(2,'xxxx',3000)";
                int i = statement.executeUpdate(sql);
                if (i > 0) {
                    System.out.println("添加成功");
                } else {
                    System.out.println("添加失败");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("2.结束");
    }

    static void doUpdateSql() {
        System.out.println("3.开始做修改操作");
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            try (Statement statement = conn.createStatement()) {
                String sql = "update users set username = 'ffff' where  id = 1";
                int i = statement.executeUpdate(sql);
                if (i > 0) {
                    System.out.println("修改成功");
                } else {
                    System.out.println("修改失败");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("3.结束");
    }

    static void doDeteleSql() {
        System.out.println("4.开始做删除操作");
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            try (Statement statement = conn.createStatement()) {
                String sql = "delete from users where username = 'xxxx'";
                int i = statement.executeUpdate(sql);
                if (i > 0) {
                    System.out.println("删除成功");
                } else {
                    System.out.println("删除失败");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("4.结束");
    }
}
