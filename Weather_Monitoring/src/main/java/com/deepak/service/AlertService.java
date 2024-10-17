package com.deepak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.deepak.entity.WeatherData;
import com.deepak.repository.WeatherDataRepository;

@Service
public class AlertService {
	@Value("${alert.temp.threshold:35}")
    private double tempThreshold;

    @Autowired
    private WeatherDataRepository weatherDataRepository;

    public void checkAndTriggerAlerts(String city) {
        List<WeatherData> latestTwoEntries = weatherDataRepository
                .findTop2ByCityOrderByTimestampDesc(city);

        if (latestTwoEntries.size() == 2) {
            if (latestTwoEntries.stream().allMatch(data -> data.getTempCelsius() > tempThreshold)) {
                triggerAlert(city);
            }
        }
    }

    private void triggerAlert(String city) {
        // Example: log alert or send email (implementation left open-ended)
        System.out.println("ALERT: Temperature in " + city + " exceeded threshold for two consecutive updates.");
    }

}
