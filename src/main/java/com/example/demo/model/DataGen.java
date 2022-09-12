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
    @NotBlank
    private final Object DataOption;
    @NotBlank
    private final Object OptionInput;


    public DataGen(@JsonProperty("DataSize") Integer DataSize, @JsonProperty("DataList") Object DataList, @JsonProperty("DataOption") Object DataOption, @JsonProperty("OptionInput") String OptionInput) {
        this.DataSize = DataSize;
        this.DataList = DataList;
        this.DataOption = DataOption;
        this.OptionInput = OptionInput;
    }

    public Integer getDataSize() {
        return this.DataSize;
    }

    public Object getDataList() {
        return this.DataList;
    }

    public Object getOptionList() {
        return this.DataOption;
    }

    public Object getOptionInputList() {
        return this.OptionInput;
    }


    public String toString() {
        return "GenData{DataSize=" + this.DataSize + ", DataList='" + this.DataList + ", DataOption='" + this.DataOption +", OptionInput='" + this.OptionInput +'}';
    }

//    public String toString() {
//        return "GenData{DataSize=" + this.DataSize + ", DataList='" + this.DataList + '}';
//    }
}
