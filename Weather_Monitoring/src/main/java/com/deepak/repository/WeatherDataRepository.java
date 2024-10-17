package com.deepak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deepak.entity.WeatherData;
@Repository
public interface WeatherDataRepository extends  JpaRepository<WeatherData, Long>{

	List<WeatherData> findByCityAndTimestampBetween(String city, long startTime, long endTime);

	List<WeatherData> findTop2ByCityOrderByTimestampDesc(String city);

}
