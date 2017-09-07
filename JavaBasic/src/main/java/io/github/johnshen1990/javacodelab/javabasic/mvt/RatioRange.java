package io.github.johnshen1990.javacodelab.javabasic.mvt;

public class RatioRange {
    private int min;
    private int max;

    public RatioRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public boolean inBound(int num) {
        return num >= this.min && num <= this.max;
    }
}
