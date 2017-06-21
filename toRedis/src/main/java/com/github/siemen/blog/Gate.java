package com.github.siemen.blog;

import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Zhan on 2017-06-09.
 */
@WebServlet(name = "Gate")
public class Gate extends HttpServlet {

    private static final String REDIS_HOST = "119.23.74.153";
    private static final int REDIS_PORT = 6379;
    private static final String REDIS_PASS = "siemen";
    private static final Jedis JEDIS = new Jedis(REDIS_HOST,REDIS_PORT);
    static {
        JEDIS.auth(REDIS_PASS);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        switch (action){
            case "":
                break;
            case "b":
                break;
            default:

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
