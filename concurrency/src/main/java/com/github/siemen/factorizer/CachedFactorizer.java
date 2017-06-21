package com.github.siemen.factorizer;
/**
 * Created by Zhan on 2017-06-19.
 */

import com.github.siemen.annotation.GuardedBy;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

/**
 * 缓存请求和分解结果
 * 通过synchroinzed关键字加内部锁
 * 仅对需要同步操作加锁而不是整个方法
 */
public class CachedFactorizer implements Servlet{

    /**上次分解数字和结果*/
    @GuardedBy("this")
    private BigInteger lastNumber;
    @GuardedBy("this")
    private BigInteger[] lastFactors;
    /**请求次数和缓存命中次数*/
    @GuardedBy("this")
    private long hits;
    @GuardedBy("this")
    private long cacheHits;

    public synchronized long getHits(){return this.hits;}
    public synchronized double getCacheHitRatio(){
        return (double) cacheHits/hits;
    }

    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        BigInteger i = extractFromRequest(servletRequest);
        BigInteger[] factors = null;
        synchronized (this){//内部锁同步，同时保证点击数和命中自增的原子性
            ++hits;
            if(i.equals(lastNumber)){//与上次相同
                ++cacheHits;
                encodeIntoResPonse(servletResponse,lastFactors);
            }
        }
        if(factors == null){//没取到缓存
            factors = factor(i);
            synchronized (this){//通过内部锁保证操作同步
                lastNumber = i;
                lastFactors= factors;
            }

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
