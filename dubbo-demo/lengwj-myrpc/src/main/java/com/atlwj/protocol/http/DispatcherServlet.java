package com.atlwj.protocol.http;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("servlet...init...");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet...service....");
        new HttpServletHandler().handler(req,resp);
    }

    @Override
    public void destroy() {
        System.out.println("servlet...destroy...");
    }
}
