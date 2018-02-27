package com.servlet.Annotation;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.util.Date;

/**
 * Created by binzhang213309 on 2018/2/27.
 */
@WebFilter(urlPatterns = {"/*"}, initParams = {
        @WebInitParam(name = "test-param", value = "InitializationParameter")
})
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
        throws IOException, ServletException {
        System.out.println("Time " + new Date().toString());

        // Pass request back down the filter chain
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        /* Called before the Filter instance is removed
        from service by the web container */
    }
}
