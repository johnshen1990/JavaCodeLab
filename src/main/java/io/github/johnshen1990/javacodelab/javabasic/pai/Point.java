package io.github.johnshen1990.javacodelab.javabasic.pai;

import java.math.BigDecimal;

/**
 * Author: zhun.shen
 * Date: 2016-03-11 10:59
 * Description:
 */
public class Point {
    private BigDecimal x;
    private BigDecimal y;

    public Point(BigDecimal x, BigDecimal y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }

    public BigDecimal getY() {
        return y;
    }

    public void setY(BigDecimal y) {
        this.y = y;
    }

    public BigDecimal getX() {
        return x;
    }

    public void setX(BigDecimal x) {
        this.x = x;
    }
}
