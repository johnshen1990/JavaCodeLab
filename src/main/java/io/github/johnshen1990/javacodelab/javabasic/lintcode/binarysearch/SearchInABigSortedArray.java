package io.github.johnshen1990.javacodelab.javabasic.lintcode.binarysearch;

/**
 * Author: zhun.shen
 * Date: 2017-02-03 11:37
 * Description:
 * 给一个按照升序排序的正整数数组。
 * 这个数组很大以至于你只能通过固定的接口 ArrayReader.get(k) 来访问第k个数。
 * (或者C++里是ArrayReader->get(k))，并且你也没有办法得知这个数组有多大。
 * 找到给出的整数target第一次出现的位置。
 * 你的算法需要在O(logk)的时间复杂度内完成，k为target第一次出现的位置的下标。
 * 如果找不到target，返回-1。
 *
 * 注意事项:
 * 如果你访问了 ArrayReader 中一个不可访问的下标（比如越界），
 * ArrayReader 会返回 MAXINT = 2,147,483,647。
 *
 */
class ArrayReader {
    // get the number at index, return -1 if index is less than zero.
    public int get(int index){
        return -1;
    }
}

public class SearchInABigSortedArray {

    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        int start = 0;
        int end = 1;

        // 通过倍增,取找出目标数组的右边界
        while (reader.get(end) < target) {
            end *= 2;
        }

        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (reader.get(mid) == target) {
                end = mid;
            } else if (reader.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (reader.get(start) == target) {
            return start;
        }
        if (reader.get(end) == target){
            return end;
        }
        return -1;
    }
}
