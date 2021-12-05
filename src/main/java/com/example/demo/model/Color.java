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
public class Color {
    @NotNull
    private final String id;
    @NotBlank
    private final String description;
    @NotBlank
    private final Integer modelId;

    public Color(@JsonProperty("id") String id, @JsonProperty("description") String description, @JsonProperty("modelId") Integer modelId) {
        this.id = id;
        this.description = description;
        this.modelId = modelId;
    }

    public String getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public Integer getModel() {
        return this.modelId;
    }

    public String toString() {
        return "Color{id=" + this.id + ", description='" + this.description + ", modelId='" + this.modelId + '}';
    }
}
