package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.Column;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather{

  public Weather(
                   @JsonProperty("weatherId") Integer weatherId,
                   @JsonProperty("temperature") Integer temperature,
                   @JsonProperty("weatherMain") String weatherMain,
                   @JsonProperty("weatherIcon") String weatherIcon,
                   @JsonProperty("weatherDescription") String weatherDescription,
                   @JsonProperty("countryCode") String countryCode,
                   @JsonProperty("name") String name,
                   @JsonProperty("timestamp") Long timestamp,
                   @JsonProperty("sunrise") Long sunrise,
                   @JsonProperty("sunset") Long sunset){
        this.weatherId = weatherId;
        this.temperature = temperature;
        this.weatherMain = weatherMain;
        this.weatherIcon = weatherIcon;
        this.weatherDescription = weatherDescription;
        this.countryCode = countryCode;
        this.name = name;
        this.timestamp = timestamp;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    private String name;

    private long timestamp;

    private double temperature;

    private Integer weatherId;

    @Column(name = "weatherIcon", nullable = false)
    private String weatherIcon;

    @Column(name = "weatherMain", nullable = false)
    private String weatherMain;

    @Column(name = "weatherDescription", nullable = false)
    private String weatherDescription;

    @Column(name = "countryCode", nullable = false)
    private String countryCode;

    private long sunrise;

    private long sunset;

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("timestamp")
    public long getTimestamp() {
        return this.timestamp;
    }

    @JsonSetter("dt")
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getTemperature() {
        return this.temperature;
    }

    public void setTemperature(double temperatureKelvin) {
        this.temperature = temperatureKelvin;
    }

    @JsonProperty("main")
    public void setMain(Map<String, Object> main) {
        double kelvinTemp = Double.parseDouble(main.get("temp").toString());
        setTemperature(kelvinTemp);
    }

    public Integer getWeatherId() {
        return this.weatherId;
    }

    public void setWeatherId(Integer weatherId) {
        this.weatherId = weatherId;
    }

    public String getWeatherIcon() {
        return this.weatherIcon;
    }

    public void setWeatherIcon(String weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public String getWeatherMain() {
        return weatherMain;
    }

    public void setWeatherMain(String weatherMain) {
        this.weatherMain = weatherMain;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    @JsonProperty("weather")
    public void setWeather(List<Map<String, Object>> weatherEntries) {
        Map<String, Object> weather = weatherEntries.get(0);
        setWeatherId((Integer) weather.get("id"));
        setWeatherIcon((String) weather.get("icon"));
        setWeatherMain((String) weather.get("main"));
        setWeatherDescription((String) weather.get("description"));
    }

    @JsonProperty("sunrise")
    public long getSunrise() {
        return this.sunrise;
    }

    @JsonSetter("sunrise")
    public void setSunrise(long timestamp) {
        this.sunrise = timestamp;
    }

    @JsonProperty("sunset")
    public long getSunset() {
        return this.sunset;
    }

    @JsonSetter("sunset")
    public void setSunset(long timestamp) {
        this.sunset = timestamp;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("sys")
    public void setSys(Map<String, Object> sys) {
        setCountryCode((String) sys.get("country"));
        setSunrise((int)sys.get("sunrise"));
        setSunset((int)sys.get("sunset"));

    }
}
