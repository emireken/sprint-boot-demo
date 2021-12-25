//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.service;

import java.util.ArrayList;
import javax.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

@Service
public class NumberService {
    public NumberService() {
    }

    @NotBlank
    public static Integer getRandomPercent() {
        int randomPercent = (int)(Math.random() * 100.0D);
        return randomPercent;
    }

    public static int getRandomNumber() {

            int randomNumber = (int)(Math.random() * 100.0D);

        return randomNumber;
    }

    public static ArrayList getNumberOfRandomNumber(Integer numberOfRandom) {
        ArrayList randomNumberList = new ArrayList();

        for(int i = 0; i < numberOfRandom; ++i) {
            int randomNumber = (int)(Math.random() * 100.0D);
            randomNumberList.add(i, randomNumber);
        }

        return randomNumberList;
    }

    @NotBlank
    public static Integer getRandomNumberMinMax(Integer min, Integer max) {
        int randomPercent = (int)(Math.random() * (double)(max - min) + (double)min);
        return randomPercent;
    }
}