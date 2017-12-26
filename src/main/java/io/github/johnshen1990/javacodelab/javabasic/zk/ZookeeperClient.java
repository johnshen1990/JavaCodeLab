package io.github.johnshen1990.javacodelab.javabasic.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Author: zhun.shen
 * Date: 2016-05-08 12:30
 * Description:
 */
public class ZookeeperClient implements InitializingBean, DisposableBean {

    private CuratorFramework curatorFramework;

    private String connectString = "104.224.157.172:2181,104.224.157.172:2182,104.224.157.172:2183";



    @Override
    public void afterPropertiesSet() throws Exception {
        ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 3);
        curatorFramework = CuratorFrameworkFactory.newClient(connectString, retryPolicy);
        curatorFramework.start();
    }


    @Override
    public void destroy() throws Exception {
        curatorFramework.close();
    }
}
