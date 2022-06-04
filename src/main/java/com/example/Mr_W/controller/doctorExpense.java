package com.example.Mr_W.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.Mr_W.model.registration;

/**
 * Servlet implementation class docrorexpense
 */
@WebServlet("/doctorExpense")
public class doctorExpense extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doctorExpense() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		registration registration=new registration();
		registration.setId(id);
		registration.setDoctor("����");
		registration.setCourse("�Կ�");
		registration.setCosts(30);
		request.setAttribute("expenseDetail", registration);
		request.getRequestDispatcher("/payInformation?id=1").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
