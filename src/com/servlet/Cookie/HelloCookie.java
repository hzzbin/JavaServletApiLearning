package com.servlet.Cookie;

import com.servlet.ConstantData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by binzhang213309 on 2018/2/24.
 */
@WebServlet("/HelloCookie")
public class HelloCookie extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {
        Cookie firstName = new Cookie("first_name", request.getParameter("first_name"));
        Cookie lastName = new Cookie("last_name", request.getParameter("last_name"));

        firstName.setMaxAge(60*60*24);
        lastName.setMaxAge(60*60*24);

        response.addCookie(firstName);
        response.addCookie(lastName);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Setting Cookies Example";
        out.println(ConstantData.docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                " <li><b>First Name</b>: "
                + request.getParameter("first_name") + "\n" +
                " <li><b>Last Name</b>: "
                + request.getParameter("last_name") + "\n" +
                "</ul>\n" +
                "</body></html>");
    }

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
        throws ServletException, IOException {
        doGet(request, response);
    }
}
