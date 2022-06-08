package com.example.Mr_G.controller;

import com.example.Mr_G.Dao.DoctorDao;
import com.example.Mr_G.Dao.PatientDao;
import com.example.Mr_G.model.Doctor;
import com.example.Mr_G.model.Patient;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/DoctorServlet")
public class DoctorServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String temp = request.getParameter("temp");
        if("qurey".equals(temp))
        {
            System.out.println("w1");
            this.find(request, response);
        }
        else if("telqurey".equals(temp))
        {
            System.out.println("u1");
            this.find1(request, response);

        }
        else if("addqurey".equals(temp)){

            this.add(request, response);
        }
        else if("updatequrey".equals(temp)) {
            System.out.println("wu1");
            this.update(request, response);

        }


    }

    private void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Doctor infor = new Doctor();
        DoctorDao dao = new DoctorDao();
        List<Doctor> list = dao.query();
        request.setAttribute("allInfor", list);

        String path = "/doctor.jsp";
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDistpatcher = request.getRequestDispatcher(path);
        requestDistpatcher.forward(request, response);
    }
    private void find1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        DoctorDao dao1 = new DoctorDao();

        String messD1=request.getParameter("searchD1");
        Doctor listSear = dao1.check(messD1);
        System.out.println(listSear);
        request.setAttribute("SearInfor", listSear);

        String path1 = "/header_doctor.jsp";
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDistpatcher = request.getRequestDispatcher(path1);
        requestDistpatcher.forward(request, response);
    }
    private boolean add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        Doctor doctor = new Doctor();
        DoctorDao dao = new DoctorDao();


        String id=new String(request.getParameter("idD1").getBytes("ISO-8859-1"),"utf-8");
        //System.out.println(id);
        String name=new String(request.getParameter("nameD1").getBytes("ISO-8859-1"),"utf-8");
        //System.out.println(name);
        String type=new String(request.getParameter("typeD1").getBytes("ISO-8859-1"),"utf-8");
        //System.out.println(type);
        String room=new String(request.getParameter("roomD1").getBytes("ISO-8859-1"),"utf-8");
        //System.out.println(room);
        String time=new String(request.getParameter("timeD1").getBytes("ISO-8859-1"),"utf-8");
        //System.out.println(time);
        String phone=new String(request.getParameter("phoneD1").getBytes("ISO-8859-1"),"utf-8");
        PrintWriter out = response.getWriter(); //获取内置对象 out
        if(id.length()!=4){

            out.println("id输入不合法");
            return false;
        }

        if(phone.length()!=11){
            out.println("电话输入不合法");
            return false;

        }
        String RoomPattern="[a-zA-Z][0-9]{2}[1-9]";
        if(!room.matches(RoomPattern)) {
            out.println("诊室输入不合法");
            return false;
        }
        doctor.setID(id);
        doctor.setName(name);
        doctor.setCourse(type);
        doctor.setRoom(room);
        doctor.setTime(time);
        doctor.setTelephone(phone);



        boolean result = false;
        result = dao.add(id,name,type,room,time,phone);
        if (result) {
            find(request, response);
        } else {
            System.out.print("增加失败");
        }

        return result;


    }


    private boolean update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter(); //获取内置对象 out

        Doctor doctor = new Doctor();
        DoctorDao dao = new DoctorDao();
        String id1=new String(request.getParameter("idD1").getBytes("ISO-8859-1"),"utf-8");

        String name1=new String(request.getParameter("nameD1").getBytes("ISO-8859-1"),"utf-8");

        String type1=new String(request.getParameter("typeD1").getBytes("ISO-8859-1"),"utf-8");

        String room1=new String(request.getParameter("roomD1").getBytes("ISO-8859-1"),"utf-8");

        String time1=new String(request.getParameter("timeD1").getBytes("ISO-8859-1"),"utf-8");

        String phone1=new String(request.getParameter("phoneD1").getBytes("ISO-8859-1"),"utf-8");

        if(id1.length()!=4){

            out.println("id输入不合法");

        }



        boolean result1 = false;
        result1 =dao.update(id1,name1,type1,room1,time1,phone1);
        if (result1) {
            find(request, response);
        } else {
            System.out.print("修改失败");
        }

        return result1;



    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
