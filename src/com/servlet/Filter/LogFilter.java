package com.servlet.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.util.Date;

/**
 * Created by binzhang213309 on 2018/2/24.
 */
@WebFilter("/*")
public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig config)
        throws ServletException {
        String testParam = config.getInitParameter("test-param");

        System.out.println("Test Param: " + testParam);
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
        throws java.io.IOException, ServletException {
        String ipAddress = request.getRemoteAddr();

        System.out.println("IP " + ipAddress + ", Time " + new Date().toString());

        // Pass request back down the filter chain
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        /* Called before the filter instance is removed
        from service by the web container */
    }
}
