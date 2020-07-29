package com.radebit.springcloud.admin;

import org.apache.kafka.clients.admin.*;

import java.util.*;
import java.util.concurrent.ExecutionException;

/**
 * @author Rade
 * @date 2020/7/27 3:36 下午
 * @url https://blog.radebit.com
 * 说明：
 */
public class AdminSample {

    public static String TOPIC_NAME = "demo_topic";

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        AdminClient adminClient = AdminSample.adminClient();
//        System.out.println("AdminClient: " + adminClient);
        // 创建Topic实例
//        createTopic();
        // 获取Topic列表
//        topicLists();
//        incrPartition(2);
    }

    /**
     * 创建Topic
     */
    public static void createTopic() {
        AdminClient adminClient = adminClient();
        // 副本因子
        short rs = 1;
        NewTopic newTopic = new NewTopic(TOPIC_NAME, 1, rs);
        CreateTopicsResult topics = adminClient.createTopics(Arrays.asList(newTopic));
        System.out.println("CreateTopicsResult: " + topics);
    }

    /**
     * 获取Topic列表
     */
    public static void topicLists() throws ExecutionException, InterruptedException {
        AdminClient adminClient = adminClient();
        ListTopicsResult listTopicsResult = adminClient.listTopics();
        Set<String> names = listTopicsResult.names().get();

        names.stream().forEach(System.out::println);
    }

    /**
     * 设置AdminClient
     *
     * @return
     */
    public static AdminClient adminClient() {
        Properties properties = new Properties();
        properties.setProperty(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "10.129.2.97:9092");
        return AdminClient.create(properties);
    }

    /**
     * 设置partition
     */
    public static void incrPartition(int partutions) throws ExecutionException, InterruptedException {
        AdminClient adminClient = adminClient();
        Map<String, NewPartitions> partitionsMap = new HashMap<>();
        NewPartitions newPartitions = NewPartitions.increaseTo(partutions);
        partitionsMap.put(TOPIC_NAME, newPartitions);
        CreatePartitionsResult createPartitionsResult = adminClient.createPartitions(partitionsMap);
        createPartitionsResult.all().get();
    }
}
