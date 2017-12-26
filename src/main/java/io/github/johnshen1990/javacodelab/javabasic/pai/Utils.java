package io.github.johnshen1990.javacodelab.javabasic.pai;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Author: zhun.shen
 * Date: 2016-03-11 11:01
 * Description:
 */
public class Utils {

    public static BigDecimal random(long n){
        Random random = new Random();
        return BigDecimal.valueOf(random.nextDouble()).multiply(BigDecimal.valueOf(n));
    }

    public static Point generatePoint(long n){
        return new Point(random(n), random(n));
    }

    public static void main(String[] args) {
        for(int i=0; i<10; i++){
            System.out.println(random(2));
        }
    }
}
