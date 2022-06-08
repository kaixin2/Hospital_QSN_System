package com.example.Mr_W.controller;

import com.example.Mr_W.db.registrationDao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class revocationServlet
 */
@WebServlet("/signIn")
public class signInServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public signInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        registrationDao dao=new registrationDao();
        HttpSession session=request.getSession();

        if(session.getAttribute("queue")!=null) {
            dao.updateFinishSign(session.getAttribute("queue").toString());
            session.setAttribute("que",session.getAttribute("queue"));
            session.removeAttribute("queue");
        }
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
