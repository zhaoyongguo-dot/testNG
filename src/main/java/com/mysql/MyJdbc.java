package com.mysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyJdbc {

    private final static Logger log = LoggerFactory.getLogger(MyJdbc.class);
    public static void main(String[] args) {
        Connection con = null;
        // JDBC驱动
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/dbshop";
        String user = "root";
        String pwd = "root";
        try {
            // 注册驱动
            Class.forName(driver);
            // 建立连接
            con = DriverManager.getConnection(url,user, pwd);
            if (!con.isClosed()) {
                log.info("database connect ok");
            }
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            log.info("database driver is not install:{}", e.getMessage());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            log.info("database connect err:{}", throwables.getMessage());
        }
    }
}
