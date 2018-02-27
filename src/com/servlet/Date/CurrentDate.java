package com.servlet.Date;

import com.servlet.ConstantData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by binzhang213309 on 2018/2/26.
 */
@WebServlet("/CurrentDate")
public class CurrentDate extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");
        // 设置页面每3秒刷新一次
        response.setIntHeader("Refresh", 1);

        PrintWriter out = response.getWriter();
        String title = "Display Current Date & Time";
        Date dateNow = new Date();
        SimpleDateFormat ft =
                new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a '  GMT'Z", Locale.ENGLISH);
        out.println(ConstantData.docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<h2 align=\"center\">" + ft.format(dateNow) + "</h2>\n" +
                "</body></html>");
    }
}
