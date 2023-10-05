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

public class GammaDistribution {

    @FXML
    private TextField txLambda;

    @FXML
    private TextField txEta;

    @FXML
    private Button btSaveParameters;

    private static double lambda;

    private static int eta;

    /**
     * @return Gamma distribution parameter.
     */
    public static double getLambda() {
        return lambda;
    }

    /**
     * @return Gamma distribution parameter.
     */
    public static int getEta() {
        return eta;
    }

    /**
     * The function saves the parameters of the Gamma distribution.
     * And changes the color of the button, indicating that the button has been pressed.
     *
     * @param actionEvent The object for the interaction of the button click event.
     */
    @FXML
    private void onSaveParameters(ActionEvent actionEvent) {
        lambda = Double.parseDouble(txLambda.getText());
        eta = Integer.parseInt(txEta.getText());
        btSaveParameters.setStyle("-fx-background-color: #E1E1E1; -fx-text-fill: white;");
    }

    /**
     * The function generates a Gamma distribution.
     *
     * @param randomValues Array of numbers.
     * @param lambda Gamma distribution parameter.
     * @param eta Gamma distribution parameter.
     * @return List of values distributed by Gamma distribution.
     */
    public static List<Double> generateGammaDistribution(List<Double> randomValues, double lambda, int eta) {
        int counter = 0;
        int n = randomValues.size();
        List<Double> exponentialDistribution = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            double multiplier = 1;
            for (int j = 1; j <= eta; j++) {
                multiplier *= randomValues.get((j + counter) % n);
                counter++;
            }
            exponentialDistribution.add(-1.0 / lambda * log(multiplier));
        }
        return exponentialDistribution;
    }

    /**
     * The function changes the color of the save parameters button
     * when clicking on the parameter input field.
     *
     * @param mouseEvent Mouse Event.
     */
    public void onLambdaTextFieldClick(MouseEvent mouseEvent) {
        if (Objects.equals(btSaveParameters.getStyle(), "-fx-background-color: #E1E1E1; -fx-text-fill: white;"))
            btSaveParameters.setStyle("-fx-background-color:  #ea5652; -fx-text-fill: white;");
    }

    /**
     * The function changes the color of the save parameters button
     * when clicking on the parameter input field.
     *
     * @param mouseEvent Mouse Event.
     */
    public void onEtaTextFieldClick(MouseEvent mouseEvent) {
        if (Objects.equals(btSaveParameters.getStyle(), "-fx-background-color: #E1E1E1; -fx-text-fill: white;"))
            btSaveParameters.setStyle("-fx-background-color:  #ea5652; -fx-text-fill: white;");
    }
}
