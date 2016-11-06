package io.github.johnshen1990.javacodelab.javabasic.sort;

/**
 * Author: zhun.shen
 * Date: 2016-11-06 14:54
 * Description:
 */
public class SortDemo {
    public static void main(String[] args) {
        int[] src = new int[]{8,2,3,7,9,0,4,1,5,6};
        printArray(src);

//        quickSort(src);
//        insertSort(src);
        printArray(src);
    }

    /**
     * 快速排序算法描述:
     * 1. 找出数组中最小的元素,将它与数组的第1个元素的位置交换
     * 2. 在剩下的元素中找到最小的元素,将它与数组中第2歌元素的位置交换
     * 3. 以此类推...
     * @param src 待排序的数组
     */
    private static void quickSort(int[] src){
        int pointer = 0;
        while (pointer < src.length) {
            int minIndex = minIndex(src, pointer);
            exchange(src, pointer, minIndex);
            pointer++;
        }
    }

    /**
     * 插入排序
     * @param src 待排序的数组
     */
    private static void insertSort(int[] src){
        // 初始化i指向数组的第2个元素,遍历
        for(int i = 1; i < src.length; i++){
            // 每次初始化j和i相等,判断如果j>0且j指向的元素大于它前面的元素,则交换两个元素的位置 且 将j向左移动一位
            for(int j = i; j > 0 && src[j] < src[j-1]; j--){
                exchange(src, j, j-1);
            }
        }
    }

    /**
     * 通过元素下标交换数组中两个元素的值
     * @param src 被操作的数组
     * @param indexA 一个被操作元素的下标
     * @param indexB 另个一被操作元素的下标
     */
    private static void exchange(int[] src, int indexA, int indexB){
        int temp = src[indexA];
        src[indexA] = src[indexB];
        src[indexB] = temp;
    }

    /**
     * 得到数组数组中指定范围内的最小元素的下标
     * @param src 被操作的数组
     * @param pointer 要查找的范围(下标为pointer的元素以及其之后的所有元素)
     * @return
     */
    private static int minIndex(int[] src, int pointer){
        int minIndex = pointer;
        for(int i = pointer + 1; i < src.length; i++){
            if(src[minIndex] > src[i]){
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     * 打印数组
     * @param src
     */
    private static void printArray(int[] src){
        for(int i = 0; i < src.length; i++){
            System.out.print(src[i] + " ");
        }
        System.out.print("\n");
    }
}
