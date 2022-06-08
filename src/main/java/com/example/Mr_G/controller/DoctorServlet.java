package com.example.Mr_G.controller;

import com.example.Mr_G.Dao.DoctorDao;
import com.example.Mr_G.Dao.PatientDao;
import com.example.Mr_G.model.Doctor;
import com.example.Mr_G.model.Patient;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/DoctorServlet")
public class DoctorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.find(request, response);
    }

    private void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Doctor infor = new Doctor();
        DoctorDao dao = new DoctorDao();
        List<Doctor> list = dao.query();
        request.setAttribute("allInfor", list);
        String path = "/doctor.jsp";
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDistpatcher = request.getRequestDispatcher(path);
        requestDistpatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
