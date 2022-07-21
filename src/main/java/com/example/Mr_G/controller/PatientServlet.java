package com.example.Mr_G.controller;

import com.example.Mr_G.Dao.PatientDao;
import com.example.Mr_G.model.Patient;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "/PatientServlet",value = "/patientServlet")
public class PatientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String temp = request.getParameter("temp");

        if("qurey".equals(temp))
        {
            this.find(request, response);

        }
        else if("telqurey".equals(temp))
        {

            this.find1(request, response);

        }
        else if("addqurey".equals(temp)){

            this.add(request, response);

        }
        else if("updatequrey".equals(temp)) {

            this.update(request, response);

        }

    }

    private void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Patient infor = new Patient();
        PatientDao dao = new PatientDao();
        List<Patient> list = dao.query();
        request.setAttribute("allInfor", list);
        System.out.println(list);
        String path = "/patient.jsp";
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDistpatcher = request.getRequestDispatcher(path);
        requestDistpatcher.forward(request, response);
    }
    private void find1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        PatientDao dao1 = new PatientDao();
        String messP1=request.getParameter("searchP1").trim();
        if(messP1.length()!=11) {
            out.println("电话输入不合法");
            return ;
        }
        Patient listSear = dao1.check(messP1);
        if(listSear==null) {
            out.println("该用户不存在");
            return;
        }


        request.setAttribute("SearInfor", listSear);
        System.out.println(listSear);
        String path1 = "/header_user.jsp";
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDistpatcher = request.getRequestDispatcher(path1);
        requestDistpatcher.forward(request, response);
    }
    private boolean add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter(); //获取内置对象 out
        Patient patient = new Patient();
        PatientDao dao = new PatientDao();


        String id=new String(request.getParameter("id").getBytes("ISO-8859-1"),"utf-8");
        String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"utf-8");
        String sex=new String(request.getParameter("sex").getBytes("ISO-8859-1"),"utf-8");
        String phone=new String(request.getParameter("phone").getBytes("ISO-8859-1"),"utf-8");
        String address=new String(request.getParameter("address").getBytes("ISO-8859-1"),"utf-8");
        String idno=new String(request.getParameter("idno").getBytes("ISO-8859-1"),"utf-8");


        String listSearExist = dao.checkExistTel(phone);

        if(listSearExist.equals(idno)) {
            out.println("该用户已存在");
            return false;
        }

        if(id.length()!=4){
            out.println("id输入不合法");
            return false;
        }
        if(sex.equals('男')&&sex.equals('女')){
            out.println("性别输入不合法");
            return false;
        }
        if(phone.length()!=11){
            out.println("电话输入不合法");
            return false;
        }

        if(idno.length()!=18){
            out.println("身份证输入不合法");
            return false;
        }

        patient.setId(id);
        patient.setName(name);
        patient.setSex(sex);
        patient.setTelephone(phone);
        patient.setAddress(address);
        patient.setIdno(idno);
        System.out.println(id);
        System.out.println("id1");

        boolean result = false;
        result = dao.add(id,name,sex,phone,address,idno);
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

        Patient patient = new Patient();
        PatientDao dao = new PatientDao();
        String id1=new String(request.getParameter("id1").getBytes("ISO-8859-1"),"utf-8");
        String name1=new String(request.getParameter("name1").getBytes("ISO-8859-1"),"utf-8");
        String sex1=new String(request.getParameter("sex1").getBytes("ISO-8859-1"),"utf-8");
        String phone1=new String(request.getParameter("phone1").getBytes("ISO-8859-1"),"utf-8");
        String address1=new String(request.getParameter("address1").getBytes("ISO-8859-1"),"utf-8");
        String idno1=new String(request.getParameter("idno1").getBytes("ISO-8859-1"),"utf-8");
        if(id1.length()!=4){
            out.println("id输入不合法");
        }
        if(sex1.equals('男')&&sex1.equals('女')){
            out.println("性别输入不合法");

        }
        if(phone1.length()!=11){
            out.println("电话输入不合法");
        }
        if(idno1.length()!=18){
            out.println("身份证输入不合法");
        }
        boolean result1 = false;
        result1 =dao.update(id1,name1,sex1,phone1,address1,idno1);
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
