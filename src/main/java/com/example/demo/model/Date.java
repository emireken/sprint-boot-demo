/*
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Date {

    @NotNull
    private final Integer DD;

    @NotBlank
    private final Integer MM;

    @NotBlank
    private final Integer YYYY;


    public Date(@JsonProperty("DD") Integer DD,
                @JsonProperty("MM") Integer MM,
                @JsonProperty("YYYY") Integer YYYY
                ){

        this.DD = DD;
        this.MM = MM;
        this.YYYY = YYYY;
    }

    public Integer DD() {
        return DD;
    }

    public Integer MM() {
        return MM;
    }

    public Integer YYYY() {
        return YYYY;
    }



    @Override
    public String toString() {
        return "Date{" +
                "DD=" + DD +
                ", MM='" + MM +
                ", YYYY='" + YYYY +
                '}';
    }
}
*/
