//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties
public class Auth {
    @NotNull
    private final String password;
    @NotBlank
    private final Boolean rememberMe;
    @NotBlank
    private final String username;

    public Auth(@JsonProperty("password") String password, @JsonProperty("rememberMe") Boolean rememberMe, @JsonProperty("username") String username) {
        this.password = password;
        this.rememberMe = rememberMe;
        this.username = username;
    }

    public String toString() {
        return "{  password: " + this.password + ", rememberMe: " + this.rememberMe + ", username: " + this.username + '}';
    }
}
