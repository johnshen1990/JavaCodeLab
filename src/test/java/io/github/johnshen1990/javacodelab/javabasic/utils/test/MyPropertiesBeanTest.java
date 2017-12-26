package io.github.johnshen1990.javacodelab.javabasic.utils.test;

import io.github.johnshen1990.javacodelab.javabasic.utils.MyPropertiesBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Author: zhun.shen
 * Date: 2016-11-03 09:01
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring-*.xml"})
public class MyPropertiesBeanTest {
    @Autowired
    private MyPropertiesBean myPropertiesBean;

    @Test
    public void testGetUsername(){
        Assert.assertEquals("123", myPropertiesBean.getUsername());
    }

    @Test
    public void testGetUsername2(){
        Assert.assertEquals("123", myPropertiesBean.getUsername2());
    }
}
