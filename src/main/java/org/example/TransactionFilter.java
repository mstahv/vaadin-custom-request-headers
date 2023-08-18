package org.example;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Enumeration;

/**
 * This filter intercepts Vaadin's "state XHRs" and prints their
 * request headers to the console for debugging purposes.
 */
@WebFilter(urlPatterns = "/*")
public class TransactionFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        // Detect if the request is a Vaadin "state XHR"
        if(req.getParameter("v-r") != null && req.getParameter("v-r")
                .contains("uidl")) {
            System.out.println("-------New server request-------");
            System.out.println("*********************************");
            Enumeration<String> headerNames = req.getHeaderNames();
            while(headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                System.out.println(headerName + ": " + req.getHeader(headerName));
            }

            chain.doFilter(request, response);
            //System.out.println("Done that" + req.getRequestURI());
        } else {
            chain.doFilter(request, response);
        }
    }
}
