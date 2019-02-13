package org.happybean.netty.asyn.callbacks;

/**
 * @author wgt
 * @date 2019-02-13
 * @description
 **/
public interface Fetcher {
    void fetchData(FetcherCallback callback);
}
