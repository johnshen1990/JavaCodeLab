package io.github.johnshen1990.javacodelab.javabasic.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Author: zhun.shen
 * Date: 2016-05-13 17:27
 * Description:
 */
public class URLEncodeTest {

    public static String appendParaToEncodedUrl(String encodedUrl, String paraName, String paraValue){
        if(encodedUrl.toUpperCase().contains("%3F")){ // 如果包含?
            return encodedUrl + "%26" + paraName + "%3D" + paraValue;
        }else{
            return encodedUrl + "%3F" + paraName + "%3D" + paraValue;
        }
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String src = "http://www.baidu.com/?from=123";
        String src1 = "http://www.baidu.com/";
        System.out.println(appendParaToEncodedUrl(URLEncoder.encode(src, "UTF-8"), "ref", "elong"));
        System.out.println(appendParaToEncodedUrl(URLEncoder.encode(src1, "UTF-8"), "ref", "elong"));
    }
}
