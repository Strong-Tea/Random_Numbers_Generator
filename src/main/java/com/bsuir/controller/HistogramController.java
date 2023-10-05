package com.bsuir.controller;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import java.util.Collections;
import java.util.List;

public class HistogramController {
    @FXML
    private BarChart<String, Number> histogram;

    @FXML
    private CategoryAxis axisX;

    @FXML
    private NumberAxis axisY;

    private XYChart.Series<String, Number> series;

    /**
     * The function for initializing the histogram.
     */
    @FXML
    private void initialize() {
        series = new XYChart.Series<>();
        axisX.setLabel("Интервалы");
        axisY.setLabel("Частота");
    }

    /**
     * The function processes a list of data to be displayed on a histogram.
     *
     * @param arrayValues Array of numbers.
     * @param numIntervals number of intervals on the histogram.
     */
    public void calculateHistogram(List<Double> arrayValues, int numIntervals) {
        double min = Collections.min(arrayValues);
        double max = Collections.max(arrayValues);
        double intervalSize = (max - min) / numIntervals;

        for (int i = 0; i < numIntervals; i++) {
            double intervalStart = min + i * intervalSize;
            double intervalEnd = intervalStart + intervalSize;
            int frequency = 0;

            for (Double value : arrayValues) {
                if (value >= intervalStart && value < intervalEnd) {
                    frequency++;
                }
            }

            series.getData().add(new XYChart.Data<>(String.format("%.2f - %.2f", intervalStart, intervalEnd), frequency));
        }
        histogram.getData().add(series);
    }
}
