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
public class Name {
//    @NotNull
//    private final Integer id;
    @NotBlank
    private final String first_name;
    @NotBlank
    private final String last_name;
//    @NotBlank
//    private final String locale;
//    @NotBlank
//    private final String gender;

//    public Name(@JsonProperty("id") Integer id, @JsonProperty("first_name") String first_name, @JsonProperty("last_name") String last_name, @JsonProperty("locale") String locale, @JsonProperty("gender") String gender) {
public Name(@JsonProperty("first_name") String first_name, @JsonProperty("last_name") String last_name) {
//        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
//        this.locale = locale;
//        this.gender = gender;
    }

//    public Integer getId() {
//        return this.id;
//    }

    public String getFirstName() {
        return this.first_name;
    }

    public String getLastName() {
        return this.last_name;
    }
//
//    public String getLocale() {
//        return this.locale;
//    }
//
//    public String getGender() {
//        return this.gender;
//    }

    public String toString() {
//        return "Name{id=" + this.id + ", first_name='" + this.first_name + ", last_name='" + this.last_name + ", locale='" + this.locale + ", gender='" + this.gender + '}';
        return "Name{" + this.first_name +" "+ this.last_name+'}';
    }
}
