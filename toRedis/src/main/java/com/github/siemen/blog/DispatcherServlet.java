package com.github.siemen.blog;

import com.alibaba.fastjson.JSON;
import com.github.siemen.blog.model.Blog;
import com.github.siemen.blog.model.MAV;
import com.github.siemen.blog.service.IBlogService;
import com.github.siemen.blog.service.imp.BlogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Zhan on 2017-06-12.
 */
@WebServlet(name = "DispatcherServlet",urlPatterns = "/blog")
public class DispatcherServlet extends HttpServlet {

    private IBlogService blogService = BlogService.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        action = action == null||"".equals(action) ? "menu" : action;
        MAV mav = null;
        switch (action){
            case "menu":
                blogService.showMenu();
                break;
            case "getAdmin":
                mav = blogService.getAdmin();
                break;
            case "setAdmin":
                String admin = request.getParameter("admin");
                mav = blogService.setAdmin(admin);
                break;
            case "post":
                mav = postBlog(request);
                break;
            case "view":
                String postId = request.getParameter("postId");
                mav = blogService.viewBlog(postId);
                break;
        }
        response(mav,request,response);
    }

    private MAV postBlog(HttpServletRequest request) {
        Blog blog = new Blog();
        blog.setTitle(request.getParameter("title"));
        blog.setContent(request.getParameter("content"));
        blog.setPubTime(request.getParameter("pubTime"));
        MAV mav = blogService.post(blog);
        return mav;
    }

    private void response(MAV mav,HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println(mav.getData());
        if(mav == null){
            return;
        }
        if(mav.getUrl() != null){
            request.getSession().setAttribute("message",mav.getData());
            response.sendRedirect(mav.getUrl());
            return;
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.getWriter().write(JSON.toJSONString(mav.getData()));
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
