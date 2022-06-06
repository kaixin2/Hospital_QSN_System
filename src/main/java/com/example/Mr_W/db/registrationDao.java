package com.example.Mr_W.db;

import com.example.Mr_W.model.doctor;
import com.example.Mr_W.model.registration;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class registrationDao {
    public registration getRegistrationInformationById(String id){
        registration registration=null;
        try {
            Class.forName("org.h2.Driver");
            Connection conn= DriverManager.getConnection("jdbc:h2:~/System","sa","");
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select REGISTRATIONFORM.id,DOCTOR.name,DOCTOR.COURSES,DOCTOR.ROOM,REGISTRATIONFORM.COSTS\n" +
                    "from REGISTRATIONFORM,DOCTOR\n" +
                    "where REGISTRATIONFORM.DOCTORID=DOCTOR.ID and REGISTRATIONFORM.ID='"+id+"'");
            while (rs.next()) {
                doctor doctor=new doctor();
                doctor.setName(rs.getString(2));
                doctor.setCourses(rs.getString(3));
                doctor.setRoom(rs.getString(4));
                registration=new registration();
                registration.setDoctor(doctor);
                registration.setId(rs.getString(1));
                registration.setCosts(rs.getDouble(5));

            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return registration;
    }

    public List<registration> getALLRegistrationInformationByPatientId(String id){
        List<registration> list=null;
        try {
            Class.forName("org.h2.Driver");
            Connection conn= DriverManager.getConnection("jdbc:h2:~/System","sa","");
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select REGISTRATIONFORM.id,DOCTOR.name,DOCTOR.COURSES,DOCTOR.ROOM,REGISTRATIONFORM.PTIME,REGISTRATIONFORM.COSTS,REGISTRATIONFORM.listId,REGISTRATIONFORM.sign,REGISTRATIONFORM.type\n" +
                    "from REGISTRATIONFORM,DOCTOR,PATIENTINFORMATION\n" +
                    "where PATIENTINFORMATION.REGISTRATIONID=REGISTRATIONFORM.ID " +
                    "and REGISTRATIONFORM.DOCTORID=DOCTOR.ID " +
                    "and PATIENTINFORMATION.PATIENTID='"+id+"'"+
                    "and REGISTRATIONFORM.sign !='3'"+
                    "order by REGISTRATIONFORM.PTIME,REGISTRATIONFORM.sign");
            boolean bl=true;
            while (rs.next()) {
                if(bl){
                    list=new ArrayList<>();
                    bl=false;
                }
                doctor doctor=new doctor();
                doctor.setName(rs.getString(2));
                doctor.setCourses(rs.getString(3));
                doctor.setRoom(rs.getString(4));
                registration registration=new registration();
                registration.setDoctor(doctor);
                registration.setId(rs.getString(1));
                registration.setpTime(rs.getString(5));
                registration.setCosts(rs.getDouble(6));
                if(rs.getString(7)==null)
                    registration.setListID("诊断");
                else registration.setListID("取药");
                if(rs.getString(8).equals("0"))
                    registration.setSign("未完成");
                else registration.setSign("已完成");
                if(rs.getString(9).equals("1"))
                    registration.setpType("普通");
                else registration.setpType("急诊");
                list.add(registration);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    public List<String> getQueueById(String id){
        List<String> list=null;
        try {
            Class.forName("org.h2.Driver");
            Connection conn= DriverManager.getConnection("jdbc:h2:~/System","sa","");
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select id from REGISTRATIONFORM\n" +
                    "where DOCTORID=(select DOCTORID from REGISTRATIONFORM where id='"+id+"') and SIGN='0'\n" +
                    "order by PTIME");
            boolean bl=true;
            while (rs.next()) {
                if(bl){
                    list=new ArrayList<>();
                    bl=false;
                }
                list.add(rs.getString(1));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    public String getRegistrationByPatientId(String patientId){
        String id=null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date= sdf.format(System.currentTimeMillis());
        try {
            Class.forName("org.h2.Driver");
            Connection conn= DriverManager.getConnection("jdbc:h2:~/System","sa","");
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select id,PTIME from REGISTRATIONFORM\n" +
                    "where REGISTRATIONFORM.ID in (select REGISTRATIONID from PATIENTINFORMATION where PATIENTID='"+patientId+"') and SIGN='0'\n" +
                    "order by PTIME");
            while (rs.next()) {
                if(rs.getString(2).equals(date)) {
                    id = rs.getString(1);
                    break;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return id;
    }
}
