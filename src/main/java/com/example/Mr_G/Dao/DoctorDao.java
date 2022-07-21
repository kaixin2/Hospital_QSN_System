package com.example.Mr_G.Dao;

import com.example.Mr_G.model.ConnBean;
import com.example.Mr_G.model.Doctor;
import com.example.Mr_G.model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDao {
    Connection connection =null;
    ConnBean conn = new ConnBean();
    public List<Doctor> query(){
        ResultSet rs = null;
        Statement stmt = null;
        ArrayList list = new ArrayList();

        try {
            this.connection = conn.getConnection();
            if (this.connection == null) {
                System.out.println("error");
            }

            String sql = "select id,name,courses,room,time,telephone from doctors";
            stmt = this.connection.createStatement();
            rs = stmt.executeQuery(sql);

            while(rs.next()) {
                Doctor inf = new Doctor();
                inf.setID(rs.getString(1));
                inf.setName(rs.getString(2));
                inf.setCourse(rs.getString(3));
                inf.setRoom(rs.getString(4));
                inf.setTime(rs.getString(5));
                inf.setTelephone(rs.getString(6));
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
    public Doctor check(String patientSear) {
        ResultSet rs = null;
        Statement stmt = null;
        Doctor inf =null;


        try {
            this.connection = conn.getConnection();
            if (this.connection == null) {
                System.out.println("error");
            }

            String sql="select * from doctors where telephone = '"+patientSear+"'";
            stmt = this.connection.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                Doctor newinf = new Doctor();
                inf=newinf;
                inf.setID(rs.getString(1));
                inf.setName(rs.getString(2));
                inf.setTelephone(rs.getString(3));
                inf.setCourse(rs.getString(4));
                inf.setRoom(rs.getString(5));
                inf.setTime(rs.getString(6));

            }
            System.out.println("rsD");
            System.out.println(rs.next());
            System.out.println("next()D");
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

        return inf;
    }

    public String checkExistTel(String patientSear) {
        ResultSet rs = null;
        Statement stmt = null;
        String inf = null;

        try {
            this.connection = conn.getConnection();
            if (this.connection == null) {
                System.out.println("error");
            }

            String sql="select telephone from doctors where telephone = '"+patientSear+"'";

            stmt = this.connection.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()) {

                inf=rs.getString(1);

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

        return inf;
    }



    public boolean add(String id,String name,String type,String room,String time,String phone) {
        PreparedStatement pstmt = null;
        String sql = "insert into doctors values(?,?,?,?,?,?)";
        boolean result = false;
        int number = 0;

        try {
            this.connection = conn.getConnection();
            pstmt = this.connection.prepareStatement(sql);
            pstmt.setString(1,id);
            pstmt.setString(2,name);
            pstmt.setString(3,phone);
            pstmt.setString(4,type);
            pstmt.setString(5,room);
            pstmt.setString(6,time);
            number = pstmt.executeUpdate();
            pstmt.close();
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

        if (number > 0) {
            result = true;
        }

        return result;
    }


    public boolean update(String id,String name,String type,String room,String time,String phone) {
        PreparedStatement pstmt = null;

        int number1 = 0;
        boolean result1 = false;

        // String sql = "update patient set name='"+name+"', sex='"+sex+"', phone='"+phone+"',address='"+address+"',idno='"+idno+"'  where id='"+id+"'";

        String sql = "update doctors set name=?, courses=?, room=?,time=?,telephone=?  where id=?";

        try {
            this.connection = conn.getConnection();
            pstmt = this.connection.prepareStatement(sql);
            //
            pstmt.setString(1,name);
            pstmt.setString(2,type);
            pstmt.setString(3,room);
            pstmt.setString(4,time);
            pstmt.setString(5,phone);
            pstmt.setString(6,id);

            number1 = pstmt.executeUpdate();
            pstmt.close();
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

        if (number1 > 0) {
            result1 = true;
        }

        return result1;
    }

}
