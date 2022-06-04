package com.example.Mr_W.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.Mr_W.model.registration;

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
    	registration information=new registration();
    	information.setId("0000001");
    	information.setDoctor("����");
    	information.setListID("����");
    	information.setpType("��ͨ");
    	information.setpTime("2022-05-31");
    	information.setSign("δ���");
    	information.setCosts(10);
    	registration information1=new registration();
    	information1.setId("0000001");
    	information1.setDoctor("����");
    	information1.setListID("����");
    	information1.setpType("����");
    	information1.setpTime("2022-05-29");
    	information1.setSign("���");
    	information1.setCosts(10);
    	List<registration> list=new ArrayList<registration>();
    	list.add(information);
    	list.add(information1);
  
    	request.setAttribute("registrationInfor", list);
    	request.setAttribute("sum", 1);
    	request.setAttribute("queue", "δ��");
        request.getRequestDispatcher("/registrationInformation.jsp").forward(request, response);
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
