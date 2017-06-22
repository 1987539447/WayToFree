package com.github.siemen.barrier;
/**
 * Created by Zhan on 2017-06-22.
 */

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 循环栅栏CyclicBarrier
 * ...把一个细胞的计算分成多个部分分别计算，完成后汇总结果
 * 每个计算线程完成后通过barrier.await等待
 */
public class CellularAutomata {
    private final Board mainBoard;
    private final CyclicBarrier barrier;
    private final Worker[] workers;

    public CellularAutomata(Board board) {
        this.mainBoard = board;
        int count = Runtime.getRuntime().availableProcessors();
        barrier = new CyclicBarrier(count, () -> mainBoard.commitNewValues());
        this.workers = new Worker[count];
        for (int i = 0; i < count; i++) {
            workers[i] = new Worker(this.mainBoard.getSubBoard(count,i));
        }
    }
    
    public void start(){
        for (int i = 0; i < workers.length; i++) {
            new Thread(workers[i]).start();
        }
        this.mainBoard.waitForConvergence();
    }

    private class Board {
        private int maxX;
        private int maxY;
        private double value;

        private Board(int maxX, int maxY) {
            this.maxX = maxX;
            this.maxY = maxY;
        }

        public void commitNewValues() {
            System.out.println("------all part done,sum-----");
            double result = 0;
            for (Worker worker : workers) {
                result += worker.board.value;
            }
            System.out.println("--------result value-----"+result);
        }

        public Board getSubBoard(int count, int i) {

            return new Board(this.maxX/count*i,this.maxY/count*i);
        }

        public boolean hasConvered() {
            return false;
        }

        public int getMaxX() {
            return maxX;
        }

        public int getMaxY() {
            return maxY;
        }

        public void setNewValue(int x, int y, double value) {
            this.value = value;
        }

        public void waitForConvergence() {

        }
    }

    private class Worker implements Runnable{

        private final Board board;
        public Worker(Board board){
            this.board = board;
        }

        @Override
        public void run() {
            while (!board.hasConvered()) {
                for (int x = 0; x < board.getMaxX(); x++) {
                    for (int y = 0; y < board.getMaxY(); y++) {
                        board.setNewValue(x, y, computeValue(x, y));
                    }
                }
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    private double computeValue(int x, int y) {
        return 0;
    }
}
