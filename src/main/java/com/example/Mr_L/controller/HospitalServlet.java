package com.example.Mr_L.controller;

import com.example.Mr_L.db.DoctorDao;
import com.example.Mr_L.model.Doctor;


import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

@WebServlet("/HospitalServlet")
public class HospitalServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session=request.getSession();
        String s="2001";
        session.setAttribute("id",s);
        String id=(String) session.getAttribute("id");
        DoctorDao doctorDao=new DoctorDao();
        List<Doctor>list1=doctorDao.findAll(id);
        request.setAttribute("list1",list1);


        request.getRequestDispatcher("resources/Mr_L/Doctorinformation.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
