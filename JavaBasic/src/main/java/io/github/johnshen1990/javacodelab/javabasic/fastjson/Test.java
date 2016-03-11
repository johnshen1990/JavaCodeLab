package io.github.johnshen1990.javacodelab.javabasic.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * Author: zhun.shen
 * Date: 2016-03-07 19:39
 * Description:
 */
public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setName("Tom");
        dog.setColor(Color.BLACK);
        String jsonString = JSON.toJSONString(dog);
        System.out.println(jsonString);
        Dog dog2 = JSON.parseObject(jsonString, Dog.class);
        System.out.println("dog2.name=" + dog2.getName());
        System.out.println("dog2.color=" + dog2.getColor());
    }
}
