package com.github.siemen.factorizer;
/**
 * Created by Zhan on 2017-06-19.
 */

import com.github.siemen.annotation.NotThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 非线程安全因式分解结果缓存
 * 虽然都使用原子引用来缓存结果，但两次赋值操作不是原子操作
 * 可能导致获取到错误结果
 * 可对整个操作service方法加synchronized同步限制，但降低了响应
 */
@NotThreadSafe
public class UnsafeCachingFactorizer implements Servlet {

    /*分别存储上次分解的数和结果*/
    private AtomicReference<BigInteger> lastNumber = new AtomicReference<BigInteger>();
    private AtomicReference<BigInteger[]> lastFactors = new AtomicReference<BigInteger[]>();

    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        BigInteger i = extractFromRequest(servletRequest);
        if(i.equals(lastNumber.get())){//与上次相同
            encodeIntoResPonse(servletResponse,lastFactors.get());
        }else{
            BigInteger[] factors = factor(i);
            lastNumber.set(i);/*两个操作之间与其他线程并发，导致获取到错误结果*/
            lastFactors.set(factors);
            encodeIntoResPonse(servletResponse,factors);
        }

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
