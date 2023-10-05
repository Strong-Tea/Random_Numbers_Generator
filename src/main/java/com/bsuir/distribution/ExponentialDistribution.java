package com.bsuir.distribution;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Math.log;

public class ExponentialDistribution {
    @FXML
    private TextField txExpParam;

    @FXML
    private Button btSaveParameters;

    private static double expParam;

    /**
     * @return Exponential distribution parameter.
     */
    public static double getExpParam() {
        return expParam;
    }

    /**
     * The function saves the parameters of the Exponential distribution.
     * And changes the color of the button, indicating that the button has been pressed.
     *
     * @param actionEvent The object for the interaction of the button click event.
     */
    @FXML
    private void onSaveParameters(ActionEvent actionEvent) {
        expParam = Double.parseDouble(txExpParam.getText());
        btSaveParameters.setStyle("-fx-background-color: #E1E1E1; -fx-text-fill: white;");
    }

    /**
     * The function generates an Exponential distribution.
     *
     * @param randomValues Array of numbers.
     * @param expParam Exponential distribution parameter.
     * @return List of values distributed by Exponential distribution.
     */
    public static List<Double> generateExponentialDistribution(List<Double> randomValues, double expParam) {
        List<Double> gaussianDistribution = new ArrayList<>(randomValues.size());
        for (double randomValue : randomValues)
            gaussianDistribution.add(-1 / expParam * log(randomValue));
        return gaussianDistribution;
    }

    /**
     * The function changes the color of the save parameters button
     * when clicking on the parameter input field.
     *
     * @param mouseEvent Mouse Event.
     */
    public void OnExpTextFieldClick(MouseEvent mouseEvent) {
        if (Objects.equals(btSaveParameters.getStyle(), "-fx-background-color: #E1E1E1; -fx-text-fill: white;"))
            btSaveParameters.setStyle("-fx-background-color:  #ea5652; -fx-text-fill: white;");
    }
}
