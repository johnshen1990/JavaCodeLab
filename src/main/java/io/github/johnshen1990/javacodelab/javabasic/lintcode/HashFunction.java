package io.github.johnshen1990.javacodelab.javabasic.lintcode;

/**
 * Author: zhun.shen
 * Date: 2017-03-19 16:42
 * Description:
 */
public class HashFunction {
    public int hashCode(char[] key,int HASH_SIZE) {
        long hashCode = 0;
        for(int i = 0; i < key.length; i++) {
            hashCode = (hashCode * 33 + (int)key[i]) % HASH_SIZE;
        }
        return (int)hashCode;
    }
}
