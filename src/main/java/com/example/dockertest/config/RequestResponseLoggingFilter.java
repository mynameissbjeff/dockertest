package com.example.dockertest.config;

import com.example.dockertest.controller.DockertestCtrl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(2)
public class RequestResponseLoggingFilter implements Filter {

    private static final Logger logger = LogManager.getLogger(RequestResponseLoggingFilter.class);

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        logger.debug("Logging Request {}:{}",req.getMethod(),req.getRequestURI());

        chain.doFilter(request, response);
        logger.debug("Logging Response :{}",res.getContentType());

    }

    // other methods
}
