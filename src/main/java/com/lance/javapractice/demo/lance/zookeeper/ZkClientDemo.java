package com.lance.javapractice.demo.lance.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import java.util.List;
import java.util.concurrent.CountDownLatch;


/**
 * @author lance
 */
public class ZkClientDemo {
    private static final int BASE_SLEEP_TIME = 1000;
    private static final int MAX_RETRIES = 3;
    private static CuratorFramework zkClient;
    private static final boolean DELETE = true;

    static {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(BASE_SLEEP_TIME, MAX_RETRIES);
        zkClient = CuratorFrameworkFactory.builder()
                // the server to connect to (can be a server list)
                .connectString("127.0.0.1:2181")
                .retryPolicy(retryPolicy)
                .build();
        zkClient.start();
    }

    public static void main(String[] args) throws Exception {
// Retry strategy. Retry 3 times, and will increase the sleep time between retries.
        String node1 = "/node1";
        String node11="/node1/01";
        String node12="/node1/02";
        String node111 = "/node1/01/1";
        String node2 = "/node2";
        String node2_1 = "/node2/00001";
        String node2_1_1 = "/node2/001/01";

        //创建节点
        createNode(node1);
        createNode(node2_1);
        createNode(node2_1_1);
        // 设置节点内容
        setNodeData(node1, "node11111");
        System.out.println("get data: " + new String(getNodeData(node1)));
        PathChildrenCache pathChildrenCache = new PathChildrenCache(zkClient, node1, true);
        PathChildrenCacheListener pathChildrenCacheListener = (curatorFramework, pathChildrenCacheEvent) -> {
            // do something
            System.out.println(pathChildrenCacheEvent.getType());
            System.out.println(new String(pathChildrenCacheEvent.getData().getData()));
        };
        pathChildrenCache.getListenable().addListener(pathChildrenCacheListener);
        pathChildrenCache.start();
        createNodeWithData(node11,"node11");
        Thread.sleep(10);
        setNodeData(node11,"newNode11");
        createNode(node12);
        System.out.println(new String(getNodeData(node11)));
        // 删除节点
        if (DELETE) {
            deleteNodeAndSubNode(node1);
            deleteNodeAndSubNode(node2);
        }
        new CountDownLatch(1).await();
    }

    // 创建节点
    static void createNode(String path) throws Exception {
        if (!checkIfExists(path)) {
            // 默认创建持久节点,二者等价
            zkClient.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath(path);
        } else {
            System.out.println(path + "已经存在");
        }
    }

    /**
     * 创建节点并设置数据
     */
    static void createNodeWithData(String path, String data) throws Exception {
        if (!checkIfExists(path)) {
            zkClient.create().forPath(path, data.getBytes());
        } else {
            System.out.println(path + "已经存在");
        }
    }


    /**
     * 删除节点
     */
    static void deleteNode(String path) throws Exception {
        zkClient.delete().forPath(path);
    }

    /**
     * 删除节点和子节点
     */
    static void deleteNodeAndSubNode(String path) throws Exception {
        zkClient.delete().deletingChildrenIfNeeded().forPath(path);
    }

    /**
     * 检查节点是否已经存在
     */
    static boolean checkIfExists(String path) throws Exception {
        return zkClient.checkExists().forPath(path) != null;
    }

    /**
     * 获取内容
     */
    static byte[] getNodeData(String path) throws Exception {
        return zkClient.getData().forPath(path);
    }

    /**
     * 设置内容
     *
     * @return
     */
    static void setNodeData(String path, String data) throws Exception {
        zkClient.setData().forPath(path, data.getBytes());
    }

    /**
     * 获取子节点路径
     */
    static List<String> getChildrenPath(String path) throws Exception{
        return zkClient.getChildren().forPath(path);
    }
}
