package io.github.johnshen1990.javacodelab.javabasic.lintcode.test;

import io.github.johnshen1990.javacodelab.javabasic.lintcode.FindMinimumInRotatedSortedArray;
import org.junit.Assert;
import org.junit.Test;

/**
 * Author: zhun.shen
 * Date: 2017-02-03 12:57
 * Description:
 */
public class FindMinimumInRotatedSortedArrayTest {
    @Test
    public void findMinTest(){
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int result = new FindMinimumInRotatedSortedArray().findMin(nums);
        Assert.assertTrue(result == 0);
    }
}
