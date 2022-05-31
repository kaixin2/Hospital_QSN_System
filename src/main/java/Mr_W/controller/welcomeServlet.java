package Mr_W.controller;

import Mr_W.model.patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/welcome")
public class welcomeServlet extends HttpServlet {
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        HttpSession session= request.getSession();
        patient patient=new patient();
        patient.setId("0001");
        patient.setName("张三");
        patient.setSex("男");
        patient.setAddress("江西省南昌市南昌航空大学");
        patient.setTelephone("12345678910");
        response.setCharacterEncoding("utf-8");
        request.setAttribute("login",patient);
        request.getRequestDispatcher("/patientHome.jsp").forward(request, response);
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
