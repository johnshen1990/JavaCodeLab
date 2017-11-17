package io.github.johnshen1990.javacodelab.javabasic.consistenthashing;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Cluster {
    private Set<RedisServer> realServerHolder = new HashSet<>();

    // 使用有序的Map模拟有序的环，key为虚拟server的hashcode，value为虚拟server对应的真实server
    private SortedMap<Integer, RedisServer> virtualServerHolder = new TreeMap<>();

    // 向cluster中添加一台server
    public boolean addServer(RedisServer redisServer) {
        // 容错判断
        if(redisServer == null || realServerHolder.contains(redisServer)) {
            return false;
        }
        realServerHolder.add(redisServer);
        Set<VirtualRedisServer> virtualRedisServerSet = redisServer.getVirtualRedisServerSet();
        for(VirtualRedisServer virtualRedisServer : virtualRedisServerSet) {
            int virtualServerHashCode = virtualRedisServer.hashCode();
            // 如果虚拟节点的hash冲突，则跳过这个虚拟节点，即保证老节点不被覆盖
            if(!virtualServerHolder.containsKey(virtualServerHashCode)) {
                virtualServerHolder.put(virtualRedisServer.hashCode(), virtualRedisServer.getRedisServer());
            }
        }
        return true;
    }

    // 从cluster中删除一台server
    public boolean removeServer(RedisServer redisServer) {
        // 容错判断
        if(redisServer == null || !realServerHolder.contains(redisServer)) {
            return false;
        }
        Set<VirtualRedisServer> virtualRedisServerSet = redisServer.getVirtualRedisServerSet();
        for(VirtualRedisServer virtualRedisServer : virtualRedisServerSet) {
            if(virtualServerHolder.containsKey(virtualRedisServer.hashCode())) {
                virtualServerHolder.remove(virtualRedisServer.hashCode());
            }
        }
        realServerHolder.remove(redisServer);
        return true;
    }

    // 对entry的hashCode做路由，决定该entry应该被分配到哪台RedisServer上去读写
    private RedisServer route(int hashCode) {
        // 集群中没有server
        if(virtualServerHolder.isEmpty()) {
            return null;
        }

        // key的hashCode并没有恰好命中虚拟Server时，则延顺时针方向找第一个虚拟Server
        if(!virtualServerHolder.containsKey(hashCode)) {
            // tailMap可以返回大于等于hashCode的map的视图
            SortedMap<Integer, RedisServer> tailMap = virtualServerHolder.tailMap(hashCode);
            return tailMap.isEmpty() ? virtualServerHolder.get(virtualServerHolder.firstKey())
                    : tailMap.get(tailMap.firstKey());
        }
        // hashCode恰好命中了虚拟Server，则直接返回
        return virtualServerHolder.get(hashCode);
    }

    public String get(String key) {
        RedisServer redisServer = route(HashingHelper.murmur32Hashing(key));
        if(redisServer == null) {
            // TODO throw EmptyClusterException
        }
        return redisServer.get(key);
    }

    public void put(String key, String value) {
        RedisServer redisServer = route(HashingHelper.murmur32Hashing(key));
        if(redisServer == null) {
            // TODO throw EmptyClusterException
        }
        redisServer.put(key, value);
    }

    public void summary() {
        for(RedisServer redisServer : realServerHolder) {
            redisServer.summary();
            System.out.println();
            System.out.println();
        }
    }

}