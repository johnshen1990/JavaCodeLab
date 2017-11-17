package io.github.johnshen1990.javawebapp.servlet;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class InitSequenceBean implements InitializingBean, DisposableBean {

    public InitSequenceBean() {
        System.out.println("InitSequenceBean() called");
    }

    @PostConstruct
    private void postConstructMethod() {
        System.out.println("postConstructMethod() called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet() called");
    }

    public void initMethod() {
        System.out.println("initMethod() called");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("preDestroy() called");
    }

    @Override
    public void destroy() {
        System.out.println("destroy() called");
    }

    public void destroyMethod() {
        System.out.println("destroyMethod() called");
    }
}
