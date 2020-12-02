import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kafka.KafkaUtils;

/**
 * @Author: mengchao
 * @Date: 2020/12/2 23:28
 */
public class KafkaTest {
    @Test
    public void produceTest(){
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            Map<String, Object> map = new HashMap<>(4);
            map.put("id", i);
            map.put("value", "value:" + i);
            list.add(map);
        }

        String brokerList = "localhost:9092";
        String topic = "test_topic";
        String batchSize = "1024";
        String requiredAcks = "1";

        KafkaUtils.produceToKafka(brokerList, batchSize, requiredAcks, topic, list);
    }

    @Test
    public void consumeTest(){
        Map<String, Object> properties = new HashMap<>(16);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "test-consumer-group");
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        List<String> topicList = Arrays.asList("test_topic");
        KafkaUtils.consume(properties,topicList);
    }

    @Test
    public void consumeTest1(){
        Map<String, Object> properties = new HashMap<>(16);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "test-consumer-group-1");
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        List<String> topicList = Arrays.asList("test_topic");
        KafkaUtils.consume(properties,topicList);
    }
}
