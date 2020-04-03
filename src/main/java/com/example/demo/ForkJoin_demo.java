package com.example.demo;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
public class ForkJoin_demo extends RecursiveTask<Integer> {  //RecursiveTask 有返回值
    //(3)第三步初始化 任务ForkJoin_demo
    private static final int THRESHOLD = 2;  // 阈值
    private int start;  private int end;
    public ForkJoin_demo(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    protected Integer compute() {   // (5)第五步具体执行任务（重写compute）
        int sum = 0;
        // 如果任务足够小就计算任务（重点理解）
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
           // 如果任务大于阈值，就分裂成两个子任务计算
            int middle = (start + end) / 2;
            ForkJoin_demo leftTask = new ForkJoin_demo(start, middle);
            ForkJoin_demo rightTask = new ForkJoin_demo(middle + 1, end);
            // 执行子任务
            leftTask.fork();
            rightTask.fork();
            // 等待子任务执行完，并得到其结果
            int leftResult=leftTask.join();
            int rightResult=rightTask.join();
            // 合并子任务
            sum = leftResult + rightResult;
        }
        return sum;
    }
    public static void main(String[] args) {
        //（1）第一步实例化ForkJoinPool
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // （2）第二步生成一个计算任务，负责计算1+2+3+4
        ForkJoin_demo task = new ForkJoin_demo(1, 4);
        // (4)第四步开始执行一个任务
        Future<Integer> result = forkJoinPool.submit(task);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
        }
    }
}
