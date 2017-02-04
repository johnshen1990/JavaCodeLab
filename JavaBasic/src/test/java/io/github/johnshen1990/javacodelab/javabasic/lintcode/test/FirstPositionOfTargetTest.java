package io.github.johnshen1990.javacodelab.javabasic.lintcode.test;

import io.github.johnshen1990.javacodelab.javabasic.lintcode.binarysearch.FirstPositionOfTarget;
import org.junit.Assert;
import org.junit.Test;

/**
 * Author: zhun.shen
 * Date: 2017-02-03 11:13
 * Description:
 */
public class FirstPositionOfTargetTest {
    @Test
    public void testBinarySearch(){
        int[] nums = new int[]{1, 2, 3, 3, 4, 5, 10};
        int position = new FirstPositionOfTarget().binarySearch(nums, 3);
        Assert.assertTrue(position == 2);
    }
}
