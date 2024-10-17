package com.deepak.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WeatherData {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String mainCondition;
    private double tempCelsius;
    private double feelsLikeCelsius;
    private double maxTempCelsius;
    private double minTempCelsius;
    private long timestamp;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMainCondition() {
		return mainCondition;
	}
	public void setMainCondition(String mainCondition) {
		this.mainCondition = mainCondition;
	}
	public double getTempCelsius() {
		return tempCelsius;
	}
	public void setTempCelsius(double tempCelsius) {
		this.tempCelsius = tempCelsius;
	}
	public double getFeelsLikeCelsius() {
		return feelsLikeCelsius;
	}
	public void setFeelsLikeCelsius(double feelsLikeCelsius) {
		this.feelsLikeCelsius = feelsLikeCelsius;
	}
	public double getMaxTempCelsius() {
		return maxTempCelsius;
	}
	public void setMaxTempCelsius(double maxTempCelsius) {
		this.maxTempCelsius = maxTempCelsius;
	}
	public double getMinTempCelsius() {
		return minTempCelsius;
	}
	public void setMinTempCelsius(double minTempCelsius) {
		this.minTempCelsius = minTempCelsius;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "WeatherData [id=" + id + ", city=" + city + ", mainCondition=" + mainCondition + ", tempCelsius="
				+ tempCelsius + ", feelsLikeCelsius=" + feelsLikeCelsius + ", maxTempCelsius=" + maxTempCelsius
				+ ", minTempCelsius=" + minTempCelsius + ", timestamp=" + timestamp + "]";
	}
	public WeatherData(Long id, String city, String mainCondition, double tempCelsius, double feelsLikeCelsius,
			double maxTempCelsius, double minTempCelsius, long timestamp) {
		super();
		this.id = id;
		this.city = city;
		this.mainCondition = mainCondition;
		this.tempCelsius = tempCelsius;
		this.feelsLikeCelsius = feelsLikeCelsius;
		this.maxTempCelsius = maxTempCelsius;
		this.minTempCelsius = minTempCelsius;
		this.timestamp = timestamp;
	}
	public WeatherData() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
}
