package pl.ti.openweather;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    String home() {
        return "home";
    }

    @PostMapping("/")
    String getWeatherForCity(@RequestParam String city, Model model) {
        weatherService.getCoordinates(city)
                .ifPresentOrElse(coordinates -> {
                            WeatherDto currentWeather = weatherService.getCurrentWeather(coordinates);
                            model.addAttribute("weather", currentWeather);
                        },
                        () -> model.addAttribute("errorMessage", "Miasto " + city + " nie zostało znalezione."));
        return "home";
    }
}
