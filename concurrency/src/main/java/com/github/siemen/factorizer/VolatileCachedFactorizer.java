package com.github.siemen.factorizer;
/**
 * Created by Zhan on 2017-06-19.
 */

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

/**
 * 使用不可变容器+volatile缓存因式分解
 * 不可变容器对象创建后不会被任何线程修改，所以不会出现数据不一致问题
 * 没缓存时，新创建一个不可变容器实例来更新volatile引用
 */
public class VolatileCachedFactorizer implements Servlet {

    private volatile OneValueCache cache = new OneValueCache(null,null);


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        BigInteger i = extractFromRequest(servletRequest);
        BigInteger[] factors = cache.getFactors(i);
        if(factors == null){//没缓存时
            factors = factor(i);
            cache = new OneValueCache(i,factors);//不可变，重新构建对象
        }
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

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
