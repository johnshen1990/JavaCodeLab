package io.github.johnshen1990.javacodelab.httpclient.basic;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


/**
 * Author: zhun.shen
 * Date: 2016-04-15 17:39
 * Description:
 */
public enum SingletonHttpClient {
    INSTANCE;

    private CloseableHttpClient closeableHttpClient;

    SingletonHttpClient(){
        closeableHttpClient = HttpClients.createDefault();
    }

    public CloseableHttpClient getHttpClient(){
        return this.closeableHttpClient;
    }
}
