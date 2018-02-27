package com.servlet.Database;

import com.servlet.ConstantData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by binzhang213309 on 2018/2/24.
 */
@WebServlet("/DatabaseAccess")
public class DatabaseAccess extends HttpServlet {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost:3306/db_example?characterEncoding=utf8&useSSL=false";
    // Database credentials
    static final String USER = "root";
    static final String PASS = "123456";

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Database Result";
        Statement stmt = null;
        Connection conn = null;
        out.println(ConstantData.docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n");
        try {
            // Register JDBC driver
            //Class.forName("com.mysql.jdbc.Driver").newInstance();

            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);

            // Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // Execute SQL query
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM employees";
            ResultSet rs = stmt.executeQuery(sql);

            // Extract data from result set
            while(rs.next()) {

                // Retrieve by column name
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");

                // Display values
                out.println("ID: " + id);
                out.println(", Age: " + age);
                out.println(", First: " + first);
                out.println(", Last: " + last);
                out.println("<br>");
            }

            out.println("</body></html>");

            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName;
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            }catch (SQLException se){
                se.printStackTrace();
            }
        }
    }
}
