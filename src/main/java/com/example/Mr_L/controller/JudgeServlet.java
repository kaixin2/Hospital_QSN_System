package com.example.Mr_L.controller;

import com.example.Mr_L.db.DoctorDao;
import com.example.Mr_L.db.RegistDao;
import com.example.Mr_L.model.Doctor;
import com.example.Mr_L.model.Regist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/JudgeServlet")
public class JudgeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String s="2001";
        RegistDao registDao =new RegistDao();
       if(session.getAttribute("que")!=null){
           String id=(String)session.getAttribute("que");

           List<Regist> list2=registDao.findFinish(s,id);
           request.setAttribute("list2",list2);
       }
       else{
           List<Regist> list2=registDao.findAll(s);
           request.setAttribute("list2",list2);
       }
        request.getRequestDispatcher("resources/Mr_L/regist.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
