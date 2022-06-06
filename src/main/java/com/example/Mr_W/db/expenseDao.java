package com.example.Mr_W.db;

import com.example.Mr_W.model.expense;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class expenseDao {
    public void updatePayByPayId(String id){
        try {
            Class.forName("org.h2.Driver");
            Connection conn= DriverManager.getConnection("jdbc:h2:~/System","sa","");
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("update EXPENSESHEET set SIGN=1 where PAYID='"+id+"'");
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
    }

    public List<expense> getExpenseById(String id){
        List<expense> list=null;
        try {
            Class.forName("org.h2.Driver");
            Connection conn= DriverManager.getConnection("jdbc:h2:~/System","sa","");
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select EXPENSESHEET.ID,REGISTRATIONFORM.LISTID,EXPENSESHEET.PAYID,REGISTRATIONFORM.COSTS,EXPENSESHEET.SIGN from EXPENSESHEET,PATIENTINFORMATION,REGISTRATIONFORM\n" +
                    "where EXPENSESHEET.PAYID=REGISTRATIONFORM.ID and PATIENTINFORMATION.PAYID=EXPENSESHEET.ID\n" +
                    "and PATIENTINFORMATION.PATIENTID='"+id+"'");
            boolean bl=true;
            while (rs.next()) {
                if(bl){
                    list=new ArrayList<>();
                    bl=false;
                }
                expense expense=new expense();
                expense.setId(rs.getString(1));
                if(rs.getString(2)==null)
                    expense.setGoal("诊断");
                else
                    expense.setGoal("取药");
                expense.setPayID(rs.getString(3));
                expense.SetCost(rs.getDouble(4));
                if(rs.getString(5).equals("0"))
                expense.setSign("未支付");
                else expense.setSign("已支付");
                list.add(expense);
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
}
