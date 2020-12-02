package kafka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: mengchao
 * @Date: 2020/12/2 23:36
 */
public class MainClass {
    public static void main(String[] args) {
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
}
