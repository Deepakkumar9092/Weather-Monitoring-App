package com.deepak.service;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepak.entity.WeatherData;
import com.deepak.repository.WeatherDataRepository;

@Service
public class WeatherAggregateService {

	@Autowired
    private WeatherDataRepository weatherDataRepository;

    public WeatherSummary calculateDailySummary(String city, LocalDate date) {
        long startTime = date.atStartOfDay(ZoneOffset.UTC).toEpochSecond();
        long endTime = date.plusDays(1).atStartOfDay(ZoneOffset.UTC).toEpochSecond();

        List<WeatherData> weatherDataList = weatherDataRepository.findByCityAndTimestampBetween(city, startTime, endTime);

        double avgTemp = weatherDataList.stream().mapToDouble(WeatherData::getTempCelsius).average().orElse(0.0);
        double maxTemp = weatherDataList.stream().mapToDouble(WeatherData::getTempCelsius).max().orElse(0.0);
        double minTemp = weatherDataList.stream().mapToDouble(WeatherData::getTempCelsius).min().orElse(0.0);

        Map<String, Long> conditionCounts = weatherDataList.stream()
                .collect(Collectors.groupingBy(WeatherData::getMainCondition, Collectors.counting()));

        String dominantCondition = Collections.max(conditionCounts.entrySet(), Map.Entry.comparingByValue()).getKey();

        return new WeatherSummary(avgTemp, maxTemp, minTemp, dominantCondition);
    }
}
