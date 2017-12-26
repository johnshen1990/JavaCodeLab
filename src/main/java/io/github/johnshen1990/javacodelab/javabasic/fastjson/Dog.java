package io.github.johnshen1990.javacodelab.javabasic.fastjson;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Author: zhun.shen
 * Date: 2016-03-07 19:30
 * Description:
 */
public class Dog {

    @JSONField(name="name")
    private String name;

//    @JSONField(name="color")
//    private Color color;

    @JSONField(name = "mRoomId")
    private String mRoomId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Color getColor() {
//        return color;
//    }
//
//    public void setColor(Color color) {
//        this.color = color;
//    }

}
