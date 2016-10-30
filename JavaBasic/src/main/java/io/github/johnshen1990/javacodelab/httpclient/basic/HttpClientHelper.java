package io.github.johnshen1990.javacodelab.httpclient.basic;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;

/**
 * Author: zhun.shen
 * Date: 2016-04-15 17:39
 * Description:
 */
public class HttpClientHelper {
//    private static CloseableHttpClient httpClient = SingletonHttpClient.INSTANCE.getHttpClient();
    private static PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();

    static {
        cm.setMaxTotal(100);
    }
    private static CloseableHttpClient httpClient = HttpClients.custom()
            .setConnectionManager(cm)
            .build();


    public static String doGet(URI uri) throws IOException {
        HttpGet httpGet = new HttpGet(uri);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity httpEntity = httpResponse.getEntity();
        return EntityUtils.toString(httpEntity);
    }

    public static int doGetStatusCode(URI uri) throws IOException {
        HttpGet httpGet = new HttpGet(uri);
//        HttpResponse httpResponse = HttpClients.createDefault().execute(httpGet);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        return httpResponse.getStatusLine().getStatusCode();
    }
}
