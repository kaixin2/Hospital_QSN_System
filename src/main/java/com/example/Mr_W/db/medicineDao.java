package com.example.Mr_W.db;

import com.example.Mr_W.model.drug;
import com.example.Mr_W.model.medicine;

import java.sql.*;

public class medicineDao {
    public medicine getMedicineById(String id){
        medicine medicine=null;
        try {
            Class.forName("org.h2.Driver");
            Connection conn= DriverManager.getConnection("jdbc:h2:~/System","sa","");
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select MEDICINELIST.ID,DRUGS.NAME,MEDICINELIST.NUM,MEDICINELIST.NUM*DRUGS.DRUGCOSTS from MEDICINELIST,DRUGS where MEDICINELIST.DRUGID=DRUGS.ID and MEDICINELIST.ID=(select ListId from REGISTRATIONFORM where id='"+id+"')");
            if (rs.next()) {
                medicine=new medicine();
                medicine.setId(id);
                drug drug=new drug();
                drug.setName(rs.getString(2));
                medicine.setDrug(drug);
                medicine.setNum(rs.getInt(3));
                medicine.setCost(rs.getDouble(4));
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
        return medicine;
    }
}
