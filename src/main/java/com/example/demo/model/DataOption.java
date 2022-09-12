//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class DataOption {
    @NotNull
    public final Integer id;
    @NotBlank
    public String data_option_name;
    @NotBlank
    public String data_option;

    public DataOption(@JsonProperty("id") Integer id, @JsonProperty("data_option_name") String data_option_name, @JsonProperty("data_option") String data_option) {
        this.id = id;
        this.data_option_name = data_option_name;
        this.data_option = data_option;
    }

    public Integer getId() {
        return this.id;
    }
}
