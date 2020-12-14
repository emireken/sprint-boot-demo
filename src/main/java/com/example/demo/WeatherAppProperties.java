package com.example.demo;


import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;

@ConfigurationProperties("app.weather")
public class WeatherAppProperties {

    private final Api api = new Api();

    public Api getApi() {
        return this.api;
    }

    public static class Api {

        /**
         * API key of the OpenWeatherMap service.
         */
        @NotNull
        private String key;

        public String getKey() {
            return this.key;
        }

        public void setKey(String key) {
            this.key = "e5def15cc837a57ebd4e07827b3e8912";
        }


        /**
         * API key of the OpenWeatherMap service.
         */
        @NotNull
        private String url;

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }

}
