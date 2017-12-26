package io.github.johnshen1990.javacodelab.javabasic.consistenthash;

import com.google.common.hash.Hashing;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: zhun.shen
 * Date: 2017-08-15 15:27
 * Description:
 */
public class ConsistentHash {
    private int nodeNum = 5;
    private int dataNum = 10000;
    private List<NodeEntity> nodeEntityList = new ArrayList<>();
    private List<DataEntity> dataEntityList = new ArrayList<>();

    public static void main(String[] args) {
        ConsistentHash instance = new ConsistentHash();
        instance.init();
//        instance.normalHash();
        instance.consistentHash();
        instance.summary();
        instance.reduceNode();
        instance.normalHash();
        instance.summary();
    }

    public void init() {
        for(int i = 0; i < nodeNum; i++) {
            nodeEntityList.add(new NodeEntity("node" + i));
        }

        for(int i = 0; i < dataNum; i++) {
            dataEntityList.add(new DataEntity(ConsistentHash.randomKey(), "defaultValue"));
        }
    }

    public void normalHash() {
        cleanAllNodeCounter();

        for(DataEntity dataEntity : dataEntityList) {
            // hint: mod operation could get minus result
            int index = Math.abs(dataEntity.hashCode() % nodeNum);
            if(!nodeEntityList.get(index).exist(dataEntity)) {
                nodeEntityList.get(index).increaseCounter();
                nodeEntityList.get(index).save(dataEntity);
            }
        }
    }

    public void consistentHash() {
        cleanAllNodeCounter();

        for(DataEntity dataEntity : dataEntityList) {
            int index = Hashing.consistentHash(dataEntity.hashCode(), nodeNum);
            if (!nodeEntityList.get(index).exist(dataEntity)) {
                nodeEntityList.get(index).increaseCounter();
                nodeEntityList.get(index).save(dataEntity);
            }
        }
    }

    public void summary() {
        System.out.println("----load----");
        for(NodeEntity nodeEntity : nodeEntityList) {
            System.out.println(nodeEntity.getNodeId() + " contains " + nodeEntity.currentLoad() + " keys");
        }
        for(NodeEntity nodeEntity : nodeEntityList) {
            System.out.println(nodeEntity.getNodeId() + " is added " + nodeEntity.getCounter() + " new keys");
        }
    }

    public static String randomKey() {
        return RandomStringUtils.random(5);
    }

    public void reduceNode() {
        // remove the last node
        nodeEntityList.remove(nodeNum - 1);
        nodeNum--;
    }

    public void cleanAllNodeCounter() {
        for(NodeEntity nodeEntity : nodeEntityList) {
            nodeEntity.setCounter(0);
        }
    }

}
