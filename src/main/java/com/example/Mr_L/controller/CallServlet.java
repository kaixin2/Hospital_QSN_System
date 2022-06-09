package com.example.Mr_L.controller;

import com.example.Mr_L.db.RegistDao;
import com.example.Mr_L.model.Regist;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/CallServlet")
public class CallServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ss=request.getParameter("idname1");
        HttpSession session=request.getSession();
        String id=(String) session.getAttribute("id");

        RegistDao registDao =new RegistDao();
        if(registDao.Judge(id,ss)) {
            session.setAttribute("queue",ss);

            request.getRequestDispatcher("/RegistServlet").forward(request, response);
        }
        else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script>alert('该单号不存在');window.location.href='RegistServlet'</script>");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
