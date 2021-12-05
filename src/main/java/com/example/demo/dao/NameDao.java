//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.dao;

import com.example.demo.model.Name;
import java.util.List;
import javax.validation.constraints.NotBlank;

public interface NameDao {
    @NotBlank
    String getRandomName();

    List<Name> getNumberOfRandomName(Integer numberOfRandom);
}
