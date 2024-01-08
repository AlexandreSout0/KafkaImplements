package com.KafkaImplements.KafkaImplements.client;

import com.KafkaImplements.KafkaImplements.dto.DadosAcoesDTO;
import com.KafkaImplements.KafkaImplements.dto.HistoricoTransacoesDTO;
import com.KafkaImplements.KafkaImplements.kafka.common.Constans;
import com.KafkaImplements.KafkaImplements.kafka.messageproducer.KafkaProducerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class DadosAcoesClient {

    private final String USER_DATA_ACOES_SERVICE_URI = "http://localhost:8082/user";
    private final String POSTS_DATA_ACOES_SERVICE_URI = "http://localhost:8082/data";

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private KafkaProducerMessage kafkaProducerMessage;

    public List<DadosAcoesDTO> DadosAcoesClient(){
        ResponseEntity<DadosAcoesDTO[]> responseEntity = restTemplate.getForEntity(POSTS_DATA_ACOES_SERVICE_URI + "/acoes", DadosAcoesDTO[].class);
        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }

    public DadosAcoesDTO DadoClient(String dadosAcoesSymbol){
        ResponseEntity<DadosAcoesDTO> responseEntity = restTemplate.getForEntity(POSTS_DATA_ACOES_SERVICE_URI + "/symbol=" + dadosAcoesSymbol, DadosAcoesDTO.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    public void HistoricoTransacoesClient(HistoricoTransacoesDTO newTransacao){

        kafkaProducerMessage.sendMessage(newTransacao, Constans.KAKFA_TOPIC_EXAMPLE1);

        restTemplate.postForEntity(USER_DATA_ACOES_SERVICE_URI, newTransacao, HistoricoTransacoesDTO.class);
    }

    public void changeCarForSaleClient(DadosAcoesDTO dadosAcoesDTO, String id){
        restTemplate.put(POSTS_DATA_ACOES_SERVICE_URI+"/car/"+id, dadosAcoesDTO, DadosAcoesDTO.class);
    }

    public void deleteCarForSaleClient(String id){
        restTemplate.delete(POSTS_DATA_ACOES_SERVICE_URI + "/car/"+id);
    }

}
