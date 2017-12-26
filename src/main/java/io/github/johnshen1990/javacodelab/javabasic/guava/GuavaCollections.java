package io.github.johnshen1990.javacodelab.javabasic.guava;

import com.google.common.base.Optional;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * Author: zhun.shen
 * Date: 2016-03-01 14:59
 * Description:
 */
public class GuavaCollections {
    public static void main(String[] args) {
        String str = "123";
        Optional<String> strOptional = Optional.fromNullable(str);
        System.out.println(strOptional.or(StringUtils.EMPTY));
    }
}
