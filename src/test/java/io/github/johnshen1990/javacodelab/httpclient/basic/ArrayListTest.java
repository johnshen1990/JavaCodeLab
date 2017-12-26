package io.github.johnshen1990.javacodelab.httpclient.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<String> list  = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("a");

        // use foreach
//        for(String str : list) {
//            if("a".equals(str)) {
//                list.remove(str);
//            }
//        }

        // use for
//        for(int i = 0; i < list.size(); i++) {
//            if("a".equals(list.get(i))) {
//                list.remove(i);
//            }
//        }

        // use Iterator
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String str = iterator.next();
//            if ("a".equals(str)) {
//                iterator.remove();
//            }
//        }
        System.out.println(list);
    }
}
