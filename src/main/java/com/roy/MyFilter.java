package com.roy;

import javax.lang.model.element.VariableElement;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebFilter(filterName = "MyFilter", urlPatterns = "/*")
public class MyFilter implements Filter {

    List<String> ips = new ArrayList();

    {
        ips.add("127.0.0.1");
        ips.add("192.168.0.1");
        ips.add("0:0:0:0:0:0:0:1");
    }


    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String localAddr = request.getLocalAddr();
        System.out.println(localAddr);
        boolean isBlackList = false;
        for (String ip : ips) {
            if (Objects.equals(ip, localAddr)){
                isBlackList = true;
                break;
            }
        }
        if (isBlackList){
            PrintWriter writer = response.getWriter();
            writer.println("<h1>" + "你的IP被禁止访问" + "</h1>");
        }else {
            chain.doFilter(request, response);
        }


    }
}
