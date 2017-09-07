package io.github.johnshen1990.javacodelab.javabasic.mvt;

public class ExperimentGroup {
    private RatioRange ratioRange;
    private int value;

    public ExperimentGroup() {
    }

    public ExperimentGroup(RatioRange ratioRange, int value) {
        this.ratioRange = ratioRange;
        this.value = value;
    }

    public RatioRange getRatioRange() {
        return ratioRange;
    }

    public void setRatioRange(RatioRange ratioRange) {
        this.ratioRange = ratioRange;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
