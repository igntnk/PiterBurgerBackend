package app.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
class KafkaTopicConfig {

    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name("load-test-create-product").build();
    }

    @Bean
    public NewTopic topic2() {
        return TopicBuilder.name("dead-letter-queue").build();
    }

}
