package Mr_W.controller;

import Mr_W.model.doctor;
import Mr_W.model.patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/registration")
public class registrationServlet extends HttpServlet {
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    	doctor doctor1=new doctor();
        doctor doctor4=new doctor();
        doctor1.setId("00000001");
        doctor4.setId("00000004");

        doctor1.setCourses("神经科");
        doctor4.setCourses("内科");
        doctor1.setName("张三");
        doctor4.setName("刘六");
        List<doctor> list=new ArrayList<>();
        list.add(doctor1);
        list.add(doctor4);
        request.setAttribute("doctor",list);
        request.setAttribute("doctors",list);
        request.getRequestDispatcher("/registration.jsp").forward(request, response);
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
