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
public class DadosAcoesDTO { //Data Transfer Objet --> [Obejeto de tranferencia de dados]

    /**
     "id": 0,
     symbol": "ITUB4.SA",
     open": "33.6100",
     high": "33.9500",
     low": "33.5700",
     price": "33.8800",
     volume": "18176500",
     "latest trading day": "2023-12-27",
     "previous close": "33.6500",
    * */

    private Long Id;
    private String symbol;
    private Double open;
    private Double high;
    private Double low;
    private Double price;
    private int volume;
    private LocalDate latestTradingDay;
    private Double previousClose;

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

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public LocalDate getLatestTradingDay() {
        return latestTradingDay;
    }

    public void setLatestTradingDay(LocalDate latestTradingDay) {
        this.latestTradingDay = latestTradingDay;
    }

    public Double getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(Double previousClose) {
        this.previousClose = previousClose;
    }
}
