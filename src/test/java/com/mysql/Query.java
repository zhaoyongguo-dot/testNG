package com.mysql;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description:TODO
 * @author:zyg
 * @time:2021/5/8 上午 12:50
 */
public class Query {
    public static void main(String[] args) {
        Region region = query4();
        System.out.println(region);
    }

    // 查询封装
    private static Region query4() {
        ComboPooledDataSource cds = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Region region = null;
        try {
            cds = new ComboPooledDataSource();
            con = cds.getConnection();
            String sql = "select * from dbshop_region_extend where region_id = ? and region_name = ? and language = ?;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer regionId = rs.getInt(1);
                String regionName = rs.getString(2);
                String language = rs.getString(3);
                region = new Region(regionId, regionName, language);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return region;
    }
}
