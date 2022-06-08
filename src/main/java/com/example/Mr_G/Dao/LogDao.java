package com.example.Mr_G.Dao;

import com.example.Mr_G.model.ConnBean;
import com.example.Mr_G.model.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class LogDao {
    Connection connection =null;
    ConnBean conn = new ConnBean();
    public List<Log> query(){
        ResultSet rs = null;
        Statement stmt = null;
        ArrayList list = new ArrayList();

        try {
            this.connection = conn.getConnection();
            if (this.connection == null) {
                System.out.println("error");
            }

            String sql = "select * from patientInformation ";
            stmt = this.connection.createStatement();
            rs = stmt.executeQuery(sql);

            while(rs.next()) {
                Log inf = new Log();
                inf.setID(rs.getString(1));
                inf.setDoctorID(rs.getString(2));
                inf.setPatientID(rs.getString(3));
                inf.setBookingID(rs.getString(4));
                inf.setMedicineID(rs.getString(5));
                inf.setCostID(rs.getString(6));
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

