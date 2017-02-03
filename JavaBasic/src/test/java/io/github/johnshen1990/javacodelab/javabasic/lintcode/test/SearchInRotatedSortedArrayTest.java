package io.github.johnshen1990.javacodelab.javabasic.lintcode.test;

import io.github.johnshen1990.javacodelab.javabasic.lintcode.SearchInRotatedSortedArray;
import org.junit.Assert;
import org.junit.Test;

/**
 * Author: zhun.shen
 * Date: 2017-02-03 15:37
 * Description:
 */
public class SearchInRotatedSortedArrayTest {
    @Test
    public void testSearch(){
        int[] nums = new int[]{4, 5, 1, 2, 3};
        int result1 = new SearchInRotatedSortedArray().search(nums, 1);
        int result2 = new SearchInRotatedSortedArray().search(nums, 0);
        Assert.assertTrue(result1 == 2);
        Assert.assertTrue(result2 == -1);
    }
}
