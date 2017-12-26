package io.github.johnshen1990.javacodelab.httpclient.basic;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.message.BasicHttpResponse;

/**
 * Author: zhun.shen
 * Date: 2016-04-13 15:20
 * Description:
 */
public class HTTPResponseTest {
    public static void main(String[] args) {
        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");

        System.out.println(response.getProtocolVersion());
        System.out.println(response.getStatusLine().getStatusCode());
        System.out.println(response.getStatusLine().getReasonPhrase());
        System.out.println(response.getStatusLine().toString());
    }
}
