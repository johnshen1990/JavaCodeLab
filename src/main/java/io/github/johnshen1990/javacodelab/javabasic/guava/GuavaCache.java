package io.github.johnshen1990.javacodelab.javabasic.guava;

import com.google.common.base.Optional;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.ImmutableList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * Author: zhun.shen
 * Date: 2017-03-23 19:54
 * Description:
 */
public class GuavaCache {
    Cache<String, List<String>> poiCache = CacheBuilder.newBuilder().build();

    @SuppressWarnings("unchecked")
    public List<String> getPOIList(final String cityId) {
        List returnList = null;
        try {
            returnList = poiCache.get(cityId, new Callable<List<String>>() {
                @Override
                public List<String> call(){
                    return getPOIListFromDB(cityId);
                }
            });
        } catch (ExecutionException e) {
            // 记日志
        }
        return Optional.fromNullable(returnList).or(Collections.EMPTY_LIST);
    }

    @SuppressWarnings("unchecked")
    private List<String> getPOIListFromDB(String cityId){
        System.out.println("getting from DB, please wait...");
        List<String> returnList = null;
        // 模仿从数据库中取数据
        try {
            Thread.sleep(1000);
            switch (cityId){
                case "0101" :
                    returnList = ImmutableList.of("望京", "望京西", "望京南", "望京北"); break;
                case "0102" :
                    returnList = ImmutableList.of("a", "b", "c", "d"); break;
            }
        } catch (Exception e) {
            // 记日志
        }
        return returnList;
//        return Optional.fromNullable(returnList).or(Collections.EMPTY_LIST);
    }

    public static void main(String[] args) {
        GuavaCache bean = new GuavaCache();

        for (int i = 0; i < 3; i++) {
            System.out.println("--- " + i + " ---");
            System.out.println(Arrays.toString(bean.getPOIList("0101").toArray()));
            System.out.println(Arrays.toString(bean.getPOIList("0102").toArray()));
            System.out.println(Arrays.toString(bean.getPOIList("0103").toArray()));
            System.out.println(Arrays.toString(bean.getPOIList("0104").toArray()));
            System.out.println();
        }
    }
}
