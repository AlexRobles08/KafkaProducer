package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class MessageProducer {
  private Properties properties;
  private Producer producer;

  public MessageProducer() {
    properties = new Properties();
    properties.put("bootstrap.servers", "localhost:9092");
    properties.put("acks", "all");
    properties.put("retries", 0);
    properties.put("batch.size", 16384);
    properties.put("linger.ms", 1);
    properties.put("buffer.memory", 33554432);
    properties.put("key.serializer",
            "org.apache.kafka.common.serialization.StringSerializer");
    properties.put("value.serializer",
            "org.apache.kafka.common.serialization.StringSerializer");

    producer = new KafkaProducer(properties);
  }

  public void sendMessageToTopic(String message) {
    producer.send(new ProducerRecord<>("messages", message));
  }


}
