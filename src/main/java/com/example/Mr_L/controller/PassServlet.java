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
import java.util.List;

@WebServlet("/PassServlet")
public class PassServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ss=request.getParameter("idname");

        HttpSession session=request.getSession();
        String id=(String) session.getAttribute("id");
        RegistDao registDao =new RegistDao();
        List<Regist> list2=registDao.findRegist(id,ss);
        request.setAttribute("list2",list2);
        request.getRequestDispatcher("resources/Mr_L/regist.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
