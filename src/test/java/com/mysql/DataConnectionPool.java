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
// 依赖两个jar包,c3p0 + mchange-commons-java
// 配置文件名字不要改 + configName不要改,要一样
public class DataConnectionPool {
    public static void main(String[] args) {
        try {
            // 数据库连接池对象
            ComboPooledDataSource cpds = new ComboPooledDataSource("c3p0"); // 填写configName=配置文件的configName---->即通过配置文件加载数据库连接池,
            /*cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
            cpds.setJdbcUrl("jdbc:mysql://localhost:3306/dbshop?useUnicode=true&characteEncoding=UTF-8");
            cpds.setUser("root");
            cpds.setPassword("root");
            cpds.setInitialPoolSize(20);
            cpds.setMaxPoolSize(40);
            cpds.setAcquireIncrement(5);
            cpds.setMinPoolSize(2);*/

            Connection con = cpds.getConnection();
            System.out.println("连接对象---------->" + con);
            con.close(); // 释放到连接池 另外一种是扔掉了
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

