package com.github.siemen.factorizer;
/**
 * Created by Zhan on 2017-06-19.
 */

import com.github.siemen.annotation.NotThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

/**
 * 非线程安全的因式分解计数
 * ++操作非原子操作，并发时导致数据被覆盖
 */
@NotThreadSafe
public class UnsafeCountingFactorizer implements Servlet {

    private long count = 0;
    public long getCount(){return count;}


    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        BigInteger i = extractFromRequest(servletRequest);
        BigInteger[] factors = factor(i);
        ++count;
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
