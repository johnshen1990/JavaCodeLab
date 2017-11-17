package io.github.johnshen1990.javacodelab.javabasic.consistenthashing;


public class VirtualRedisServer{
    // 虚拟节点的名称
    private String hostName;
    // 虚拟节点持有真实节点的引用
    private RedisServer redisServer;

    VirtualRedisServer(String hostName, RedisServer redisServer) {
        this.hostName = hostName;
        this.redisServer = redisServer;
    }

    public RedisServer getRedisServer() {
        return redisServer;
    }

    @Override
    public int hashCode() {
        return HashingHelper.murmur32Hashing(this.hostName);
    }
}