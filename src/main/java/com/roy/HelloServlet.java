package com.roy;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

// @WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
  private static int count;

  public void init() {
    count = 0;
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("service ........");
    super.service(req, resp);
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;charset=UTF-8");
    count++;
    PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.println("<h1>" + "访问次数" + count + "</h1>");
    out.println("</body></html>");
  }

  public void destroy() {}
}
