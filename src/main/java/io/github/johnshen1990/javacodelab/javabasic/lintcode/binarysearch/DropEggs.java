package io.github.johnshen1990.javacodelab.javabasic.lintcode.binarysearch;

import java.util.HashSet;
import java.util.Set;

public class DropEggs {
    public int dropEggs(int n) {
return 0;
    }

    public boolean isUnique(String str) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < str.length(); i++) {
            if(set.contains(str.charAt(i))) {
                return false;
            }
            set.add(str.charAt(i));
        }
        return true;
    }
}
