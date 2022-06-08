package com.example.Mr_G.Dao;


import com.example.Mr_G.model.Booking;
import com.example.Mr_G.model.ConnBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookingDao {
    Connection connection =null;
    ConnBean conn = new ConnBean();
    public List<Booking> query(){
        ResultSet rs = null;
        Statement stmt = null;
        ArrayList list = new ArrayList();

        try {
            this.connection = conn.getConnection();
            if (this.connection == null) {
                System.out.println("error");
            }

            String sql = "select * from registrationForm";
            stmt = this.connection.createStatement();
            rs = stmt.executeQuery(sql);

            while(rs.next()) {
                Booking inf = new Booking();
                inf.setId(rs.getString(1));
                inf.setDoctorId(rs.getString(2));
                inf.setListId(rs.getString(3));
                inf.setType(rs.getString(4));
                inf.setpTime(rs.getString(5));
                inf.setCosts(rs.getString(6));
                inf.setSign(rs.getString(7));
                list.add(inf);
            }

            stmt.close();
            this.connection.close();
        } catch (SQLException var14) {
            var14.printStackTrace();
        } finally {
            try {
                if (this.connection != null && !this.connection.isClosed()) {
                    this.connection.close();
                }
            } catch (SQLException var13) {
                var13.printStackTrace();
            }

        }

        return list;

    }
    public Booking checkId(String searchB) {
        ResultSet rs = null;
        Statement stmt = null;
        Booking infId = new Booking();

        try {
            this.connection = conn.getConnection();
            if (this.connection == null) {
                System.out.println("error");
            }

            String sql="select * from registrationForm where doctorId = '"+searchB+"'";

            stmt = this.connection.createStatement();
            rs = stmt.executeQuery(sql);
//            if(!rs.next()) {
//            	 stmt.close();
//                 this.connection.close();
//            	return infId=null;
//            }

            while(rs.next()) {

                infId.setId(rs.getString(1));
                infId.setDoctorId(rs.getString(2));
                infId.setListId(rs.getString(3));
                infId.setType(rs.getString(4));
                infId.setpTime(rs.getString(5));
                infId.setCosts(rs.getString(6));
                infId.setSign(rs.getString(7));
            }

            stmt.close();
            this.connection.close();
        } catch (SQLException var17) {
            var17.printStackTrace();
        } finally {
            try {
                if (this.connection != null && !this.connection.isClosed()) {
                    this.connection.close();
                }
            } catch (SQLException var16) {
                var16.printStackTrace();
            }

        }

        return infId;
    }
    public List<Booking> checkTime(String searchT1,String searchT2){
        ResultSet rs = null;
        Statement stmt = null;
        ArrayList<Booking> listTime = new ArrayList<Booking>();

        try {
            this.connection = conn.getConnection();
            if (this.connection == null) {
                System.out.println("error");
            }

            String sql = "select * from registrationForm where pTime between '"+searchT1+"' and '"+searchT2+"'";
            stmt = this.connection.createStatement();
            rs = stmt.executeQuery(sql);

            while(rs.next()) {
                Booking inf = new Booking();
                inf.setId(rs.getString(1));

                inf.setDoctorId(rs.getString(2));
                inf.setListId(rs.getString(3));
                inf.setType(rs.getString(4));
                inf.setpTime(rs.getString(5));
                inf.setCosts(rs.getString(6));
                inf.setSign(rs.getString(7));
                listTime.add(inf);
            }

            stmt.close();
            this.connection.close();
        } catch (SQLException var14) {
            var14.printStackTrace();
        } finally {
            try {
                if (this.connection != null && !this.connection.isClosed()) {
                    this.connection.close();
                }
            } catch (SQLException var13) {
                var13.printStackTrace();
            }

        }

        return listTime;

    }

}
