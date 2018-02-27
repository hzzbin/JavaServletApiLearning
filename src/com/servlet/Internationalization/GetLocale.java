package com.servlet.Internationalization;

import com.servlet.ConstantData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

/**
 * Created by binzhang213309 on 2018/2/26.
 */
@WebServlet("/GetLocale")
public class GetLocale extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {
        // Get the client's Locale
        Locale locale = request.getLocale();
        String language = locale.getLanguage();
        String country = locale.getCountry();

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String title = "Detecting Locale";
        out.println(ConstantData.docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + language + "</h1>\n" +
                "</body></html>");
    }
}
