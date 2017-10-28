package com.gd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gd.bean.User;
import com.gd.service.UserService;
import com.gd.service.UserServiceImpl;

public class OneUserServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if ((String) session.getAttribute("userid") == null) {
            response.sendRedirect("/CRUD1/login.jsp");
            return;
        }
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int id = Integer.parseInt(request.getParameter("id"));

        session.setAttribute("id", id);
        UserService userServie = new UserServiceImpl();
        User user = new User();
        user = userServie.selectOne(id);


        request.setAttribute("userone", user);
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }

}
