package pl.ti.openweather;

import pl.ti.openweather.models.weather.WeatherResponse;

public class WeatherMapper {
    public static WeatherDto map(WeatherResponse response) {
        WeatherDto weatherDto = new WeatherDto();
        weatherDto.setTemp(response.getMain().getTemp());
        weatherDto.setFeels_like(response.getMain().getFeels_like());
        weatherDto.setTemp_min(response.getMain().getTemp_min());
        weatherDto.setTemp_max(response.getMain().getTemp_max());
        weatherDto.setPressure(response.getMain().getPressure());
        weatherDto.setHumidity(response.getMain().getHumidity());
        weatherDto.setDescription(response.getWeather()[0].getDescription());
        weatherDto.setWindSpeed(response.getWind().getSpeed());
        weatherDto.setCity(response.getName());
        return weatherDto;
    }
}
