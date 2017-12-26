package io.github.johnshen1990.javacodelab.javabasic.consistenthash;

/**
 * Author: zhun.shen
 * Date: 2017-08-15 15:35
 * Description:
 */
public class DataEntity {
    private String key;
    private String value;

    public DataEntity(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataEntity that = (DataEntity) o;

        return key.equals(that.key);

    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }
}
