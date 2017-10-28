package com.gd.service;

import java.util.List;

import com.gd.bean.User;

public interface UserService {
    public List<User> selectAll();

    public List<User> selectListByuserName(String username);

    public User selectOne(int id);

    public void InsertUser(String username, String password, String birthday);

    public void deleteUserById(int id);

    public void updateUserById(int id, String username, String password, String birthday);

}
