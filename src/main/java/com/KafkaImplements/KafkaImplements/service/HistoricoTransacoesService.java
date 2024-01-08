package com.KafkaImplements.KafkaImplements.service;


import com.KafkaImplements.KafkaImplements.dto.HistoricoTransacoesDTO;
import org.springframework.stereotype.Service;

@Service
public interface HistoricoTransacoesService {

    void createHistoricoTransacoes(HistoricoTransacoesDTO historicoTransacoesDTO);

}
