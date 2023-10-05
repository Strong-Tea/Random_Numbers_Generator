package com.bsuir.algorithm;

import java.util.ArrayList;
import java.util.List;

public class LehmerAlgorithm {
    /**
     * The function generates random values according to Lehmer's algorithm.
     *
     * @param R0 Initial state of the algorithm.
     * @param m Module.
     * @param a Coefficient.
     * @param n Number of generated numbers.
     * @return List of generated numbers.
     */
    public static List<Double> generateRandomNumbers(int R0, int m, int a, int n) {
        List<Double> randomValues = new ArrayList<>(n);
        long currentR = R0;
        for (int i = 0; i < n; i++) {
            long nextR = (a * currentR) % m;
            double randomValue = (double) nextR / m; // Conversion to a random number in the interval [0, 1)
            randomValues.add(randomValue);
            currentR = nextR;
        }
        return randomValues;
    }
}
