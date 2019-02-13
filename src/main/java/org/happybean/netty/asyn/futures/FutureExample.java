package org.happybean.netty.asyn.futures;

/**
 * @author wgt
 * @date 2019-02-13
 * @description 第二种技术是使用Futures。
 * Futures是一个抽象的概念，它表示一个值，该值可能在某一点变得可用。
 * 一个Future要么获得 计算完的结果，要么获得计算失败后的异常。
 * Java在java.util.concurrent包中附带了Future接口，它使用Executor异步执行。
 * 例 如下面的代码，每传递一个Runnable对象到ExecutorService.submit()方法就会得到一个回调的Future，你能使用它检测是否执行 完成。
 **/

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                //do something

                System.out.println("i am task1.....");
            }
        };
        Callable<Integer> task2 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                //do something
                return new Integer(100);
            }
        };
        Future<?> f1 = executor.submit(task1);
        Future<Integer> f2 = executor.submit(task2);
        System.out.println("task1 is completed? " + f1.isDone());
        System.out.println("task2 is completed? " + f2.isDone());
        //waiting task1 completed
        while (f1.isDone()) {
            System.out.println("task1 completed.");
            break;
        }
        //waiting task2 completed
        while (f2.isDone()) {
            System.out.println("return value by task2: " + f2.get());
            break;
        }
        executor.shutdown();
    }

//    有时候使用Future感觉很丑陋，因为你需要间隔检查Future是否已完成，
//    而使用回调会直接收到返回通知。
//    看完这两个常用 的异步执行技术后，你可能想知道使用哪个最好?
//    这里没有明确的答案。事实上，Netty两者都使用，提供两全其美的方案
}
