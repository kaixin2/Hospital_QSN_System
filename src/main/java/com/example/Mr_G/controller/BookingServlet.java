package com.example.Mr_G.controller;

import com.example.Mr_G.Dao.BookingDao;
import com.example.Mr_G.model.Booking;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingServlet() {
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

            this.findid(request, response);
            System.out.println(3);
        }
        else if("timequrey".equals(temp))
        {
            System.out.println(1);
            this.findtime(request, response);
            System.out.println(2);

        }

    }
    private void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Booking infor = new Booking();
        BookingDao dao = new BookingDao();
        List<Booking> list = dao.query();
        request.setAttribute("allInfor", list);
        String path = "/booking.jsp";
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDistpatcher = request.getRequestDispatcher(path);
        requestDistpatcher.forward(request, response);
    }
    private void findid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        BookingDao dao = new BookingDao();
        String messB=request.getParameter("searchB");
        if(messB.length()!=4) {
            out.println("id输入不合法");
            return;
        }
        Booking listSear = dao.checkId(messB);


        if(listSear==null) {
            out.println("该用户不存在");
            return;
        }
        request.setAttribute("IdInfor", listSear);
        String path1 = "/header_booking.jsp";
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDistpatcher = request.getRequestDispatcher(path1);
        requestDistpatcher.forward(request, response);
    }
    private void findtime(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        BookingDao dao = new BookingDao();
        String messT1=request.getParameter("searchT1");

        String messT2=request.getParameter("searchT2");
        if(messT1==""||messT2=="") {
            out.println("请选择时间");
            return;
        }
        List<Booking> listTime = dao.checkTime(messT1,messT2);

        if(listTime.size()==0) {
            out.println("该时间段内暂无预约记录！");
            return;
        }
        request.setAttribute("TimeInfor", listTime);
        String path1 = "/header_booking.jsp";
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
