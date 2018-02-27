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
@WebServlet("/DeleteCookie")
public class DeleteCookie extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {
        Cookie cookie = null;
        Cookie[] cookies = null;
        cookies = request.getCookies();

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Delete Cookies Example";
        out.println(ConstantData.docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n");
        if (cookies != null) {
            out.println("<h2> Cookies Name and Value</h2>");
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if((cookie.getName()).compareTo("first_name") == 0) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    out.print("Deleted cookie : " + cookie.getName() + "<br/>");
                }
                out.print("Name : " + cookie.getName() + ", ");
                out.print("Value : " + cookie.getValue() + " <br/>");
            }
        } else {
            out.println("<h2>No cookies founds</h2>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
