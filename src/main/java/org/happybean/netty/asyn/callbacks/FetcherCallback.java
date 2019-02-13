package org.happybean.netty.asyn.callbacks;

/**
 * @author wgt
 * @date 2019-02-13
 * @description
 **/
public interface FetcherCallback {
    void onData(Data data) throws Exception;
    void onError(Throwable cause);
}