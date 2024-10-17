package com.deepak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class WeatherScheduler {
	
	@Autowired
    private WeatherService weatherService;

    @Value("${weather.cities}")
    private String[] cities;

    @Scheduled(fixedRateString = "${weather.update.interval}")
    public void scheduleWeatherUpdates() {
        for (String city : cities) {
            weatherService.fetchAndStoreWeatherData(city);
        }
    }

}
