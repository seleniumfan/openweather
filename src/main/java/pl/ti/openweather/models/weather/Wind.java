package pl.ti.openweather.models.weather;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Wind {
    private BigDecimal speed;
    private BigDecimal deg;
}
