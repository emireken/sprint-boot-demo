//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.io.Serializable;
import java.util.Map;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class Icing implements Serializable {
    private Integer visibility;
    private Double temp;
    private Integer pressure;
    private Integer humidity;

    public Icing(@JsonProperty("visibility") Integer visibility, @JsonProperty("temp") Double temp, @JsonProperty("pressure") Integer pressure, @JsonProperty("humidity") Integer humidity) {
        this.visibility = visibility;
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public Integer visibility() {
        return this.visibility;
    }

    @JsonSetter("temp")
    public void setTemp(Double temp) {
        this.temp = temp;
    }

    @JsonProperty("temp")
    public double getTemp() {
        return this.temp;
    }

    @JsonSetter("pressure")
    public Integer setPressure(Integer pressure) {
        return this.pressure = pressure;
    }

    @JsonProperty("pressure")
    public Integer getPressure() {
        return this.pressure;
    }

    @JsonSetter("humidity")
    public int setHumidity(Integer humidity) {
        return this.humidity = humidity;
    }

    @JsonProperty("humidity")
    public Integer getHumidity() {
        return this.humidity;
    }

    @JsonProperty("main")
    public void getMain(Map<String, Object> main) {
        this.setTemp((Double)main.get("temp"));
        this.setPressure((Integer)main.get("pressure"));
        this.setHumidity((Integer)main.get("humidity"));
    }
}
