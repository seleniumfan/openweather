package pl.ti.openweather.models.weather;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Main {
    private BigDecimal temp;
    private BigDecimal feels_like;
    private BigDecimal temp_min;
    private BigDecimal temp_max;
    private int pressure;
    private int humidity;
}
