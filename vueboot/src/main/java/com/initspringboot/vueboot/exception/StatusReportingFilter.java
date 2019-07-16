package com.initspringboot.vueboot.exception;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StatusReportingFilter implements Filter {

    public int status;

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        StatusExposingServletResponse response = new StatusExposingServletResponse((HttpServletResponse)res);
        chain.doFilter(req, response);
        status = response.getStatus();
        // report  在这儿你就得到状态码了。
    }

    public void init(FilterConfig config) throws ServletException {
        //empty
    }

    public void destroy() {
        // empty
    }

}
