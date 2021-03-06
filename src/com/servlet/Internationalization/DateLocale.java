package com.servlet.Internationalization;

import com.servlet.ConstantData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by binzhang213309 on 2018/2/27.
 */
@WebServlet("/DateLocale")
public class DateLocale extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        // Get the client's Locale
        Locale locale = request.getLocale();
        String date = DateFormat.getDateTimeInstance(
                DateFormat.FULL,
                DateFormat.SHORT,
                locale).format(new Date());
        System.out.println(date);
        String title = "Locale Specific Dates";
        out.println(ConstantData.docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + date + "</h1>\n" +
                "</body></html>");
    }
}
