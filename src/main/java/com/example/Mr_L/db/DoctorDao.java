package com.example.Mr_L.db;

import com.example.Mr_L.model.Doctor;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDao {

    public List<Doctor> findAll(String id) {

        List<Doctor> list=new ArrayList<>();

        try {
            Class.forName("org.h2.Driver");
            Connection conn= DriverManager.getConnection("jdbc:h2:d:/temp/System","sa","");
            Statement stmt=conn.createStatement();

            ResultSet rs=stmt.executeQuery( "select *from DOCTOR where id='"+id+"'");
            while(rs.next()){
               Doctor doctor=new Doctor();
                doctor.setId(rs.getString(1));
                doctor.setName(rs.getString(2));
                doctor.setCourses(rs.getString(4));
                doctor.setRoom(rs.getString(5));
                if(rs.getString(6).equals("1"))
                    doctor.setTime("上午");
                else if(rs.getString(6).equals("1"))
                    doctor.setTime("下午");
                else
                doctor.setTime("全天");
                list.add(doctor);

            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list ;
    }
    public static void main(String args[]){

    }
}
