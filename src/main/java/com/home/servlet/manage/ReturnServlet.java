package com.home.servlet.manage;

import com.home.service.StoreService;
import com.home.service.impl.StoreServcieImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/return-book")
public class ReturnServlet extends HttpServlet {

    StoreService storeService;
    @Override
    public void init()throws ServletException{
        storeService = new StoreServcieImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String id = req.getParameter("id");
         storeService.deleteBorrow(id);
         resp.sendRedirect("index");
    }
}
