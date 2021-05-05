package mysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class QueryAndInsert {

    private final static Logger log = LoggerFactory.getLogger(QueryAndInsert.class);
    public static void main(String[] args) {
        // 查询
        Connection connection = getConnections("root", "root");
        query(connection);
        System.out.println("-------------------------------------------");
        // 插入 + 查询
        insert(connection);
        query(connection);
        releaseConnection(connection);
    }

    private static void insert(Connection connection) {
        String sql = "insert into dbshop_stock_state_extend(stock_state_id, stock_state_name, language) values('4', 'mid goods', 'japan')";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            int count = statement.executeUpdate(sql);
            log.info("插入几条数据:{}", count);
            if (statement != null) {
                statement.close();
                log.info("关闭声明");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            log.info("sql异常:{}", throwables.getMessage());
        }
    }

    private static void query(Connection connection) {
        String sql = "select * from dbshop_stock_state_extend";
        Statement statement = null;
        try {
            // 创建记录集
            statement = connection.createStatement();
            // 创建结果集
            ResultSet resultSet = statement.executeQuery(sql);
            // 遍历
            while (resultSet.next()) {
                System.out.println("id:" + resultSet.getString("stock_state_id") + "\t" +
                                   "name:" + resultSet.getString("stock_state_name") + "\t" +
                                   "language:" + resultSet.getString("language"));
            }
            if (resultSet != null) {
                resultSet.close();
                log.info("关闭记录表");
            }
            if (statement != null) {
                statement.close();
                log.info("关闭声明");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            log.info("sql异常:{}", throwables.getMessage());
        }
    }

    public static Connection getConnections(String user, String pwd) {
        Connection connection = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/dbshop?useUnicode=ture$characterEncoding=UTF-8";
        try {
            // 加载驱动
            Class.forName(driver);
            // 建立连接
            connection = DriverManager.getConnection(url, user, pwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            log.info("数据库驱动没有安装");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            log.info("数据库连接异常", throwables.getMessage());
        }
        return connection;
    }

    public static void releaseConnection(Connection connection) {
        // 关闭连接
        if (connection != null) {
            try {
                connection.close();
                log.info("关闭连接");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                log.info("释放数据库连接异常", throwables.getMessage());
            }
        }
    }
}
