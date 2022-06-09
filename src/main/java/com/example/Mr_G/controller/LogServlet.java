package com.example.Mr_G.controller;

import com.example.Mr_G.Dao.LogDao;
import com.example.Mr_G.model.Log;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/LogServlet")
public class LogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String temp = request.getParameter("temp");
        if("qurey".equals(temp))
        {
            this.find(request, response);
        }
        else if("idqurey".equals(temp))
        {

            this.find1(request, response);
            System.out.println(3);
        }

    }
    private void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Log infor = new Log();
        LogDao dao = new LogDao();
        List<Log> list = dao.query();
        request.setAttribute("allInfor", list);
        String path = "/log.jsp";
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDistpatcher = request.getRequestDispatcher(path);
        requestDistpatcher.forward(request, response);
    }
    private void find1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        LogDao dao1 = new LogDao();
        String messL1=new String(request.getParameter("searchL1").trim().getBytes("ISO-8859-1"),"utf-8");
        if(messL1.length()!=4) {
            out.println("id输入不合法");
            return;
        }
        Log listSear = dao1.check(messL1);
        if(listSear==null) {
            out.println("该用户不存在");
            return;
        }

        request.setAttribute("SearInfor", listSear);
        String path1 = "/header_log.jsp";
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDistpatcher = request.getRequestDispatcher(path1);
        requestDistpatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
