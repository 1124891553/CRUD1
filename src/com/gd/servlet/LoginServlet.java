package com.gd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gd.bean.User;
import com.gd.service.UserService;
import com.gd.service.UserServiceImpl;

public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        try {
            HttpSession session = request.getSession();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            PrintWriter out = response.getWriter();
            UserService userServie = new UserServiceImpl();
            List<User> allUser = userServie.selectListByuserName(username);
            String pass = "";
            for (User user : allUser) {
                pass = user.getPassword();
            }
            if (password != "" && pass != null && password.equals(pass)) {
                session.setAttribute("userid", username);
                response.sendRedirect("AllUserServlet");
            } else {
                out.println("<center><font color='red'>用户名或密码错误!</font><a href='#' onclick='history.back();'>返回</a></center>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errMsg", "登录出错！");
            this.getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
            return;
        }
    }

}
