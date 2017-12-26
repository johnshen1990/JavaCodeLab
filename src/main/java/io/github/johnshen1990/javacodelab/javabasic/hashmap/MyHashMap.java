package io.github.johnshen1990.javacodelab.javabasic.hashmap;

/**
 * Author: zhun.shen
 * Date: 2017-03-22 11:22
 * Description:
 */
public class MyHashMap<K, V> implements MyMap<K, V> {
    // 默认的桶大小
    private final static int DEFAULT_CAPACITY = 1 << 4;

    // 默认加载因子
    private final static float DEFAULT_LOADFACTOR = 0.75f;

    // 加载因子
    private float loadfactor;

    // 用一个数组存储元素
    private Entry[] buckets;

    // 已使用的桶的个数
    private int size;

    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOADFACTOR);
    }

    public MyHashMap(int capacity, float loadfactor) {
        this.loadfactor = loadfactor;
        this.size = 0;
        buckets = new Entry[capacity];
    }

    @Override
    public V put(K key, V value) {

        // 如果需要扩容,先执行扩容操作
        if(needResize()) {
            resize();
        }

        // 取模得到当前key对应的桶下标
        int index = getIndex(key, buckets.length);

        if(buckets[index] == null) {
            Entry<K, V> newElement = new Entry<>(key, value, null);
            buckets[index] = newElement;
            size ++;
        } else {
            Entry<K, V> oldElement = buckets[index];
            Entry<K, V> newElement = new Entry<>(key, value, oldElement);
            buckets[index] = newElement;
            // 此处不应再对size++
        }

        return value;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key, buckets.length);
        if(buckets[index] != null) {
            Entry head = buckets[index];
            while (head != null) {
                if(key.equals(head.getKey())) {
                    return (V)head.getKey();
                }
                head = head.next;
            }
        }
        return null;
    }


    /**
     * 当(已使用的桶的个数 >= 桶的总数 * 加载因子)时, 需要扩容
     * @return 是否需要扩容
     */
    private boolean needResize() {
        return size >= buckets.length * loadfactor;
    }

    private int getIndex(K key, int capacity) {
        return key.hashCode() % capacity;
    }

    private void resize() {
        // 创建一个新数组, 扩容为原数组的2倍
        Entry[] newBuckets = new Entry[buckets.length * 2];
        // 遍历原数组中的全部entry, rehash后放入扩容后的新数组
        size = rehash(newBuckets);
        // 扩容后的数组代替原数组
        buckets = newBuckets;
    }

    /**
     * 重新计算每个元素的hash,并放入新的数组中
     * @param newBuckets
     * @return 新数组中已使用的桶的个数
     */
    private int rehash(Entry[] newBuckets){
        int newSize = 0;
        for(Entry entry : buckets) {
            if(entry == null) {
                continue;
            }

            // 创建一个头指针,指向链表的头元素
            Entry head = entry.next;
            do { // 遍历链表
                int newIndex = getIndex((K)entry.getKey(), newBuckets.length);
                if(newBuckets[newIndex] == null) {
                    entry.next = null;
                    newSize ++;
                } else {
                    entry.next = newBuckets[newIndex];
                }
                newBuckets[newIndex] = entry;
            } while (head != null);
        }
        return newSize;
    }

    class Entry<K, V> implements MyMap.Entry<K, V>{
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V setValue(V value) {
            return this.value = value;
        }

        @Override
        public V getValue() {
            return this.value;
        }
    }


}
