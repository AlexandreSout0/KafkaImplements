package com.KafkaImplements.KafkaImplements.controller;

import com.KafkaImplements.KafkaImplements.dto.HistoricoTransacoesDTO;
import com.KafkaImplements.KafkaImplements.kafka.common.Constans;
import com.KafkaImplements.KafkaImplements.kafka.messageproducer.KafkaProducerMessage;
import com.KafkaImplements.KafkaImplements.service.HistoricoTransacoesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owner")
public class HistoricoTransacoesController {
    private final Logger LOG = LoggerFactory.getLogger(HistoricoTransacoesController.class);
    @Autowired
    private KafkaProducerMessage kafkaProducerMessage;

    @Autowired
    private HistoricoTransacoesService historicoTransacoesService;

    @PostMapping
    public ResponseEntity createOwnerCar(@RequestBody HistoricoTransacoesDTO historicoTransacoesDTO){
        //LOG.info(" USANDO API REST  - Nova Transação ::: {}", historicoTransacoesDTO);
        kafkaProducerMessage.sendMessage(historicoTransacoesDTO, Constans.KAKFA_TOPIC_EXAMPLE1);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
