package org.happybean.netty.asyn.callbacks;

/**
 * @author wgt
 * @date 2019-02-13
 * @description 回调一般是异步处理的一种技术。一个回调是被传递到并且执行完该方法。
 * 你可能认为这种模式来自JavaScript，在 Javascript中，回调是它的核心。
 * 下面的代码显示了如何使用这种技术来获取数据。下面代码是一个简单的回调
 **/
public class Worker {
    public void doWork() {
        Fetcher fetcher = new MyFetcher(new Data(1, 2));
        fetcher.fetchData(new FetcherCallback() {
            @Override
            public void onError(Throwable cause) {
                System.out.println("An error accour: " + cause.getMessage());
            }

            @Override
            public void onData(Data data) {
                System.out.println("Data received: " + data);
            }
        });
    }

    public static void main(String[] args) {
        Worker w = new Worker();
        w.doWork();
    }
}
