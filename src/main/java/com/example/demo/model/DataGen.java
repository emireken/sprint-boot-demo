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
public class DataGen {
    @NotNull
    private final Integer DataSize;
    @NotBlank
    private final Object DataList;

    public DataGen(@JsonProperty("DataSize") Integer DataSize, @JsonProperty("DataList") Object DataList) {
        this.DataSize = DataSize;
        this.DataList = DataList;
    }

    public Integer getDataSize() {
        return this.DataSize;
    }

    public Object getDataList() {
        return this.DataList;
    }

    public String toString() {
        return "GenData{DataSize=" + this.DataSize + ", DataList='" + this.DataList + '}';
    }
}
