package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GenResult {

    private final List<Name> nameList;

    private final List numberList;


    public GenResult(@JsonProperty("nameList") List<Name> nameList,
                  @JsonProperty("numberList") List numberList
                   ){

        this.nameList = nameList;
        this.numberList = numberList;
    }

    public List<Name>  getNameList() {
        return nameList;
    }

    public List getNumberList() {
        return numberList;
    }


    @Override
    public String toString() {
        return "GenResult{" +
                "nameList=" + nameList +
                ", numberList='" + numberList +
                '}';
    }
}
