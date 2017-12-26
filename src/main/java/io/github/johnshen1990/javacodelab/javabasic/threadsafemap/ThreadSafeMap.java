package io.github.johnshen1990.javacodelab.javabasic.threadsafemap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeMap<K, V> implements Map<K, V> {
    private Map<K, V> unsafeMap = new HashMap<>();
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private Lock readLock = rwl.readLock();
    private Lock writeLock = rwl.writeLock();

    @Override
    public int size() {
        readLock.lock();
        try {
            return unsafeMap.size();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public boolean isEmpty() {
        readLock.lock();
        try {
            return unsafeMap.isEmpty();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public boolean containsKey(Object key) {
        readLock.lock();
        try {
            return unsafeMap.containsKey(key);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public boolean containsValue(Object value) {
        readLock.lock();
        try {
            return unsafeMap.containsValue(value);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public V get(Object key) {
        readLock.lock();
        try {
            return unsafeMap.get(key);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public V put(K key, V value) {
        writeLock.lock();
        try {
            return unsafeMap.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }


    @Override
    public V remove(Object key) {
        writeLock.lock();
        try {
            return unsafeMap.remove(key);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        writeLock.lock();
        try {
            unsafeMap.putAll(m);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void clear() {
        writeLock.lock();
        try {
            unsafeMap.clear();
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public Set<K> keySet() {
        readLock.lock();
        try {
            return unsafeMap.keySet();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public Collection<V> values() {
        readLock.lock();
        try {
            return unsafeMap.values();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        readLock.lock();
        try {
            return unsafeMap.entrySet();
        } finally {
            readLock.unlock();
        }
    }
}
