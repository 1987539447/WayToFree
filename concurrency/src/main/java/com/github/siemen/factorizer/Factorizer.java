package com.github.siemen.factorizer;
/**
 * Created by Zhan on 2017-06-22.
 */

import com.github.siemen.memoizer.Computable;
import com.github.siemen.memoizer.Memoizer;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

/**
 * 使用Memoizer实现的缓存
 * 分离计算和缓存
 */
public class Factorizer implements Servlet {

    private final Computable<BigInteger,BigInteger[]> computable = arg -> factor(arg);
    private final Computable<BigInteger,BigInteger[]> cache = new Memoizer<>(computable);

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {


        BigInteger i = extractFromRequest(servletRequest);
        try {
            encodeIntoResPonse(servletResponse,cache.compute(i));
        } catch (InterruptedException e) {
            e.printStackTrace();
            encodeError(servletResponse,"factorization interuppted~~");
        }

    }

    private void encodeError(ServletResponse servletResponse, String s) throws IOException {
        servletResponse.getWriter().write(s);
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

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
