package com.KafkaImplements.KafkaImplements.service;

import com.KafkaImplements.KafkaImplements.client.DadosAcoesClient;
import com.KafkaImplements.KafkaImplements.dto.HistoricoTransacoesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoricoTransacoesServiceImpl implements HistoricoTransacoesService {

    @Autowired
    private DadosAcoesClient dadosAcoesClient;

    @Override
    public void createHistoricoTransacoes(HistoricoTransacoesDTO historicoTransacoesDTO) {
        dadosAcoesClient.HistoricoTransacoesClient(historicoTransacoesDTO);

    }
}
