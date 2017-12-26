package io.github.johnshen1990.javacodelab.javabasic.lintcode.test;

import io.github.johnshen1990.javacodelab.javabasic.lintcode.binarysearch.WoodCut;
import org.junit.Assert;
import org.junit.Test;

/**
 * Author: zhun.shen
 * Date: 2017-02-03 12:25
 * Description:
 */
public class WoodCutTest {
    @Test
    public void testWoodCut(){
        int[] L = new int[]{232, 124, 456};
        int k = 7;
        int result = new WoodCut().woodCut(L, k);
        Assert.assertTrue(result == 114);
    }
}
