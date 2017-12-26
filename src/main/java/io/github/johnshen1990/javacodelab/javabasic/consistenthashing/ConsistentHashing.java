package io.github.johnshen1990.javacodelab.javabasic.consistenthashing;

import java.util.Map;

public class ConsistentHashing {

    private Cluster cluster = new Cluster();

    private Map<String, String> entries;

    public void init(){
        // 初始化若干redisServer
        RedisServer redisServer01 = new RedisServer("LID-Server");
        RedisServer redisServer02 = new RedisServer("DDF-Server");
        RedisServer redisServer03 = new RedisServer("JHT-Server");

        // 将server加入cluster
        cluster.addServer(redisServer01);
        cluster.addServer(redisServer02);
        cluster.addServer(redisServer03);

        // 生成100w个entry, 并存储到cluster上
        entries = HashingHelper.generateEntries(1000000);

    }

    public void consistentHashing() {
        for(Map.Entry<String, String> entry : entries.entrySet()) {
            cluster.put(entry.getKey(), entry.getValue());
        }

        // 统计cluster中每个redisServer上的负载
        cluster.summary();
    }

    public static void main(String[] args) {
        ConsistentHashing test = new ConsistentHashing();
        test.init();
        test.consistentHashing();
        test.cluster.removeServer(new RedisServer("LID-Server"));
        test.cluster.summary();
    }
}
