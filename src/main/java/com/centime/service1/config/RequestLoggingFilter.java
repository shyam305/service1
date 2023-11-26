package com.centime.service1.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;
@Component

public class RequestLoggingFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(RequestLoggingFilter.class.getName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            MDC.put("traceID", UUID.randomUUID().toString().toUpperCase());

            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            Calendar startTime = Calendar.getInstance();

            MDC.put("remoteHost", req.getRemoteHost());
            MDC.put("requestURL",req.getRequestURL().toString());
            MDC.put("requestMethod", req.getMethod());

            chain.doFilter(request, response);

            long timeTaken = (Calendar.getInstance().getTimeInMillis() - startTime.getTimeInMillis());

            MDC.put("totalProcessingTime", String.valueOf(timeTaken));

            MDC.put("responseStatus",String.valueOf(res.getStatus()));



            logger.info("Request processed");
        } finally {
            MDC.clear();
        }
    }
}
