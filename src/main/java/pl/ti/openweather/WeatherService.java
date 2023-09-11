package pl.ti.openweather;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.ti.openweather.models.gecoding.Geocoding;
import pl.ti.openweather.models.weather.Coordinates;
import pl.ti.openweather.models.weather.WeatherResponse;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class WeatherService {
    private static final String API_KEY = "da6ebfd155ee2bbedcc44052606125fd";
    private static final String OPEN_WEATHER_FORECAST = "https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=%s";
    private static final String OPEN_WEATHER_GEOCODING = "https://api.openweathermap.org/geo/1.0/direct?q=%s&limit=1&appid=%s";
    public static final double ZERO_CELSIUS_IN_KELVIN = 273.15;
    private final RestTemplate restTemplate = new RestTemplate();

    public Optional<Coordinates> getCoordinates(String city) {
        try {
            Geocoding[] response = restTemplate.getForObject(String.format(OPEN_WEATHER_GEOCODING, city, API_KEY), Geocoding[].class);
            if (response == null || response.length == 0) {
                return Optional.empty();
            }
            return Optional.of(new Coordinates(response[0].getLat(), response[0].getLon()));
        } catch (HttpClientErrorException e) {
            return Optional.empty();
        }
    }

    public WeatherDto getCurrentWeather(Coordinates coordinates) {
        WeatherResponse response = restTemplate.getForObject(String.format(OPEN_WEATHER_FORECAST, coordinates.getLat(), coordinates.getLon(), API_KEY),
                WeatherResponse.class);
        WeatherDto weatherDto = WeatherMapper.map(response);
        return weatherDto;
    }

    public static BigDecimal kelvinToCelsius(BigDecimal kelvin) {
        return kelvin.subtract(BigDecimal.valueOf(ZERO_CELSIUS_IN_KELVIN));
    }
}
