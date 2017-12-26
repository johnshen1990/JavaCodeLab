package io.github.johnshen1990.javacodelab.javabasic.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;

/**
 * Author: zhun.shen
 * Date: 2017-06-29 16:46
 * Description:
 */
public class GuavaBiMap {
    public static void main(String[] args) {
        BiMap<String, Integer> bm = HashBiMap.create();
        bm.put("1", 4);
        bm.put("2", 5);
        bm.put("3", 6);

        System.out.println(bm.inverse().get(4));


        Multiset<String> multiset = ImmutableMultiset.<String>builder().build();
        multiset.add("1");
        multiset.add("2");
        multiset.add("1");
        multiset.add("3");

    }
}
