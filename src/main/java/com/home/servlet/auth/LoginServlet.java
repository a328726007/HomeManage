package com.home.servlet.auth;

import com.home.entity.User;
import com.home.service.UserService;
import com.home.service.impl.UserServiceImpl;
import com.home.util.ThymeleafUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.Console;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserService userService;
    @Override
    public void init() throws ServletException{
        userService = new UserServiceImpl();
    }

    @Override
    protected void  doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html");
        Context context = new Context();
        if(req.getSession().getAttribute("login-failure")!=null){
            context.setVariable("failure",true);
            req.getSession().removeAttribute("login-failure");
        }
        if(req.getSession().getAttribute("user")!=null){
            resp.sendRedirect(req.getContextPath()+"/index");
            return;
        }
        ThymeleafUtil.process("login.html",context,resp.getWriter());
    }
    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        resp.setContentType("text/html");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember-me");
        if(userService.auth(username,password,req.getSession())){
            resp.sendRedirect(req.getContextPath()+"/index");
        }else{
            req.getSession().setAttribute("login-failure", new Object());
            this.doGet(req,resp);
        }
    }
}
