package com.yanzi.study.lession10.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/test2")
public class TestServlet extends HttpServlet {

    /**
     * 重写get方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //设置返回类型为json
        resp.setContentType("application/json");
        //设置返回字符集
        resp.setCharacterEncoding("utf-8");
        //输出对象
        PrintWriter writer =resp.getWriter();
        //输出error消息
        writer.write("执行TestServlet内doGet方法成功！");
        writer.close();
    }
}
