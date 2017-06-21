package com.github.siemen.factorizer;
/**
 * Created by Zhan on 2017-06-19.
 */

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 通过AtomicInteger计数
 * 基本类型的原子封装，提供一些操作的原子化
 */
public class CountingFacotrizer implements Servlet{

    private AtomicInteger count = new AtomicInteger(0);

    public long getCount(){
        return count.get();
    }

    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        BigInteger i = extractFromRequest(servletRequest);
        BigInteger[] factors = factor(i);
        count.incrementAndGet();
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
