package com.example.Mr_L.db;

import com.example.Mr_L.model.Regist;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegistDao {
    public List<Regist> findAll(String id) {
        List<Regist> list=new ArrayList<>();
        try {
            Class.forName("org.h2.Driver");
            Connection conn= DriverManager.getConnection("jdbc:h2:d:/temp/System","sa","");
            Statement stmt=conn.createStatement();

            ResultSet rs=stmt.executeQuery("select *from REGISTRATIONFORM where doctorid='"+id+"'and sign='0'");
            while(rs.next()){
                Regist regist=new Regist();
                regist.setDoctorid(rs.getString(2));
                regist.setId(rs.getString(1));
                if(rs.getString(4).equals("1"))
                    regist.setType("急诊");
                else
                    regist.setType("普通");
                list.add(regist);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list ;
    }
    public List<Regist> findRegist(String id,String registid){
        List<Regist> list=new ArrayList<>();

        try {
            Class.forName("org.h2.Driver");
            Connection conn= DriverManager.getConnection("jdbc:h2:d:/temp/System","sa","");
            Statement stmt=conn.createStatement();
            String update="update REGISTRATIONFORM set sign='3' where id='"+registid+"'and doctorid='"+id+"'";
            //String delete="delete from REGISTRATIONFORM where id='"+id+"'";
            stmt.executeUpdate(update);
            ResultSet rs=stmt.executeQuery( "select *from REGISTRATIONFORM where doctorid='"+id+"'and sign='0'");
            while(rs.next()){
                Regist regist=new Regist();
                regist.setDoctorid(rs.getString(2));
                regist.setId(rs.getString(1));

                if(rs.getString(4).equals("1"))
                    regist.setType("急诊");
                else
                    regist.setType("普通");

                list.add(regist);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
      return list;
    }
    public List<Regist> findFinish(String id,String registid) {
        List<Regist> list = new ArrayList<>();
        try {
            Class.forName("org.h2.Driver");
            Connection conn= DriverManager.getConnection("jdbc:h2:d:/temp/System","sa","");
            Statement stmt=conn.createStatement();
            String update="update REGISTRATIONFORM set sign='1' where id='"+registid+"'and doctorid='"+id+"'";
            //String delete="delete from REGISTRATIONFORM where id='"+id+"'";
            stmt.executeUpdate(update);
            ResultSet rs=stmt.executeQuery( "select *from REGISTRATIONFORM where doctorid='"+id+"'and sign='0'");
            while(rs.next()){
                Regist regist=new Regist();
                regist.setDoctorid(rs.getString(2));
                regist.setId(rs.getString(1));

                if(rs.getString(4).equals("1"))
                    regist.setType("急诊");
                else
                    regist.setType("普通");

                list.add(regist);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public boolean Judge(String id,String registid){
        boolean temp=false;
        try {
            Class.forName("org.h2.Driver");
            Connection conn= DriverManager.getConnection("jdbc:h2:d:/temp/System","sa","");
            Statement stmt=conn.createStatement();

            ResultSet rs=stmt.executeQuery( "select *from REGISTRATIONFORM where doctorid='"+id+"'and sign='0'");
            while(rs.next()){
               if(registid.equals(rs.getString(1).trim()))
                   temp=true;
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return temp;
    }
    public static void main(String args[]) {
        String registid ="0000003";
        String id = "2001";
        boolean temp=false;
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:d:/temp/System", "sa", "");
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select *from REGISTRATIONFORM where doctorid='" + id + "'and sign='0'");
            while (rs.next()) {
             if(registid.equals(rs.getString(1).trim())){
                 temp=true;
             }
System.out.print(temp);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}

