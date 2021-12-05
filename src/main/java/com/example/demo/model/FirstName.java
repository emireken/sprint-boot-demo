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
public class FirstName {
    @NotNull
    public final Integer id;
    @NotBlank
    public String first_name;
    @NotBlank
    public final String locale;
    @NotBlank
    public final String gender;

    public FirstName(@JsonProperty("id") Integer id, @JsonProperty("first_name") String first_name, @JsonProperty("locale") String locale, @JsonProperty("gender") String gender) {
        this.id = id;
        this.first_name = first_name;
        this.locale = locale;
        this.gender = gender;
    }

    public Integer getId() {
        return this.id;
    }

    public String getLocale() {
        return this.locale;
    }

    public String getGender() {
        return this.gender;
    }
}
