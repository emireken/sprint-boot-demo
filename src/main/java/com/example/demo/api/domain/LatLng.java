package com.example.demo.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LatLng {

        private ArrayList latlng;

        public LatLng(
                @JsonProperty("latlng") ArrayList latlng){

            this.latlng = latlng;
        }
    public ArrayList getLatLng() {
        return latlng;
    }

    @Override
    public String toString() {
        return "" + latlng;
    }
}