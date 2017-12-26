package io.github.johnshen1990.javacodelab.javabasic.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import org.jsoup.nodes.Element;

/**
 * Author: zhun.shen
 * Date: 2016-10-23 16:24
 * Description:
 */
public class JsoupDemo {
    public static void main(String[] args) {
        Document doc = null;
        try {
            doc = Jsoup.connect("").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elements = doc.body().children().tagName("ul");
        Element list = null;
        for(Element element : elements){
            if(element.hasClass("list")){
                list = element;
                break;
            }
        }
        for(Element element : list.children().tagName("li").tagName("a")){
            System.out.println(element);
        }
//        System.out.println(doc.toString());

    }
}
