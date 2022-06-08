package com.example.Mr_G.Dao;

import com.example.Mr_G.model.ConnBean;
import com.example.Mr_G.model.Doctor;
import com.example.Mr_G.model.Patient;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

            String sql = "select id,name,telephone,courses,room,time from doctor";
            stmt = this.connection.createStatement();
            rs = stmt.executeQuery(sql);

            while(rs.next()) {
                Doctor inf = new Doctor();
                inf.setID(rs.getString(1));
                inf.setName(rs.getString(2));
                inf.setTelephone(rs.getString(3));
                inf.setCourse(rs.getString(4));
                inf.setRoom(rs.getString(5));
                inf.setTime(rs.getString(6));
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
}
