package com.deepak.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.deepak.entity.WeatherData;
import com.deepak.repository.WeatherDataRepository;

@Service
public class WeatherService {
	
	@Value("${weather.api.url}")
    private String apiUrl;

    @Value("${weather.api.key}")
    private String apiKey;

    @Autowired
    private WeatherDataRepository weatherDataRepository;

    private RestTemplate restTemplate = new RestTemplate();

    public void fetchAndStoreWeatherData(String city) {
        String url = String.format("%s?q=%s&appid=%s", apiUrl, city, apiKey);
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            Map<String, Object> weatherMap = response.getBody();
            Map<String, Object> main = (Map<String, Object>) weatherMap.get("main");

            WeatherData data = new WeatherData();
            data.setCity(city);
            data.setMainCondition((String) ((Map<String, Object>) weatherMap.get("weather")).get("main"));
            data.setTempCelsius(kelvinToCelsius((Double) main.get("temp")));
            data.setFeelsLikeCelsius(kelvinToCelsius((Double) main.get("feels_like")));
            data.setTimestamp((Long) weatherMap.get("dt"));
            
            weatherDataRepository.save(data);
        }
    }

    private double kelvinToCelsius(double kelvinTemp) {
        return kelvinTemp - 273.15;
    }

}
