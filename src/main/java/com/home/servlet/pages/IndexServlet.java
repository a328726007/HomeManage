package com.home.servlet.pages;

import com.home.entity.User;
import com.home.service.StoreService;
import com.home.service.impl.StoreServcieImpl;
import com.home.util.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import java.io.IOException;


@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    StoreService storeService;
    @Override
    public void init()throws ServletException{
        storeService = new StoreServcieImpl();
    }
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        Context context= new Context();
        User user = (User) req.getSession().getAttribute("user");
        context.setVariable("nickname",user.getNickname());
        context.setVariable("store_list",storeService.getBorrowList());
        ThymeleafUtil.process("index.html",context,  resp.getWriter());
    }
}
