package com.example.Mr_W.db;

import com.example.Mr_W.model.expense;
import com.example.Mr_W.model.registration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class expenseDao {
    public void updateCancelSign(String id){
        try {
            Class.forName("org.h2.Driver");
            Connection conn= DriverManager.getConnection("jdbc:h2:~/System","sa","");
            PreparedStatement stmt=conn.prepareStatement("update EXPENSESHEET set SIGN='2' where PAYID=?");
            stmt.setString(1,id);

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

    public void updatePayByPayId(String id){
        try {
            Class.forName("org.h2.Driver");
            Connection conn= DriverManager.getConnection("jdbc:h2:~/System","sa","");
            PreparedStatement stmt=conn.prepareStatement("update EXPENSESHEET set SIGN='1' where PAYID=?");
            stmt.setString(1,id);

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

    public boolean isPay(String id){
        try {
            Class.forName("org.h2.Driver");
            Connection conn= DriverManager.getConnection("jdbc:h2:~/System","sa","");
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select sign from EXPENSESHEET where payId='"+id+"'");
            if(rs.next()){
                if(!"0".equals(rs.getString(1)))
                    return false;
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
        return true;
    }

    public List<expense> getExpenseById(String id){
        List<expense> list=null;
        int[] i=new int[100];
        int n=-1,j=0;
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
                n++;
                expense expense=new expense();
                expense.setId(rs.getString(1));
                if(rs.getString(2)==null)
                    expense.setGoal("诊断");
                else
                    expense.setGoal("取药");
                expense.setPayID(rs.getString(3));
                expense.SetCost(rs.getDouble(4));
                if(rs.getString(5).equals("0")) {
                    i[j]=n;
                    j++;
                    expense.setSign("未支付");
                }else if(rs.getString(5).equals("1"))
                    expense.setSign("已支付");
                else
                    expense.setSign("已取消");
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
        for(int k=0;k<j;k++){
            expense temp= list.get(i[k]);
            for(int r=i[k];r>k;r--)
                list.set(r,list.get(r-1));
            list.set(k, temp);
        }
        return list;
    }

    public void insertExpense(String id,String payId,String sign){
        try {
            Class.forName("org.h2.Driver");
            Connection conn= DriverManager.getConnection("jdbc:h2:~/System","sa","");
            PreparedStatement stmt=conn.prepareStatement("insert into EXPENSESHEET values(?,?,?)");
            stmt.setString(1,id);
            stmt.setString(2,payId);
            stmt.setString(3,sign);

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
    public String getLastExpenseId(){
        String id=null;
        try {
            Class.forName("org.h2.Driver");
            Connection conn= DriverManager.getConnection("jdbc:h2:~/System","sa","");
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select id from EXPENSESHEET");
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
