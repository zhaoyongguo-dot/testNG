package com.mysql;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import javax.sql.CommonDataSource;
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
        //query(con);
        //update(con);
        query3(con);
        releaseConections(con);
    }

    @Test(enabled = false)
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

    // PreparedStatement提供占位符,防止sql注入 + 不用拼接
    private static void query2(Connection con) {
        String region_id = "1'or'1'='1";
        String region_name = "蚌埠'or'1'='1";
        String sql = "select * from dbshop_region_extend where region_id = ? and region_name = ?;";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql); // prepareStatement中就可以插入sql
            ps.setNString(1, region_id);
            ps.setNString(2, region_name);
            System.out.println(sql);
            ResultSet rs = ps.executeQuery(); // ResultSet中执行sql
            if (rs.next()) {
                log.info("登录成功！---》" + rs.getString("region_id") + "\t" + rs.getString("region_name"));
            } else {
                log.info("登录失败！---》" + rs.getString("region_id") + "\t" + rs.getString("region_name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // Statement不提供占位符,要拼接 + 可以sql注入
    private static void query3(Connection con) {
        String region_id = "12'or'1'='1";
        String region_name = "蚌埠2'or'1'='1";
        String sql = "select * from dbshop_region_extend where region_id = '"+region_id+"' and region_name = '"+region_name+"'";
        Statement ps = null;
        try {
            ps = con.createStatement();
            System.out.println(sql);
            ResultSet rs = ps.executeQuery(sql); // ResultSet中插入sql并执行
            if (rs.next()) {
                log.info("登录成功！---》" + rs.getString("region_id") + "\t" + rs.getString("region_name"));
            } else {
                log.info("登录失败！---》" + rs.getString("region_id") + "\t" + rs.getString("region_name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
