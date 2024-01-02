package app.controllers;

import app.dto.GroupDTO;
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
    private KafkaTemplate<Long, GroupDTO> kafkaTemplate;

    @PostMapping
    @Transactional
    public void sendOrder(Long msgId, GroupDTO msg){
        ListenableFuture<SendResult<Long, GroupDTO>> future = kafkaTemplate.send("msg", msgId, msg);
        future.addCallback(System.out::println, System.err::println);
        kafkaTemplate.flush();
    }

}
