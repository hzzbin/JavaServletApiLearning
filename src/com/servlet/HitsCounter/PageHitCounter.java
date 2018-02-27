package com.servlet.HitsCounter;

import com.servlet.ConstantData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by binzhang213309 on 2018/2/26.
 */
@WebServlet("/PageHit")
public class PageHitCounter extends HttpServlet {
    private int hitCount;

    @Override
    public void init() {
        // Reset hit counter.
        hitCount = 0;
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        hitCount++;
        PrintWriter out = response.getWriter();
        String title = "Total Number of Hits";
        out.println(ConstantData.docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<h2 align=\"center\">" + hitCount + "</h2>\n" +
                "</body></html>");
    }

    @Override
    public void destroy() {
        // This is optional step but if you like you
        // can write hitCount value int your database
    }
}
