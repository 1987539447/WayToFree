package com.github.siemen.juc;
/**
 * Created by Zhan on 2017-05-27.
 */

import java.util.*;
import java.util.concurrent.*;

/**
 * 根据旅游信息查询不同公司报价
 * 任务封装：根据旅行信息从指定公司获取报价
 * invokeAll 提交批量任务，指定超时时间，返回future列表
 */
public class TravelQuoteSearch {

    private final ExecutorService executor;

    public TravelQuoteSearch(ExecutorService executor) {
        this.executor = executor;
    }

    private class QuoteTask implements Callable<Map>{

        private final Map<String,String> company;
        private final Map<String,String> travleInfo;

        private QuoteTask(Map company, Map travleInfo) {
            this.company = company;
            this.travleInfo = travleInfo;
        }

        @Override
        public Map call() throws Exception {
            Map<String,String> quote = new HashMap<>();
            quote.put("company",company.get("name"));
            quote.put("fromTo",travleInfo.get("from")+"--"+travleInfo.get("to"));
            quote.put("quote","12345678");
            return quote;
        }

        public Map getFailureQuote(Throwable cause) {
            Map<String,String> result = new HashMap<>();
            result.put("fail",cause.getMessage());
            return result;
        }

        public Map getTimeOutQuote(CancellationException e) {
            Map<String,String> result = new HashMap<>();
            result.put("timeOut",e.getMessage());
            return result;
        }
    }


    public List<Map> getRankedTravleQuotes(Map<String,String> travleInfo, Set<Map<String,String>> companies,
                                           Comparator<Map> ranking, long time, TimeUnit unit) throws InterruptedException {

        //构建批次任务
        List<QuoteTask> taskList = new ArrayList<>();
        for (Map<String, String> company : companies) {
            taskList.add(new QuoteTask(company,travleInfo));
        }
        List<Future<Map>> futureList = executor.invokeAll(taskList,time,unit);//批量提交执行，指定超时时间
        List<Map> quoteList = new ArrayList<>(taskList.size());
        Iterator<QuoteTask> it = taskList.iterator();
        for (Future<Map> future : futureList) {
            QuoteTask task = it.next();
            try {
                quoteList.add(future.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
                quoteList.add(task.getFailureQuote(e.getCause()));
            }catch (CancellationException e){
                quoteList.add(task.getTimeOutQuote(e));
            }
        }
        Collections.sort(quoteList,ranking);
        return quoteList;
    }
}
