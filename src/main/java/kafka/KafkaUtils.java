package kafka;

import com.alibaba.fastjson.JSON;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @Author: mengchao
 * @Date: 2020/12/1 22:56
 */
public class KafkaUtils {
    public static Logger log = Logger.getLogger("KafkaUtils.class");
    private static final int CPU_NUMBER = Runtime.getRuntime().availableProcessors();
    private static final RejectedExecutionHandler defaultHandler = new ThreadPoolExecutor.AbortPolicy();
    private static ExecutorService executorService =
            new ThreadPoolExecutor(
                    1,
                    1,
                    0L,
                    TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<Runnable>(),
                    Executors.defaultThreadFactory(),
                    defaultHandler
            );

    static class ProducerCallBack implements Callback {
        @Override
        public void onCompletion(RecordMetadata metadata, Exception exception) {
            if(exception != null){
                log.info("消息发送异常");
                exception.printStackTrace();;
            }
        }
    }

    public static void consume(Map<String, Object> properties,List<String> topic) {
        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);
        kafkaConsumer.subscribe(topic);

        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(1000);
            log.info("count:"+records.count());
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("topic:%s,offset:%d,消息:%s%n", record.topic(), record.offset(), record.value());
            }
        }
        //kafkaConsumer.commitAsync();
    }

    public static void produceToKafka(String brokerList, String batchSize, String requiredAcks, String topic, List<Map<String, Object>> list) {
        Map<String, Object> properties = new HashMap<>(16);
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSize);
        properties.put(ProducerConfig.ACKS_CONFIG, requiredAcks);
        log.info("消息size:" + list.size());
        executorService.submit(() -> {
            KafkaUtils.produce(list, properties, topic);
            log.info("发送消息到kafka完成");
        });
    }

    public static void produce(List<Map<String, Object>> list, Map<String, Object> properties, String topic) {
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);
        for (Map<String, Object> object:list
        ) {
            log.info("producing,object id:" + object.get("id").toString());
            ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, JSON.toJSONString(object));
            //同步写入
            //RecordMetadata recordMetadata = kafkaProducer.send(record).get();
            //异步写入
            kafkaProducer.send(record, new ProducerCallBack());

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        kafkaProducer.flush();
        kafkaProducer.close();
    }

}

