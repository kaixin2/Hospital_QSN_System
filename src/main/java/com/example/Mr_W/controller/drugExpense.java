package com.example.Mr_W.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.Mr_W.model.medicine;
import com.example.Mr_W.model.drug;

/**
 * Servlet implementation class drugExpense
 */
@WebServlet("/drugExpense")
public class drugExpense extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public drugExpense() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		medicine medicine=new medicine();
		medicine.setId(id);
		drug drug=new drug();
		drug.setName("�޺�ù��");
		medicine.setDrug(drug);
		medicine.setCost(100.0);
		medicine.setNum(2);
		request.setAttribute("expenseDetail", medicine);
		request.getRequestDispatcher("/payInformation?id=2").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
