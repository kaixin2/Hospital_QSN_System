package com.example.Mr_W.controller;

import com.example.Mr_W.db.patientDao;
import com.example.Mr_W.model.patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/welcome")
public class welcomeServlet extends HttpServlet {
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        patientDao patientDao=new patientDao();
        request.setAttribute("login",patientDao.getPatientByAccount("123"));
        HttpSession session= request.getSession();
        session.setAttribute("login",patientDao.getPatientIdByAccount("123"));
        request.getRequestDispatcher("resources/Mr_W/patientHome.jsp").forward(request, response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
