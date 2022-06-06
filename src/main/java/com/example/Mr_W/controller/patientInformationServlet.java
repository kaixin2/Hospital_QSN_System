package com.example.Mr_W.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


import com.example.Mr_W.db.registrationDao;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/registrationInformation")
public class patientInformationServlet extends HttpServlet {
    /**
     *
     * @param request
     * @param response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    	registrationDao dao=new registrationDao();
        HttpSession session=request.getSession();
    	request.setAttribute("registrationInfor",dao.getALLRegistrationInformationByPatientId(session.getAttribute("login").toString()) );
        int sum=0;
        String id=dao.getRegistrationByPatientId(session.getAttribute("login").toString());
        if(dao.getQueueById(id)!=null) {
            for (String s : dao.getQueueById(id)) {
                if (s.equals(id))
                    sum++;
            }
        }
    	request.setAttribute("sum", sum);
        String temp="";
        if(session.getAttribute("queue")!=null)
            temp=session.getAttribute("queue").toString();
        if(temp.equals(session.getAttribute("login").toString()))
            request.setAttribute("queue","是");
        else
    	    request.setAttribute("queue", "否");
        request.getRequestDispatcher("resources/Mr_W/registrationInformation.jsp").forward(request, response);
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
