package com.example.Mr_W.db;

import java.sql.*;

public class doctorDao {
    public String getNameOfId(String id){
        String name=null;
        try {
            Class.forName("org.h2.Driver");
            Connection conn= DriverManager.getConnection("jdbc:h2:~/System","sa","");
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select name from doctor where ID='"+id+"'");
            if(rs.next()) {
                name=rs.getString(1);
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
        return name;
    }
}
