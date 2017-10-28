package com.gd.dao;

import java.util.List;

import com.gd.bean.User;

public interface UserDao {
    //查找所有的用户
    public List<User> selectAll();

    public User selectOne(int id);

    public List<User> selectListByuserName(String username);

    public void InsertUser(String username, String password, String birthday);

    //删除用户
    public void deleteUserById(int id);

    public void updateUserById(int id, String username, String password, String birthday);
}
