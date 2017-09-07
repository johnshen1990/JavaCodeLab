package io.github.johnshen1990.javacodelab.javabasic.consistenthash;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: zhun.shen
 * Date: 2017-08-15 15:34
 * Description:
 */
public class NodeEntity {
    private String nodeId;

    private Map<String, String> dataMap;

    private int counter;

    public boolean exist(DataEntity dataEntity) {
        return this.dataMap.containsKey(dataEntity.getKey());
    }

    public void save(DataEntity dataEntity) {
        this.dataMap.put(dataEntity.getKey(), dataEntity.getValue());
    }

    public int currentLoad() {
        return this.dataMap.size();
    }

    public void increaseCounter() {
        this.counter ++;
    }

    public NodeEntity(String nodeId) {
        this.nodeId = nodeId;
        dataMap = new HashMap<>();
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public Map<String, String> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, String> dataMap) {
        this.dataMap = dataMap;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
