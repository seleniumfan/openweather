package pl.ti.openweather;

import pl.ti.openweather.models.weather.WeatherResponse;

import static pl.ti.openweather.WeatherService.kelvinToCelsius;

public class WeatherMapper {
    public static WeatherDto map(WeatherResponse response) {
        WeatherDto weatherDto = new WeatherDto();
        weatherDto.setTemp(kelvinToCelsius(response.getMain().getTemp()));
        weatherDto.setFeels_like(kelvinToCelsius(response.getMain().getFeels_like()));
        weatherDto.setTemp_min(kelvinToCelsius(response.getMain().getTemp_min()));
        weatherDto.setTemp_max(kelvinToCelsius(response.getMain().getTemp_max()));
        weatherDto.setPressure(response.getMain().getPressure());
        weatherDto.setHumidity(response.getMain().getHumidity());
        weatherDto.setDescription(response.getWeather()[0].getDescription());
        weatherDto.setWindSpeed(response.getWind().getSpeed());
        weatherDto.setCity(response.getName());
        return weatherDto;
    }
}
