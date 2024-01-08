package com.KafkaImplements.KafkaImplements.kafka.messageconsumer;

import com.KafkaImplements.KafkaImplements.kafka.common.Constans;
import lombok.SneakyThrows;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerMessage {

    private final Logger LOG = LoggerFactory.getLogger(KafkaConsumerMessage.class);

    @KafkaListener(topics = Constans.KAKFA_TOPIC_EXAMPLE1,  groupId = Constans.KAKFA_TOPIC_EXAMPLE1)
    public void listening1(ConsumerRecord<String, String> record)  throws InterruptedException {
        LOG.info("CONSUMER message from Kafka: {}", record.value());

        /* Business rule code with message */
    }


    @SneakyThrows
    @KafkaListener(topics = Constans.KAKFA_TOPIC_EXAMPLE1,  groupId = Constans.KAKFA_TOPIC_EXAMPLE1)
    public void pdfGenerator(ConsumerRecord<String, String> record)  throws InterruptedException {
        LOG.info("CONSUMER message from Kafka: {}", record.value());

        /* Business rule code with message */
    }


}

