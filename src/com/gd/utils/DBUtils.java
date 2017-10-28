package com.gd.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtils {

    public Connection getConn() {
        String classname = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mybitis?characterEncoding=utf-8";
        String user = "root";
        String password = "123456";

        Connection conn = null;
        try {
            Class.forName(classname);
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return null;
    }

    public void closeI(ResultSet rs, PreparedStatement ps, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e2) {
            // TODO: handle exception
        }
    }
}
