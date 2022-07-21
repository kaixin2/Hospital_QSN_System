package com.example.Mr_G.model;

import java.sql.*;
public class ConnBean {
    private String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Hospital";
    private String userName="sa";
    private String password="20010101hy";
    private Connection connection=null;

    public ConnBean(){
        //getConnection();
    }
    public Connection getConnection()
    {
        try{
            Class.forName(driver);
            System.out.println("加载驱动成功！");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("加载驱动失败！");
        }


        try {
            connection=DriverManager.getConnection(url,userName,password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(connection!=null)
            return connection;
        else{
            System.out.println("connection is not correct");
            return null;
        }
    }

    public void closeConnection()
    {
        try{
            if(connection!=null){
                connection.close();
            }
            connection=null;
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String getDriver() {
        return driver;
    }
    public void setDriver(String driver) {
        this.driver = driver;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}

