package io.github.johnshen1990.javacodelab.javabasic.consistenthashing;

import com.google.common.hash.Hashing;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HashingHelper {
    public static Map<String, String> generateEntries(int size) {
        Map<String, String> generateEntries = new HashMap<>();

        // 生成100w个entry, 并存储到cluster上
        for(int i = 0; i < size; i++) {
            String key = UUID.randomUUID().toString();
            generateEntries.put(key, key + "|" + i);
        }

        return generateEntries;
    }

    /**
     * 使用murmur32作为hash算法可以使散列更均匀且效率更高
     * @param key
     * @return
     */
    public static int murmur32Hashing(String key) {
        return Hashing.murmur3_32().hashString(key, Charset.forName("UTF-8")).asInt();
    }
}
