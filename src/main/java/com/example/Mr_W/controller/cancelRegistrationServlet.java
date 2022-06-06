package com.example.Mr_W.controller;

import com.example.Mr_W.db.expenseDao;
import com.example.Mr_W.db.registrationDao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class docrorexpense
 */
@WebServlet("/cancelRegistration")
public class cancelRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public cancelRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String id=request.getParameter("id");
        registrationDao registrationDao=new registrationDao();
        registrationDao.updateCancelSign(id);
        expenseDao expenseDao=new expenseDao();
        expenseDao.updateCancelSign(id);
        request.getRequestDispatcher("registrationInformation").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}

