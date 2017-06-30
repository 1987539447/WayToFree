package com.github.siemen.chapter08;
/**
 * Created by Zhan on 2017-06-29.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 可感知答案不存在的解决方案
 * 增加线程计数，当全部线程都结束仍没有答案，则答案为null
 */
public class PuzzleSolver<P,M> extends ConcurrentPuzzleSolver<P,M> {

    private final AtomicInteger taskCount = new AtomicInteger();
    public PuzzleSolver(Puzzle<P, M> puzzle, ExecutorService executor) {
        super(puzzle, executor);
    }


    @Override
    protected Runnable newTask(P p, M m, Node<P, M> pre) {
        return new CountingSolverTask(p,m,pre);
    }

    class CountingSolverTask extends SolveTask {//增加线程计数
        public CountingSolverTask(P p, M m, Node<P, M> pre) {
            super(p,m,pre);
            taskCount.incrementAndGet();
        }

        @Override
        public void run() {
            try {
                super.run();
            }finally {
                if(taskCount.decrementAndGet() == 0){//所有线程都执行完
                    solution.setValue(null);
                }
            }
        }
    }
}
