package com.deepak.service;

public class WeatherSummary {
	
	
	    private double avgTemperature;
	    private double maxTemperature;
	    private double minTemperature;
	    private String dominantCondition;

	    public WeatherSummary(double avgTemperature, double maxTemperature, double minTemperature, String dominantCondition) {
	        this.avgTemperature = avgTemperature;
	        this.maxTemperature = maxTemperature;
	        this.minTemperature = minTemperature;
	        this.dominantCondition = dominantCondition;
	    }

	    // Getters and Setters
	    public double getAvgTemperature() {
	        return avgTemperature;
	    }

	    public void setAvgTemperature(double avgTemperature) {
	        this.avgTemperature = avgTemperature;
	    }

	    public double getMaxTemperature() {
	        return maxTemperature;
	    }

	    public void setMaxTemperature(double maxTemperature) {
	        this.maxTemperature = maxTemperature;
	    }

	    public double getMinTemperature() {
	        return minTemperature;
	    }

	    public void setMinTemperature(double minTemperature) {
	        this.minTemperature = minTemperature;
	    }

	    public String getDominantCondition() {
	        return dominantCondition;
	    }

	    public void setDominantCondition(String dominantCondition) {
	        this.dominantCondition = dominantCondition;
	    }

	    @Override
	    public String toString() {
	        return "WeatherSummary{" +
	                "avgTemperature=" + avgTemperature +
	                ", maxTemperature=" + maxTemperature +
	                ", minTemperature=" + minTemperature +
	                ", dominantCondition='" + dominantCondition + '\'' +
	                '}';
	    }
	}


