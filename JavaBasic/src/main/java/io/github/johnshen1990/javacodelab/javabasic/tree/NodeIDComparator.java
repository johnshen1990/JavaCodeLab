package io.github.johnshen1990.javacodelab.javabasic.tree;

import java.util.Comparator;

/**
 * Author: zhun.shen
 * Date: 2016-06-03 14:41
 * Description:
 */
public class NodeIDComparator implements Comparator {
    // 按照节点编号比较

    @Override
    public int compare(Object o1, Object o2) {
        int j1 = Integer.parseInt(((Node)o1).id);
        int j2 = Integer.parseInt(((Node)o2).id);
        return (j1 < j2 ? -1 : (j1 == j2 ? 0 : 1));
    }
}
