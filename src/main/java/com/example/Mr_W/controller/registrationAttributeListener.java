package com.example.Mr_W.controller;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener("/registrationAttribute")
public class registrationAttributeListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("监听到属性名"+scae.getName()+"=属性值"+scae.getValue()+"被添加到servletContext中");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println("监听到属性名"+scae.getName()+"=属性值"+scae.getValue()+"从servletContext移除");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println("监听到属性名"+scae.getName()+"=属性值"+scae.getValue()+"从servletContext中替换");
    }
}
