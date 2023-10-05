package com.bsuir.distribution;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SimpsonDistribution {
    @FXML
    private TextField txLeftBorder;

    @FXML
    private TextField txRightBorder;

    @FXML
    private Button btSaveParameters;

    private static double leftBorder;

    private static double rightBorder;

    /**
     * @return Simpson distribution parameter.
     */
    public static double getLeftBorder() {
        return leftBorder;
    }

    /**
     * @return Simpson distribution parameter.
     */
    public static double getRightBorder() {
        return rightBorder;
    }

    /**
     * The function saves the parameters of the Simpson distribution.
     * And changes the color of the button, indicating that the button has been pressed.
     *
     * @param actionEvent The object for the interaction of the button click event.
     */
    @FXML
    private void onSaveParameters(ActionEvent actionEvent) {
        leftBorder = Double.parseDouble(txLeftBorder.getText());
        rightBorder = Double.parseDouble(txRightBorder.getText());
        btSaveParameters.setStyle("-fx-background-color: #E1E1E1; -fx-text-fill: white;");
    }

    /**
     * The function generates a Simpson distribution.
     *
     * @param randomValues Array of numbers.
     * @param leftBorder Simpson distribution parameter.
     * @param rightBorder Simpson distribution parameter.
     * @return List of values distributed by Simpson distribution.
     */
    public static List<Double> generateSimpsonDistribution(List<Double> randomValues, double leftBorder, double rightBorder) {
        int n = randomValues.size();
        List<Double> simpsonDistribution = new ArrayList<>(n);

        int secondValueIndex = 1;
        for (Double randomValue : randomValues) {
            double uniform1 = leftBorder / 2.0 + (rightBorder / 2.0 - leftBorder / 2.0) * randomValue;
            double uniform2 = leftBorder / 2.0 + (rightBorder / 2.0 - leftBorder / 2.0) * randomValues.get(secondValueIndex++);

            simpsonDistribution.add(uniform1 + uniform2);
            if (secondValueIndex == n)
                secondValueIndex = 0;
        }

        return simpsonDistribution;
    }

    /**
     * The function changes the color of the save parameters button
     * when clicking on the parameter input field.
     *
     * @param mouseEvent Mouse Event.
     */
    public void onLeftBorderTextFieldClick(MouseEvent mouseEvent) {
        if (Objects.equals(btSaveParameters.getStyle(), "-fx-background-color: #E1E1E1; -fx-text-fill: white;"))
            btSaveParameters.setStyle("-fx-background-color:  #ea5652; -fx-text-fill: white;");
    }

    /**
     * The function changes the color of the save parameters button
     * when clicking on the parameter input field.
     *
     * @param mouseEvent Mouse Event.
     */
    public void onRightBorderTextFieldClick(MouseEvent mouseEvent) {
        if (Objects.equals(btSaveParameters.getStyle(), "-fx-background-color: #E1E1E1; -fx-text-fill: white;"))
            btSaveParameters.setStyle("-fx-background-color:  #ea5652; -fx-text-fill: white;");
    }
}
