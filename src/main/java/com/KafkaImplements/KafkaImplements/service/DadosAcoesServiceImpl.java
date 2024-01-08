package com.KafkaImplements.KafkaImplements.service;

import com.KafkaImplements.KafkaImplements.client.DadosAcoesClient;
import com.KafkaImplements.KafkaImplements.dto.DadosAcoesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DadosAcoesServiceImpl implements DadosAcoesService {

    @Autowired
    private DadosAcoesClient dadosAcoesClient;

    @Override
    public List<DadosAcoesDTO> getAcoes() {
        return dadosAcoesClient.DadosAcoesClient();
    }

    @Override
    public DadosAcoesDTO getDataAcaoSymbol(String symbol) {
        return dadosAcoesClient.DadoClient(symbol);
    }

    @Override
    public void changeAcoes(DadosAcoesDTO dadosAcao, String id) {
        dadosAcoesClient.changeCarForSaleClient(dadosAcao, id);

    }

    @Override
    public void removeAcoes(String id) {
        dadosAcoesClient.deleteCarForSaleClient(id);

    }
}
