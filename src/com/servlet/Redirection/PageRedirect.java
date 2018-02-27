package com.servlet.Redirection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by binzhang213309 on 2018/2/26.
 */
@WebServlet("/PageRedirect")
public class PageRedirect extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        // New location to be redirected
        String site = new String("http://www.baidu.com");

        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", site);
    }
}
