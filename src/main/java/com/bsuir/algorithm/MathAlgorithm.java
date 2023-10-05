package com.bsuir.algorithm;

import java.util.*;

public class MathAlgorithm {

    /**
     * The function calculates a mathematical expectation.
     *
     * @param arrayValues Array of numbers.
     * @return Calculated mathematical expectation.
     */
    public static double calculateMathExpectation(List<Double> arrayValues) {
        double mathExpectation = 0.0;
        for (Double value : arrayValues) {
            mathExpectation += value;
        }
        mathExpectation /= arrayValues.size();

        return mathExpectation;
    }

    /**
     * The function calculates a variance.
     *
     * @param arrayValues Array of numbers.
     * @param mathExpectation mathematical expectation.
     * @return Calculated variance.
     */
    public static double calculateVariance(List<Double> arrayValues, double mathExpectation) {
        double variance = 0.0;
        for (Double value : arrayValues) {
            double difference = value - mathExpectation;
            variance += difference * difference;
        }
        variance /= arrayValues.size();
        return  variance;
    }

    /**
     * The function calculates a periodicity.
     *
     * @param arrayValues Array of numbers.
     * @return Calculated periodicity.
     */
    public static int calculatePeriodicity(List<Double> arrayValues) {
        HashSet<Double> periodacity = new HashSet<>(arrayValues);

        if (periodacity.size() == arrayValues.size())
            return periodacity.size();

        int nextIndexAfterLastPeriodacity = periodacity.size();

        for (int i = 0; i < nextIndexAfterLastPeriodacity; i++) {
            if (Objects.equals(arrayValues.get(nextIndexAfterLastPeriodacity), arrayValues.get(i)))
                return nextIndexAfterLastPeriodacity - i;
        }

        return -1;
    }

    /**
     * The function calculates an aperiodicity.
     *
     * @param arrayValues Array of numbers.
     * @return Calculated aperiodicity.
     */
    public static int calculateAperiodicity(List<Double> arrayValues) {
        Set<Double> aperiodacity = new HashSet<>(arrayValues);
        return aperiodacity.size();
    }
}
