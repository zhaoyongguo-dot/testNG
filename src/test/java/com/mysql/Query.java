package com.mysql;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:TODO
 * @author:zyg
 * @time:2021/5/8 上午 12:50
 */
public class Query {
    static  ComboPooledDataSource cpds = null;
    static {
        cpds = new ComboPooledDataSource("c3p0");
    }

    public static void main(String[] args) {
        /*Query query = new Query();
        List<EntityRegion> list = query.findAll();
        System.out.println("list----->" + list);*/

        EntityRegion entityRegion = findByDBUtils(3, "上海");
        System.out.println("entityRegion----->" + entityRegion);
    }

    public static EntityRegion findByDBUtils(Integer regionId, String regName) {
        Connection con = null;
        EntityRegion entityRegion = null;
        try {
            con = cpds.getConnection();
            String sql = "select * from dbshop_region_extend where region_id = ? or region_name = ?;";
            QueryRunner queryRunner = new QueryRunner();
            entityRegion = queryRunner.query(con, sql, new BeanHandler<>(EntityRegion.class), regionId, regName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
                cpds.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return entityRegion;
    }

    // 查询封装
    public List<EntityRegion> findAll() {
        List<EntityRegion> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        EntityRegion entityRegion = null;
        try {
            con = cpds.getConnection();
            String sql = "select * from dbshop_region_extend;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer region_id = rs.getInt(1);
                String region_name = rs.getString(2);
                String language = rs.getString(3);
                entityRegion = new EntityRegion(region_id, region_name, language);
                list.add(entityRegion);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
                cpds.close();
                ps.close();
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return list;
    }
}
