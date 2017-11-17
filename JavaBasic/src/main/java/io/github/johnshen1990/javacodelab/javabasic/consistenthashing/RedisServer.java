package io.github.johnshen1990.javacodelab.javabasic.consistenthashing;

import java.util.*;

public class RedisServer {
    // 每台真实的server被扩展的虚拟server数
    private final static int NUM_OF_VIRTUAL = 2000;

    private String hostName;
    private Set<VirtualRedisServer> virtualRedisServerSet = new HashSet<>();

    // 用于模拟redis的数据存储
    private Map<String, String> data = new HashMap<>();

    RedisServer(String hostName) {
        this.hostName = hostName;
        for(int i = 0; i < NUM_OF_VIRTUAL; i++) {
            // 虚拟server的hostName是通过真实server的hostName扩展的。(比如：LID-Server#1, LID-Server#2)
            String virtualRedisServerHostName = hostName + "#" + i;
            virtualRedisServerSet.add(new VirtualRedisServer(virtualRedisServerHostName, this));
        }
    }

    public Set<VirtualRedisServer> getVirtualRedisServerSet() {
        return virtualRedisServerSet;
    }

    public String get(String key) {
        return data.get(key);
    }

    public void put(String key, String value) {
        data.put(key, value);
    }

    public void summary() {
        System.out.println(this.hostName);
        System.out.println("---------------");
        System.out.println("count of entries:" + data.size());
    }
}