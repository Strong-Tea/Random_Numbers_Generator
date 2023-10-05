package com.bsuir.distribution;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class GaussianDistribution {
    @FXML
    private TextField txMathExpectation;

    @FXML
    private TextField txStandardDeviation;

    @FXML
    private TextField txDistributionAccuracy;

    @FXML
    private Button btSaveParameters;

    private static double mathExpectation;

    private static double standardDeviation;

    private static int distributionAccuracy;

    /**
     * @return Gaussian distribution parameter.
     */
    public static double getExpectedMathExpectation() {
        return mathExpectation;
    }

    /**
     * @return Gaussian distribution parameter.
     */
    public static double getExpectedStandardDeviation() {
        return standardDeviation;
    }

    /**
     * @return Gaussian distribution parameter.
     */
    public static int getExpectedDistributionAccuracy() {
        return distributionAccuracy;
    }

    /**
     * The function saves the parameters of the Gaussian distribution.
     * And changes the color of the button, indicating that the button has been pressed.
     *
     * @param actionEvent The object for the interaction of the button click event.
     */
    @FXML
    private void onSaveParameters(ActionEvent actionEvent) {
        mathExpectation = Double.parseDouble(txMathExpectation.getText());
        standardDeviation = Double.parseDouble(txStandardDeviation.getText());
        distributionAccuracy = Integer.parseInt(txDistributionAccuracy.getText());
        btSaveParameters.setStyle("-fx-background-color: #E1E1E1; -fx-text-fill: white;");
    }

    /**
     * The function generates a Gaussian distribution.
     *
     * @param randomValues Array of numbers.
     * @param mathExpectation Gaussian distribution parameter.
     * @param standardDeviation Gaussian distribution parameter.
     * @param distributionAccuracy Gaussian distribution parameter.
     * @return List of values distributed by Gaussian distribution.
     */
    public static List<Double> generateGaussianDistribution(
            List<Double> randomValues,
            double mathExpectation,
            double standardDeviation,
            int distributionAccuracy
    ) {
        int n = randomValues.size();
        List<Double> gaussianDistribution = new ArrayList<>(n);

        int counter = 0;
        for (int i = 0; i < n; i++) {
            double summa = 0;
            for (int j = 0; j < distributionAccuracy; j++) {
                summa += randomValues.get(counter % n);
                counter++;
            }
            gaussianDistribution.add(abs(mathExpectation + standardDeviation * sqrt( 12.0 / distributionAccuracy) * (summa - distributionAccuracy / 2.0)));
        }
        return gaussianDistribution;
    }

    /**
     * The function changes the color of the save parameters button
     * when clicking on the parameter input field.
     *
     * @param mouseEvent Mouse Event.
     */
    public void onMathExpectationTextFieldClick(MouseEvent mouseEvent) {
        if (Objects.equals(btSaveParameters.getStyle(), "-fx-background-color: #E1E1E1; -fx-text-fill: white;"))
            btSaveParameters.setStyle("-fx-background-color:  #ea5652; -fx-text-fill: white;");
    }

    /**
     * The function changes the color of the save parameters button
     * when clicking on the parameter input field.
     *
     * @param mouseEvent Mouse Event.
     */
    public void onStandardDeviationTextFieldClick(MouseEvent mouseEvent) {
        if (Objects.equals(btSaveParameters.getStyle(), "-fx-background-color: #E1E1E1; -fx-text-fill: white;"))
            btSaveParameters.setStyle("-fx-background-color:  #ea5652; -fx-text-fill: white;");
    }

    /**
     * The function changes the color of the save parameters button
     * when clicking on the parameter input field.
     *
     * @param mouseEvent Mouse Event.
     */
    public void onDistributorAccuracyTextFieldClick(MouseEvent mouseEvent) {
        if (Objects.equals(btSaveParameters.getStyle(), "-fx-background-color: #E1E1E1; -fx-text-fill: white;"))
            btSaveParameters.setStyle("-fx-background-color:  #ea5652; -fx-text-fill: white;");
    }
}
