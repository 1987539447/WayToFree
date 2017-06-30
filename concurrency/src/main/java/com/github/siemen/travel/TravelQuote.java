package com.github.siemen.travel;
/**
 * Created by Zhan on 2017-06-23.
 */

import java.util.*;
import java.util.concurrent.*;

/**
 * 获得不同公司旅游报价
 * 根据旅行信息TravelInfo，从指定公司Set<TravelCompany>按指定排序
 * 在指定时间内返回报价信息
 */
public class TravelQuote {

    private final ExecutorService executor;

    public TravelQuote(ExecutorService executor) {
        this.executor = executor;
    }

    public List<TravelQuote> getRankedTravelQuote(TravelInfo travelInfo, Set<TravelCompany> companys, Comparator<TravelQuote> ranking,long time,TimeUnit unit) throws InterruptedException {
        //构建任务信息
        List<QuoteTask> tasks = new ArrayList<>();
        for (TravelCompany company : companys) {
            tasks.add(new QuoteTask(company,travelInfo));
        }
        //批量提交任务,限时执行返回
        List<Future<TravelQuote>> futures = executor.invokeAll(tasks,time,unit);
        List<TravelQuote> quoteList = new ArrayList<>(tasks.size());
        Iterator<QuoteTask> iter = tasks.iterator();
        //处理任务结果
        for (Future<TravelQuote> future : futures) {
            QuoteTask task = iter.next();
            try {
                quoteList.add(future.get());
            } catch (ExecutionException e) {//执行异常显示内容
                e.printStackTrace();
                quoteList.add(task.getFailureQuote(e.getCause()));
            }catch (CancellationException e){//超时-取消异常显示内容
                quoteList.add(task.getTimeoutQuote(e));
            }
        }
        //排序并返回
        Collections.sort(quoteList,ranking);
        return quoteList;

    }


    private class QuoteTask implements Callable<TravelQuote> {

        private final TravelCompany company;
        private final TravelInfo travelInfo;

        private QuoteTask(TravelCompany company, TravelInfo travelInfo) {
            this.company = company;
            this.travelInfo = travelInfo;
        }

        @Override
        public TravelQuote call() throws Exception {
            return this.company.solicitQuote(travelInfo);
        }

        public TravelQuote getTimeoutQuote(CancellationException e) {
            return null;
        }

        public TravelQuote getFailureQuote(Throwable cause) {
            return null;
        }
    }

    private class TravelCompany {
        public TravelQuote solicitQuote(TravelInfo travelInfo) {
            //调用远程服务获取报价
            return null;
        }
    }

    private class TravelInfo {
    }
}
