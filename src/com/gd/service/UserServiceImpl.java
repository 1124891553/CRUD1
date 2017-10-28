package com.gd.service;

import java.util.List;

import com.gd.bean.User;
import com.gd.dao.UserDao;
import com.gd.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {

    @Override
    public List<User> selectAll() {
        // TODO Auto-generated method stub
        UserDao userDao = new UserDaoImpl();
        List<User> allUser = userDao.selectAll();

        return allUser;
    }

    public List<User> selectListByuserName(String username) {
        UserDao userDao = new UserDaoImpl();
        List<User> allUser = userDao.selectListByuserName(username);
        return allUser;
    }

    public User selectOne(int id) {
        // TODO Auto-generated method stub
        UserDao userDao = new UserDaoImpl();
        User user = userDao.selectOne(id);

        return user;
    }

    public void InsertUser(String username, String password, String birthday) {
        UserDao userDao = new UserDaoImpl();
        userDao.InsertUser(username, password, birthday);
    }

    @Override
    public void deleteUserById(int id) {
        // TODO Auto-generated method stub
        UserDao userDao = new UserDaoImpl();
        userDao.deleteUserById(id);
    }

    public void updateUserById(int id, String username, String password, String birthday) {
        // TODO Auto-generated method stub
        UserDao userDao = new UserDaoImpl();
        userDao.updateUserById(id, username, password, birthday);
    }

}
