package com.example.Mr_G.Dao;

import com.example.Mr_G.model.ConnBean;
import com.example.Mr_G.model.Patient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PatientDao {
    Connection connection =null;
    ConnBean conn = new ConnBean();
    public List<Patient> query(){
        ResultSet rs = null;
        Statement stmt = null;
        ArrayList<Patient> list = new ArrayList<Patient>();

        try {
            this.connection = conn.getConnection();
            if (this.connection == null) {
                System.out.println("error");
            }

            String sql = "select * from patient";
            stmt = this.connection.createStatement();
            rs = stmt.executeQuery(sql);

            while(rs.next()) {
                Patient inf = new Patient();
                inf.setId(rs.getString(1));
                inf.setName(rs.getString(2));
                inf.setSex(rs.getString(3));
                inf.setTelephone(rs.getString(4));
                inf.setAddress(rs.getString(5));
                inf.setIdno(rs.getString(6));
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
    public Patient check(String patientSear) {
        ResultSet rs = null;
        Statement stmt = null;
        Patient inf = null;

        try {
            this.connection = conn.getConnection();
            if (this.connection == null) {
                System.out.println("error");
            }

            String sql="select * from patient where telephone = '"+patientSear+"'";

            stmt = this.connection.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()) {

                Patient new_inf = new Patient();
                inf = new_inf;

                inf.setId(rs.getString(1));
                inf.setName(rs.getString(2));
                inf.setSex(rs.getString(3));
                inf.setTelephone(rs.getString(4));
                inf.setAddress(rs.getString(5));
                inf.setIdno(rs.getString(6));


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
    public String checkExistTel(String patientSear) {
        ResultSet rs = null;
        Statement stmt = null;
        String inf = null;

        try {
            this.connection = conn.getConnection();
            if (this.connection == null) {
                System.out.println("error");
            }

            String sql="select idno from patient where telephone = '"+patientSear+"'";

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

    public boolean add(String id,String name,String sex,String phone,String address,String idno) {
        PreparedStatement pstmt = null;
        String sql = "insert into patient values(?,?,?,?,?,?)";
        boolean result = false;
        int number = 0;

        try {
            this.connection = conn.getConnection();
            pstmt = this.connection.prepareStatement(sql);
            pstmt.setString(1,id);
            pstmt.setString(2,name);
            pstmt.setString(3,sex);
            pstmt.setString(4,phone);
            pstmt.setString(5, address);
            pstmt.setString(6, idno);
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
    public boolean update(String id,String name,String sex,String phone,String address,String idno) {
        PreparedStatement pstmt = null;

        int number1 = 0;
        boolean result1 = false;

        // String sql = "update patient set name='"+name+"', sex='"+sex+"', phone='"+phone+"',address='"+address+"',idno='"+idno+"'  where id='"+id+"'";

        String sql = "update patient set name=?, sex=?, telephone=?,address=?,idno=?  where id=?";

        try {
            this.connection = conn.getConnection();
            pstmt = this.connection.prepareStatement(sql);
            //
            pstmt.setString(1,name);
            pstmt.setString(2,sex);
            pstmt.setString(3,phone);
            pstmt.setString(4,address);
            pstmt.setString(5,idno);
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
