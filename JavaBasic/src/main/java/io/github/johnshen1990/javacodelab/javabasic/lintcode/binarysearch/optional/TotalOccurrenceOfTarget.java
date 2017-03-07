package io.github.johnshen1990.javacodelab.javabasic.lintcode.binarysearch.optional;

/**
 * Author: zhun.shen
 * Date: 2017-02-14 13:45
 * Description:
 *
 * 给一个升序的数组，以及一个target，找到它在数组中出现的次数。
 *
 * 样例
 * 给出 [1, 3, 3, 4, 5] target = 3, 返回 2.
 * 给出 [2, 2, 3, 4, 6] target = 4, 返回 1.
 * 给出 [1, 2, 3, 4, 5] target = 6, 返回 0.
 *
 * 思路:先用二分法找出target第一次出现的位置,再用二分法找出target最后一次出现的位置
 */
public class TotalOccurrenceOfTarget {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        int firstIndex = firstOccurence(A, target);
        if(firstIndex != -1) {
            int lastIndex = lastOccurence(A, target);
            if(firstIndex == lastIndex) {
                return 1;
            }
            return lastIndex - firstIndex + 1;
        }
        return 0;
    }

    private int firstOccurence(int[] src, int target) {
        if(src == null || src.length == 0) {
            return -1;
        }

        int start = 0;
        int end = src.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(src[mid] > target) {
                end = mid;
            }else if(src[mid] == target) {
                end = mid;
            }else {
                start = mid;
            }
        }

        if(src[start] == target) {
            return start;
        }
        if(src[end] == target) {
            return end;
        }
        return -1;
    }

    private int lastOccurence(int[] src, int target) {
        if(src == null || src.length == 0) {
            return -1;
        }

        int start = 0;
        int end = src.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(src[mid] > target) {
                end = mid;
            }else if(src[mid] == target) {
                start = mid;
            }else {
                start = mid;
            }
        }

        if(src[end] == target) {
            return end;
        }

        if(src[start] == target) {
            return start;
        }

        return -1;
    }
}
