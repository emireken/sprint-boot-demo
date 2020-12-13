package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

    @NotNull
    private final Integer id;

    @NotBlank
    private final Integer visibility;


    public Weather(@JsonProperty("id") Integer id,
                   @JsonProperty("visibility") Integer visibility) {

        this.id = id;
        this.visibility = visibility;
    }

        public Integer getId() {
            return id;
        }
        public Integer getVisibility() {
            return visibility;
        }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                "visibility" + visibility +
                '}';
    }
}
