package com.gd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gd.bean.User;
import com.gd.utils.DBUtils;

public class UserDaoImpl implements UserDao {

    @Override
    public List<User> selectAll() {
        // TODO Auto-generated method stub
        DBUtils utils = new DBUtils();
        Connection conn = utils.getConn();

        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from users";

        List<User> allUser = new ArrayList<User>();

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setBirthday(rs.getDate("birthday"));
                allUser.add(user);
            }
            return allUser;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            utils.closeI(rs, ps, conn);
        }

        return null;
    }

    public User selectOne(int id) {
        // TODO Auto-generated method stub
        DBUtils utils = new DBUtils();
        Connection conn = utils.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from users where id =?";
        User user = new User();
        try {
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setBirthday(rs.getDate("birthday"));
                return user;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            utils.closeI(rs, ps, conn);
        }
        return null;
    }

    public List<User> selectListByuserName(String username) {
        DBUtils utils = new DBUtils();
        Connection conn = utils.getConn();

        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from users where username=?";

        List<User> allUser = new ArrayList<User>();

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setBirthday(rs.getDate("birthday"));
                allUser.add(user);
            }
            return allUser;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            utils.closeI(rs, ps, conn);
        }

        return null;

    }

    public void InsertUser(String username, String password, String birthday) {
        DBUtils utils = new DBUtils();
        Connection conn = utils.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "insert into users (username,password,birthday) values (?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, birthday);
            ps.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            utils.closeI(rs, ps, conn);
        }
    }

    @Override
    public void deleteUserById(int id) {
        // TODO Auto-generated method stub
        DBUtils utils = new DBUtils();
        Connection conn = utils.getConn();

        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "delete from users where id = ?";


        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            utils.closeI(rs, ps, conn);
        }

    }

    public void updateUserById(int id, String username, String password, String birthday) {
        // TODO Auto-generated method stub
        DBUtils utils = new DBUtils();
        Connection conn = utils.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "update users set username=?,password=?,birthday=? where id=? ";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, birthday);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            utils.closeI(rs, ps, conn);
        }

    }

}
