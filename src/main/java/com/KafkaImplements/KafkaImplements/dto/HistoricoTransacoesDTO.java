package com.KafkaImplements.KafkaImplements.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data //Com essa anotação eu não preciso criar os Getters and Setters
@Builder // Com essa anotação eu não preciso criar o o Construtor com todos Objetos
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
public class HistoricoTransacoesDTO {         //Data Transfer Objet --> [Objeto de tranferencia de dados]

    /**
     {
         id SERIAL PRIMARY KEY,
         symbol VARCHAR(50) NOT NULL,
         data_transacao DATE NOT NULL,
         quantidade INTEGER NOT NULL,
         preco_transacao NUMERIC(10, 4) NOT NULL
     }
     **/

    private Long Id;
    private String symbol;
    private LocalDate dataTransacao;
    private int quantidade;
    private Double precoTransacao;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrecoTransacao() {
        return precoTransacao;
    }

    public void setPrecoTransacao(Double preco_transacao) {
        this.precoTransacao = preco_transacao;
    }
}
