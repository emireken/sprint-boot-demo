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
public class DataType {
    @NotNull
    public final Integer id;
    @NotBlank
    public String data_type_name;
    @NotBlank
    public final String data_type;
    @NotBlank
    public final String data_unit;

    public DataType(@JsonProperty("id") Integer id, @JsonProperty("data_type_name") String data_type_name, @JsonProperty("data_type") String data_type, @JsonProperty("data_unit") String data_unit) {
        this.id = id;
        this.data_type_name = data_type_name;
        this.data_type = data_type;
        this.data_unit = data_unit;
    }

    public Integer getId() {
        return this.id;
    }
}
