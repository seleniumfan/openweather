package pl.ti.openweather.models.gecoding;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class Geocoding {
    private String name;
    private Map<String, String> localNames;
    private BigDecimal lat;
    private BigDecimal lon;
    private String country;
    private String state;
}
