package pl.ti.openweather.models.weather;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class Coordinates {
    private BigDecimal lat;
    private BigDecimal lon;
}
