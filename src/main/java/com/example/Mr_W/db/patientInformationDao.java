package com.example.Mr_W.db;

import java.sql.*;

public class patientInformationDao {
    public void insertPatientInformation(String id,String patientId,String registrationId,String payId,String drugId){
        try {
            Class.forName("org.h2.Driver");
            Connection conn= DriverManager.getConnection("jdbc:h2:~/System","sa","");
            PreparedStatement stmt=conn.prepareStatement("insert into PATIENTINFORMATION values (?,?,?,?,?)");
            stmt.setString(1,id);
            stmt.setString(2,patientId);
            if("".equals(drugId))
                drugId=null;
            stmt.setString(3,drugId);
            stmt.setString(4,registrationId);
            stmt.setString(5,payId);

            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public String getLastPatientInformationId(){
        String id=null;
        try {
            Class.forName("org.h2.Driver");
            Connection conn= DriverManager.getConnection("jdbc:h2:~/System","sa","");
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select id from PATIENTINFORMATION");
            while (rs.next()) {
                id = rs.getString(1);
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
