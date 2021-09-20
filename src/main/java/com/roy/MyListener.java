package com.roy;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * 用于监听ServletContext、servletRequest、HttpSession等域对象的创建、销毁的事件
 *
 * @author xmly
 * @date 2021/09/18
 */
@WebListener
public class MyListener implements ServletContextListener {

    public MyListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
    System.out.println("监听器启动！");
        String parameter = sce.getServletContext().getInitParameter("project_name");
        sce.getServletContext().setAttribute("name", "jdk5678");
    System.out.println(parameter);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
    }


    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }


    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }
}
