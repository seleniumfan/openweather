package pl.ti.openweather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.ti.openweather.models.gecoding.Geocoding;
import pl.ti.openweather.models.weather.Coordinates;
import pl.ti.openweather.models.weather.WeatherResponse;

import java.util.Optional;

@Service
public class WeatherService {
    private static final String OPEN_WEATHER_FORECAST = "https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=%s&units=metric";
    private static final String OPEN_WEATHER_GEOCODING = "https://api.openweathermap.org/geo/1.0/direct?q=%s&limit=1&appid=%s";
    private final RestTemplate restTemplate = new RestTemplate();
    private String apiKey;

    public WeatherService(@Value("${app.owm.api-key}") String apiKey) {
        this.apiKey = apiKey;
    }

    public Optional<Coordinates> getCoordinates(String city) {
        try {
            Geocoding[] response = restTemplate.getForObject(String.format(OPEN_WEATHER_GEOCODING, city, apiKey), Geocoding[].class);
            if (response == null || response.length == 0) {
                return Optional.empty();
            }
            return Optional.of(new Coordinates(response[0].getLat(), response[0].getLon()));
        } catch (HttpClientErrorException e) {
            return Optional.empty();
        }
    }

    public WeatherDto getCurrentWeather(Coordinates coordinates) {
        WeatherResponse response = restTemplate.getForObject(String.format(OPEN_WEATHER_FORECAST, coordinates.getLat(), coordinates.getLon(), apiKey),
                WeatherResponse.class);
        WeatherDto weatherDto = WeatherMapper.map(response);
        return weatherDto;
    }
}
