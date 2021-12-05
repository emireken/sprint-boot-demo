//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties
public class Token {
    @NotNull
    private final Integer status;
    @NotBlank
    private final List headers;

    public Token(@JsonProperty("status") Integer status, @JsonProperty("headers") List headers) {
        this.status = status;
        this.headers = headers;
    }
}
