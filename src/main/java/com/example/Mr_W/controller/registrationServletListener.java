package com.example.Mr_W.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;


@WebListener("/registrationFilter")
public class registrationServletListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
            System.out.println("监听到"+sce.getServletContext()+"对象已创建");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("监听到"+sce.getServletContext()+"对象已摧毁");
    }

}
