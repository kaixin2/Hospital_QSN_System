package com.example.Mr_W.controller;

import com.example.Mr_W.db.expenseDao;
import com.example.Mr_W.db.patientInformationDao;
import com.example.Mr_W.db.registrationDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/addRegistration")
public class addRegistrationServlet extends HttpServlet {
    public String getStringAddOne(String num,int length){
        int temp=Integer.parseInt(num)+1;
        StringBuilder s= new StringBuilder(temp + "");
        int count=0;
        while (temp>0){
            temp=temp/10;
            count++;
        }
        count=length-count;
        while (count>0) {
            s.insert(0, "0");
            count--;
        }
        return s.toString();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String doctorId=request.getParameter("doctor");
        String type1=request.getParameter("type1");
        String type2=request.getParameter("type2");
        String listId=null;
        HttpSession session=request.getSession();
        if("2".equals(type1))
            listId=request.getParameter("listId");

        String date=request.getParameter("date");

        registrationDao dao=new registrationDao();
        expenseDao expenseDao=new expenseDao();
        patientInformationDao patientInformationDao=new patientInformationDao();
        String registrationId=dao.getLastRegistrationId();
        String[] s=registrationId.split(" ");
        registrationId=getStringAddOne(s[0],7);
        dao.insertRegistration(registrationId,listId,type2,doctorId,date,10,"0");

        String expenseId=expenseDao.getLastExpenseId();
        s=expenseId.split(" ");
        expenseId=getStringAddOne(s[0],5);
        expenseDao.insertExpense(expenseId,registrationId,"0");

        String patientInformationId=patientInformationDao.getLastPatientInformationId();
        s=patientInformationId.split(" ");
        patientInformationId=getStringAddOne(s[0],4);
        if("2".equals(type1))
            patientInformationDao.insertPatientInformation(patientInformationId,session.getAttribute("login").toString(),registrationId,expenseId,listId);
        else
            patientInformationDao.insertPatientInformation(patientInformationId,session.getAttribute("login").toString(),registrationId,expenseId,null);
        request.getRequestDispatcher("payInformation").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
