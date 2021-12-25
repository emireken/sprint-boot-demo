//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class ResultGen {
    private final List name;
    private final List number;

    public ResultGen(List name, List number) {
        this.name = name;
        this.number = number;
    }

    public List getName(ArrayList resultName) {
        return this.name;
    }

    public List getNumber(ArrayList resultNumber) {
        return this.number;
    }

    public String toString() {
        return "[{name=" + this.name + ", number='" + this.number + "}]";
    }
}
