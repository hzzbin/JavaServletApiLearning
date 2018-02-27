package com.servlet.Annotation;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by binzhang213309 on 2018/2/27.
 */
//@WebServlet()
//@WebInitParam()
//@WebFilter()
//@WebListener()
//@HandlesTypes()
//@HttpConstraint()
//@HttpMethodConstraint()
//@MultipartConfig()
//@ServletSecurity()
@WebServlet("/Simple")
public class Simple extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        out.print("<h3>Hello Servlet</h3>");
        out.print("</body></html>");
    }
}
