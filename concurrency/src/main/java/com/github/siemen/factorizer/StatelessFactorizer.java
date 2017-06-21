package com.github.siemen.factorizer;
/**
 * Created by Zhan on 2017-06-16.
 */

import com.github.siemen.annotation.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

/**
 * 无状态Servlet
 * 无状态单例类 线程安全
 */
@ThreadSafe
public class StatelessFactorizer implements Servlet {

    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        BigInteger i = extractFromRequest(servletRequest);
        BigInteger[] factors = factor(i);
        encodeIntoResPonse(servletResponse,factors);
    }


    private void encodeIntoResPonse(ServletResponse servletResponse, BigInteger[] factors) {
        /*因式分解结果响应输出*/
    }

    private BigInteger[] factor(BigInteger i) {
        /*因式分解i*/
        return new BigInteger[0];
    }

    private BigInteger extractFromRequest(ServletRequest servletRequest) {
        /*从请求获取因式分解参数*/
        return null;
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
