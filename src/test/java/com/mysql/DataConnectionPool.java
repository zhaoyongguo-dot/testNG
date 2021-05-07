package com.mysql;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @description:TODO
 * @author:zyg
 * @time:2021/5/8 上午 12:48
 */
public class DataConnectionPool {
    public static void main(String[] args) {
        // 数据库连接池对象
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        try {
            cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
            cpds.setJdbcUrl("jdbc:mysql://localhost:3306/dbshop?useUnicode=true&characteEncoding=UTF-8");
            cpds.setUser("root");
            cpds.setPassword("root");
            cpds.setInitialPoolSize(20);
            cpds.setMaxPoolSize(40);
            cpds.setAcquireIncrement(5);
            cpds.setMinPoolSize(2);
            Connection con = cpds.getConnection();
            con.close(); // 释放到连接池 另外一种是扔掉了
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}

