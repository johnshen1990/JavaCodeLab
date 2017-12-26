package io.github.johnshen1990.javacodelab.javabasic.hashmap;

/**
 * Author: zhun.shen
 * Date: 2017-03-22 11:13
 * Description:
 */
public interface MyMap<K, V> {
    V put(K k, V v);
    V get(K k);

    interface Entry<K, V> {
        K getKey();
        V setValue(V value);
        V getValue();
    }
}
