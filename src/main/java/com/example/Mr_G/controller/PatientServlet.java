package com.example.Mr_G.controller;

import com.example.Mr_G.Dao.PatientDao;
import com.example.Mr_G.model.Patient;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/PatientServlet")
public class PatientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.find(request, response);
    }

    private void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Patient infor = new Patient();
        PatientDao dao = new PatientDao();
        List<Patient> list = dao.query();
        request.setAttribute("allInfor", list);
        String path = "/patient.jsp";
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDistpatcher = request.getRequestDispatcher(path);
        requestDistpatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
