package app.controllers;

import app.dto.GroupDTO;
import app.dto.ProductDTO;
import app.dto.kafkadto.KafkaProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@Slf4j
@RestController
@RequestMapping(value = "/api/message")
public class KafkaController {
    @Autowired
    private KafkaTemplate<String, KafkaProductDTO> kafkaTemplate;

    @PostMapping
    @Transactional
    public void sendOrder(String msgId, KafkaProductDTO msg){
        ListenableFuture<SendResult<String, KafkaProductDTO>> future = kafkaTemplate.send("load-test-create-product", msgId, msg);
        future.addCallback(System.out::println, System.err::println);
        kafkaTemplate.flush();
    }

}
