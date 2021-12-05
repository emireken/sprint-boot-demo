//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.service;

import com.example.demo.dao.ColorDataAccessService;
import com.example.demo.model.Color;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColorService {
    private final ColorDataAccessService colorDataAccessService;

    @Autowired
    public ColorService(ColorDataAccessService colorDataAccessService) {
        this.colorDataAccessService = colorDataAccessService;
    }

    public List<Color> getAllColors() {
        return this.colorDataAccessService.selectAllColors();
    }

    public List<Color> getColorsByModel(Integer modelId) {
        return this.colorDataAccessService.selectColorsByModel(modelId);
    }
}
