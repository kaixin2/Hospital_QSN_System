package com.example.Mr_L.controller;

import com.example.Mr_L.db.RegistDao;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/CallServlet")
public class CallServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String RegistId=request.getParameter("idname1");

        HttpSession session=request.getSession();
        session.setAttribute("queue",RegistId);
        request.getRequestDispatcher("/Hospital_QSN_System_war_exploded/RegistServlet").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
