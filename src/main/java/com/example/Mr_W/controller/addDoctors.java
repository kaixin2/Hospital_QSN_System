package com.example.Mr_W.controller;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.Mr_W.db.doctorDao;

/**
 * Servlet implementation class docrorexpense
 */
@WebServlet("/addDoctors")
public class addDoctors extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public addDoctors() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String type=request.getParameter("searchType");
        String type1=request.getParameter("type1");
        if("2".equals(type1)) {
            type = "药房";
        }
        request.setAttribute("listId",request.getParameter("listId"));
        request.setAttribute("type1",type1);
        request.setAttribute("type2",request.getParameter("type2"));
        request.setAttribute("date",request.getParameter("date"));
        doctorDao doctorDao=new doctorDao();
        request.setAttribute("doctorList",doctorDao.getNameByType(type));
        request.getRequestDispatcher("resources/Mr_W/addDoctor.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
