package com.mysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

import static java.lang.String.format;

/**
 * @description:TODO
 * @author:zyg
 * @time:2021/5/6 下午 9:37
 */
public class MyJdbc {
    private final static Logger log = LoggerFactory.getLogger(MyJdbc.class);
    public static void main(String[] args) {
        Connection con = getConnections("root", "root");
        query(con);
        update(con);
        query(con);
        releaseConections(con);
    }

    private static void query(Connection con) {
        String sql = "select * from dbshop_region_extend";
        Statement st = null;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println("regionId:" + rs.getString("region_id") + "\t" +
                                   "regionName:" + rs.getString("region_name") + "\t" +
                                   "language:" + rs.getString("language"));
            }
            System.out.println("===================================================");
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            log.info("SQLException:{}", throwables.getMessage());
        }
    }

    private static void update(Connection con) {
        String sql = "update dbshop_region_extend set region_name = '合肥' where region_id = 1";
        Statement st = null;
        try {
            st = con.createStatement();
            int count = st.executeUpdate(sql);
            System.out.printf("更新了%s行数据" + "\n", count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            log.info("SQLException:{}", throwables.getMessage());
        }
    }

    private static void releaseConections(Connection con) {
        if (con != null) {
            try {
                con.close(); // 关闭连接
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                log.info("SQLException:{}", throwables.getMessage());
            }
        }
    }

    private static Connection getConnections(String user, String pwd) {
        Connection con = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/dbshop?useUnicode=true&characteEncoding=UTF-8";
        try {
            Class.forName(driver); // 建立启动
            con = DriverManager.getConnection(url, user, pwd); // 建立连接
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            log.info("ClassNotFoundException:{}", e.getMessage());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            log.info("SQLException:{}", throwables.getMessage());
        }
        return con;
    }
}
