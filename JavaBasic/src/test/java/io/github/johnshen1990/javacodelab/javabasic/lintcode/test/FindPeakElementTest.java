package io.github.johnshen1990.javacodelab.javabasic.lintcode.test;

import io.github.johnshen1990.javacodelab.javabasic.lintcode.FindPeakElement;
import org.junit.Assert;
import org.junit.Test;

/**
 * Author: zhun.shen
 * Date: 2017-02-03 14:36
 * Description:
 */
public class FindPeakElementTest {
    @Test
    public void testFindPeak(){
//        int[] nums = new int[]{1, 2, 1, 3, 4, 5, 7, 6};
        int[] nums = new int[]{1,10,9,8,7,6,5,4};
        int result = new FindPeakElement().findPeak(nums);
        Assert.assertTrue(result==1);
    }
}
