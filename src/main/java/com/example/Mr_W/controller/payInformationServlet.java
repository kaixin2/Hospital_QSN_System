package com.example.Mr_W.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.Mr_W.db.expenseDao;
import com.example.Mr_W.model.expense;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/payInformation")
public class payInformationServlet extends HttpServlet {
	/**
	 *
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		if(id==null)
			id="";
		HttpSession session=request.getSession();
		expenseDao expenseDao=new expenseDao();
		request.setAttribute("expense",expenseDao.getExpenseById((String) session.getAttribute("login")));
		request.getRequestDispatcher("resources/Mr_W/payInformation.jsp?id="+id).forward(request, response);
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
