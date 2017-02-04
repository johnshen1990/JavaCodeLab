package io.github.johnshen1990.javacodelab.javabasic.lintcode.binarysearch;

/**
 * Author: zhun.shen
 * Date: 2017-02-03 12:05
 * Description:
 * <p/>
 * 有一些原木，现在想把这些木头切割成一些长度相同的小段木头，需要得到的小段的数目至少为 k。
 * 当然，我们希望得到的小段越长越好，你需要计算能够得到的小段木头的最大长度。
 * <p/>
 * 注意事项:
 * 木头长度的单位是厘米。原木的长度都是正整数，我们要求切割得到的小段木头的长度也要求是整数。
 * 无法切出要求至少 k 段的,则返回 0 即可。
 * <p/>
 * 样例
 * 有3根木头[232, 124, 456], k=7, 最大长度为114.
 */
public class WoodCut {

    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     *           return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // 头指针从1开始
        int start = 1;
        int maxWood = 0;
        for (int i : L) {
            if (i > maxWood) {
                maxWood = i;
            }
        }
        int end = maxWood;

        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (count(L, mid) == k) {
                start = mid;
            } else if (count(L, mid) < k) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (count(L, end) >= k) {
            return end;
        }
        if (count(L, start) >= k) {
            return start;
        }

        return 0;
    }


    /**
     * 返回length长度下能切出的最大木头数
     *
     * @param L
     * @param length
     * @return
     */
    private int count(int[] L, int length) {
        int sum = 0;
        for (int i : L) {
            sum += i / length;
        }
        return sum;
    }
}
