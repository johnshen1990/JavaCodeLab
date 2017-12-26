package io.github.johnshen1990.javacodelab.javabasic.arraylist;

import java.util.*;

/**
 * Author: zhun.shen
 * Date: 2017-02-17 14:30
 * Description:
 */
public class ArrayListTest {

    public static void main(String[] args) {
        new ArrayListTest().testCopy();
    }

    private class MyObject{
        private int id;

        public MyObject(int id) {
            this.id = id;
        }
    }

    public void testCopy(){
        List<MyObject> src = Arrays.asList(new MyObject(1), new MyObject(2), new MyObject(3));
        printList(src);

        List<MyObject> copy1 = new ArrayList<>(src);
        printList(copy1);

        List<MyObject> copy2 = new ArrayList<>(src.size());
        Collections.copy(copy2, src);
        printList(copy2);

    }


    public void printList(List<MyObject> list){
        for(MyObject item : list) {
            System.out.println(item);
        }
    }
}
