package io.github.johnshen1990.javacodelab.javabasic.hashmap;

/**
 * Author: zhun.shen
 * Date: 2017-03-23 18:19
 * Description:
 */
public class MyHashMapTester {
    public static void main(String[] args) {
        MyMap map = new MyHashMap();
        for(int i = 0; i < 100; i++) {
            map.put("key" + i, "value" + i);
        }
        for(int i = 0; i < 100; i++) {
            System.out.println("key=" + "key" + i + ", value=" + map.get("key" + i));
        }
    }
}
