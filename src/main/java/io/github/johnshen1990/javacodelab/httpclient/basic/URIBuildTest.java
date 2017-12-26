package io.github.johnshen1990.javacodelab.httpclient.basic;

import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Author: zhun.shen
 * Date: 2016-04-13 14:53
 * Description:
 */
public class URIBuildTest {
    public static void main(String[] args) {
        URI myUri = null;
        try {
            myUri = new URIBuilder()
                    .setScheme("https")
                    .setHost("www.baidu.com")
//                    .setPort(80)
                    .setPath("/")
                    .setParameter("from", "hah")
                    .setParameter("age", "12")
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        System.out.println(myUri.toString());
    }
}
