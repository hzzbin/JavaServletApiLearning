package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *  Extend HttpServlet class
 */
@WebServlet("/hello")
public class HelloWorldHTTPServlet extends HttpServlet {

    private String message;

    @Override
    public void init() throws ServletException {
        System.out.println("init() called----------------->");
        // Do required initialization
        message = "Hello World is coming back!";
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("doGet() called----------------->");
        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    @Override
    public void destroy() {
        System.out.println("destroy() called----------------->");
        // do nothing.
    }


}
