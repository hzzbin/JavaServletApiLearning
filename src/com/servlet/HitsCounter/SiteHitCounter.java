package com.servlet.HitsCounter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

/**
 * Created by binzhang213309 on 2018/2/26.
 */
@WebFilter("/PageHit")
public class SiteHitCounter implements Filter {
    private int hitCount;

    @Override
    public void init(FilterConfig config)
        throws ServletException {
        // Reset hit counter.
        hitCount = 0;
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response, FilterChain chain)
        throws java.io.IOException, ServletException {

        // increase counter by one
        hitCount++;

        // Print the counter.
        System.out.println("Site visits count :"+ hitCount);

        // Pass request back down the filter chain
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        // This is optional step but if you like you
        // can write hitcount value in your database
    }
}
