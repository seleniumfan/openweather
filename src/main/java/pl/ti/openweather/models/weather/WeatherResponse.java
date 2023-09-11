package pl.ti.openweather.models.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties({"sys", "clouds"})
public class WeatherResponse {
    private Coordinates coordinates;
    private Weather[] weather;
    private String base;
    private Main main;
    private int visibility;
    private Wind wind;
    private long dt;
    private int timezone;
    private long id;
    private String name;
    private int code;
}
