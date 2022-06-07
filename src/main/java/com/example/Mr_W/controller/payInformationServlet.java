package com.example.Mr_W.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.Mr_W.db.expenseDao;


import java.io.IOException;


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

		String payId=request.getParameter("payId");
		if(payId==null) {
			request.setAttribute("payId", "");
		}else {
			request.setAttribute("payId",payId);
		}

		String error=request.getParameter("error");
		if(error==null || "".equals(error))
			error="";
		request.setCharacterEncoding("utf-8");
		request.setAttribute("error",error);

		HttpSession session=request.getSession();
		expenseDao expenseDao=new expenseDao();
		String sign="";
		if(expenseDao.isPay(payId)){
			sign="0";
		}else sign="1";
			request.setAttribute("sign",sign);
		request.setAttribute("expense",expenseDao.getExpenseById(session.getAttribute("login").toString()));
		request.getRequestDispatcher("resources/Mr_W/payInformation.jsp?id="+id+"&&sign="+sign).forward(request, response);
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
