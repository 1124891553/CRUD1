package com.gd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gd.bean.User;
import com.gd.service.UserService;
import com.gd.service.UserServiceImpl;

public class UpdateUserServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        if ((String) session.getAttribute("userid") == null) {
            response.sendRedirect("/CRUD1/login.jsp");
            return;
        }
        int id = (Integer) session.getAttribute("id");
        session.removeAttribute("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String birthday = request.getParameter("birthday");
        UserService userServie = new UserServiceImpl();
        User user = new User();
        user = userServie.selectOne(id);
        request.setAttribute("user", user);

        userServie.updateUserById(id, username, password, birthday);

        response.sendRedirect("AllUserServlet");
//		request.getRequestDispatcher("/AllUserServlet").forward(request, response);
    }

}
