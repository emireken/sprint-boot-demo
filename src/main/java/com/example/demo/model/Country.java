package com.example.demo.model;

import com.example.demo.api.domain.LatLng;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

    @NotNull
    private final Integer id;

    @NotBlank
    private final String name;

    @NotBlank
    private final String capital;

    private List<LatLng> LatLng;

    public Country(@JsonProperty("id") Integer id,
                   @JsonProperty("name") String name,
                   @JsonProperty("capital") String capital
                   ){

        this.id = id;
        this.name = name;
        this.capital = capital;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name +
                ", capital='" + capital +
                '}';
    }
}
