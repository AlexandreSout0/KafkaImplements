package com.KafkaImplements.KafkaImplements.service;

import com.KafkaImplements.KafkaImplements.dto.DadosAcoesDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DadosAcoesService {
    List<DadosAcoesDTO> getAcoes();

    DadosAcoesDTO getDataAcaoSymbol(String symbol);

    void changeAcoes(DadosAcoesDTO dadosAcao, String id);

    void removeAcoes(String id);

}
