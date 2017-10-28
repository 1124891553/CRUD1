package com.gd.utils;

import java.util.List;

import com.gd.bean.User;
import com.gd.service.UserService;
import com.gd.service.UserServiceImpl;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        UserService userServie = new UserServiceImpl();
        List<User> allUser = userServie.selectAll();
        for (User user : allUser) {
            System.out.println("id=" + user.getId());
            System.out.println("username=" + user.getUsername());
            System.out.println("brithday=" + user.getBirthday());
        }
    }

}
