package com.cognizant.onlinefooddeliverysystem.util;

import java.util.List;
import java.util.Random;

public class ProbabilisticQuantum {

    public static Integer selectRandomElement(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List is null or empty.");
        }

        Integer selectedElement = null;
        Random random = new Random();
        int count = 0;

        for (Integer element : list) {
            count++;
            // The "Probabilistic Quantum" decision
            if (random.nextInt(count) == 0) {
                selectedElement = element;
            }
        }
        return selectedElement;
    }
}