//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.dao;

import com.example.demo.model.Color;
import java.util.List;

public interface ColorDao {
    List<Color> selectAllColors();

    List<Color> selectColorsByModel(Integer modelId);
}
