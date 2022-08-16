package com.example.dockertest.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(1)
public class TransactionFilter implements Filter {

    private static final Logger logger = LogManager.getLogger(TransactionFilter.class);

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        logger.debug("Starting a transaction for req : {}",req.getRequestURI());

        chain.doFilter(request, response);
        logger.debug("Committing a transaction for req : {}",req.getRequestURI());

    }

}
