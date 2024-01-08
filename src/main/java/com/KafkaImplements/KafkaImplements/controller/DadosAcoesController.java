package com.KafkaImplements.KafkaImplements.controller;


import com.KafkaImplements.KafkaImplements.dto.DadosAcoesDTO;
import com.KafkaImplements.KafkaImplements.kafka.common.Constans;
import com.KafkaImplements.KafkaImplements.kafka.messageproducer.KafkaProducerMessage;
import com.KafkaImplements.KafkaImplements.service.DadosAcoesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/acoes")
public class DadosAcoesController {
    private final Logger LOG = LoggerFactory.getLogger(DadosAcoesController.class);

    @Autowired
    private DadosAcoesService dadosAcoesService;
    @Autowired
    private KafkaProducerMessage kafkaProducerMessage;

    @GetMapping("/all")
    public ResponseEntity<List<DadosAcoesDTO>> getAcoesData(){
        return ResponseEntity.status(HttpStatus.FOUND).body(dadosAcoesService.getAcoes());
    }

    @GetMapping("/symbol={symbol}")
    public ResponseEntity getAcao(@PathVariable("symbol") String symbol){
        return ResponseEntity.status(HttpStatus.FOUND).body(dadosAcoesService.getDataAcaoSymbol(symbol));
    }

    @PostMapping("/post")
    public ResponseEntity postDadosAcoes(@RequestBody DadosAcoesDTO dadosAcoesDTO){
        //LOG.info(" USANDO EVENTOS/MENSAGENS KAFKA - Producer ::: {}", dadosAcoesDTO);

        kafkaProducerMessage.sendMessage(dadosAcoesDTO, Constans.KAKFA_TOPIC_EXAMPLE1);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity changeDataDadosAcoes(@RequestBody DadosAcoesDTO dadosAcoesDTO, @PathVariable("id") String id){
        dadosAcoesService.changeAcoes(dadosAcoesDTO, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDadosAcoes(@PathVariable("id") String id){
        dadosAcoesService.removeAcoes(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
