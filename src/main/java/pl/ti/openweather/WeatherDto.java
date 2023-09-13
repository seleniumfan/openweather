package pl.ti.openweather;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WeatherDto {
    private BigDecimal temp;
    private BigDecimal feels_like;
    private BigDecimal temp_min;
    private BigDecimal temp_max;
    private int pressure;
    private int humidity;
    private String description;
    private BigDecimal windSpeed;
    private String city;
}
