package io.github.johnshen1990.javacodelab.javabasic.lintcode.heap;

public class Heapify {

    public void heapify(int[] A) {
        int[] nums = new Heap(A).getNums();
        System.arraycopy(nums, 0, A, 0, nums.length);
    }

    public static class Heap {
        private int[] nums;
        private int heapSize = 0;

        public Heap() {
            nums = new int[100];
        }
        public Heap(int[] nums) {
            this.nums = new int[nums.length];
            for(int num : nums) {
                push(num);
            }
        }

        public int[] getNums() {
            return this.nums;
        }

        /**
         * 堆的push操作的过程是：
         * 1. 先将e加入到堆的bottom位置，并对堆的size+1
         * 2. 从bottom位置顺着父节点依次往上比较，如果小于父节点，就swap。
         */
        public void push(int e) {
            // e先放在heapSize的位置，heapSize自增1
            nums[heapSize++] = e;
            // 当前节点的位置
            int currentIndex = heapSize - 1;
            // 父节点的位置
            int parentIndex = getParentIndex(currentIndex);
            // 当前节点 小于 父节点
            while(parentIndex >= 0 && nums[currentIndex] < nums[parentIndex]) {
                swap(currentIndex, parentIndex);

                currentIndex = parentIndex;
                parentIndex = getParentIndex(currentIndex);
            }
        }

        /**
         * 堆的pop操作过程是：
         * 1. 将堆的peak和bottom位置的元素交换，并将堆的size-1
         * 2. 从peak位置依次与较小的child比较，如果peak大于较小的child，则与其swap
         */
        public int pop() {
            // swap peak and bottom
            swap(0, heapSize--);

            int currentIndex = 0;
            int childIndex = min(getLeftChildIndex(currentIndex), getRightChildIndex(currentIndex));
            while(nums[currentIndex] > nums[childIndex]) {
                swap(currentIndex, childIndex);

                currentIndex = childIndex;
                childIndex = min(getLeftChildIndex(childIndex), getRightChildIndex(childIndex));
            }
            return nums[heapSize];
        }

        /**
         * 返回堆peak位置的元素（如果存在）
         */
        public int top() {
            if(heapSize == 0) {
                return -1;
            }
            return nums[0];
        }


        /**
         * 左孩子位置 = parentIndex * 2 + 1
         */
        private int getLeftChildIndex(int parentIndex) {
            int leftChildIndex = parentIndex * 2 + 1;
            return leftChildIndex < heapSize ? leftChildIndex : -1;
        }

        /**
         * 右孩子位置 = parentIndex * 2 + 2
         */
        private int getRightChildIndex(int parentIndex) {
            int rightChildIndex = parentIndex * 2 + 2;
            return rightChildIndex < heapSize ? rightChildIndex : -1;
        }

        /**
         * childIndex为奇数时为左孩子，此时parentIndex = (childIndex - 1) / 2；
         * childIndex为偶数时为右孩子，此时parentIndex = (childIndex - 2) / 2；
         * childIndex为0时为根节点，此时没有parent，返回-1。
         */
        private int getParentIndex(int childIndex) {
            int parentIndex = -1;
            if(childIndex <= 0) {
                return parentIndex;
            }
            if(childIndex % 2 != 0) { // 左节点
                parentIndex = (childIndex - 1) / 2;
            } else { // 右节点
                parentIndex = (childIndex - 2) / 2;
            }
            return parentIndex;
        }

        /**
         * 返回两个整数中较小的那一个
         */
        private int min(int a, int b) {
            return a < b ? a : b;
        }

        /**
         * 交换数组中位置为i和j的两个数的值
         */
        private void swap(int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    // TODO
    public static boolean isMinHeap(int[] src) {
        int size = src.length;


        return true;
    }

    public static void main(String[] args) {
        int[] A = new int[]{42,30,27,93,8,34,47,64,82,76,70,79,23,5,67,9,97,29,7,61,73,3,44,85,51,49,90,59,38,55,39,62,54,81,26,50,22,71,52,41,77,32,2,96,84,20,48,17,87,94,12,13,89,24,6,74,69,78,65,35,15,28,25,16,33,63};
        new Heapify().heapify(A);
        for(int e : A) {
            System.out.print(e + " ");
        }
    }

}
