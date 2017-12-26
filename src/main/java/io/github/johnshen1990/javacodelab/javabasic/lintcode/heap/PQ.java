package io.github.johnshen1990.javacodelab.javabasic.lintcode.heap;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PQ {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(2);
        queue.add(3);
        queue.add(1);
        queue.add(5);
        queue.add(4);

        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("");
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }
}
