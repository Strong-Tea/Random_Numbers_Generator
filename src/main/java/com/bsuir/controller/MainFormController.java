package com.bsuir.controller;

import com.bsuir.algorithm.LehmerAlgorithm;
import com.bsuir.distribution.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import static com.bsuir.algorithm.MathAlgorithm.*;
import static java.lang.Math.sqrt;

public class MainFormController {
    @FXML
    private MenuItem miNoneDistribution;

    @FXML
    private MenuItem miUniformDistribution;

    @FXML
    private MenuItem miGaussianDistribution;

    @FXML
    private MenuItem miExponentialDistribution;

    @FXML
    private MenuItem miGammaDistribution;

    @FXML
    private MenuItem miTriangularDistribution;

    @FXML
    private MenuItem miSimpsonDistribution;

    @FXML
    private TextField txR0;

    @FXML
    private TextField txM;

    @FXML
    private TextField txA;

    @FXML
    private TextField txN;

    @FXML
    private Label lPeriodicity;

    @FXML
    private Label lAperiodicity;

    @FXML
    private Label lMathExpect;

    @FXML
    private Label lVariance;

    @FXML
    private Label lStdDeviation;

    @FXML
    public MenuButton mbDistribution;

    private List<Double> randomValues = new ArrayList<>();

    /**
     * The function is triggered by pressing the button.
     * The function generates random values using Lehmer's algorithm
     * and calculates statistics for the generated numbers.
     */
    @FXML
    protected void onCalculateClick() throws IOException {

        randomValues = LehmerAlgorithm.generateRandomNumbers(
                Integer.parseInt(txR0.getText()),
                Integer.parseInt(txM.getText()),
                Integer.parseInt(txA.getText()),
                Integer.parseInt(txN.getText())
        );

        switch (mbDistribution.getText()) {
            case "Равномерное" -> randomValues = UniformDistribution.generateUniformDistribution(
                    randomValues,
                    UniformDistribution.getLeftBorder(),
                    UniformDistribution.getRightBorder()
            );
            case "Гауссовское" -> randomValues = GaussianDistribution.generateGaussianDistribution(
                    randomValues,
                    GaussianDistribution.getExpectedMathExpectation(),
                    GaussianDistribution.getExpectedStandardDeviation(),
                    GaussianDistribution.getExpectedDistributionAccuracy()
            );
            case "Экспоненциальное" -> randomValues = ExponentialDistribution.generateExponentialDistribution(
                    randomValues,
                    ExponentialDistribution.getExpParam()
            );
            case "Гамма" -> randomValues = GammaDistribution.generateGammaDistribution(
                    randomValues,
                    GammaDistribution.getLambda(),
                    GammaDistribution.getEta()
            );
            case "Треугольное" -> randomValues = TriangularDistribution.generateTriangularDistribution(
                    randomValues,
                    TriangularDistribution.getLeftBorder(),
                    TriangularDistribution.getRightBorder()
            );
            case "Симпсона" -> randomValues = SimpsonDistribution.generateSimpsonDistribution(
                    randomValues,
                    SimpsonDistribution.getLeftBorder(),
                    SimpsonDistribution.getRightBorder()
            );
        }

        double mathExpectation = calculateMathExpectation(randomValues);
        double variance = calculateVariance(randomValues, mathExpectation);
        double stdDeviation = sqrt(variance);
        int periodicity = calculatePeriodicity(randomValues);
        int aperiodicity = calculateAperiodicity(randomValues);

        lMathExpect.setText("Матожидание: " + mathExpectation);
        lVariance.setText("Дисперсия: " + variance);
        lStdDeviation.setText("СКО: " + stdDeviation);
        lPeriodicity.setText("Переодичность: " + periodicity);
        lAperiodicity.setText("Апереодичность: " + aperiodicity);
    }

    /**
     * The function is triggered by pressing the button.
     * The function builds a histogram of the obtained values according to the Lehmer algorithm.
     */
    @FXML
    public void onBuildHistogram(ActionEvent actionEvent) throws IOException {
        Stage secondStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HistogramController.class.getResource("gui-histogram.fxml"));
        secondStage.setScene(new Scene(fxmlLoader.load(), 800, 600));
        HistogramController histogramController = fxmlLoader.getController();
        histogramController.calculateHistogram(randomValues, 20);
        secondStage.show();
    }

    @FXML
    public void onNoneDistribution(ActionEvent actionEvent) {
        mbDistribution.setText(miNoneDistribution.getText());
    }

    /**
     * The function is called when the Gaussian distribution is selected from the menu.
     * The function displays a custom window for entering parameters for the Gaussian distribution.
     */
    @FXML
    public void onGaussianDistribution(ActionEvent actionEvent) throws IOException {
        mbDistribution.setText(miGaussianDistribution.getText());
        Stage gaussianStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(GaussianDistribution.class.getResource("gaussian-distribution.fxml"));
        gaussianStage.setScene(new Scene(fxmlLoader.load(), 400, 250));
        gaussianStage.show();
    }

    /**
     * The function is called when the Uniform distribution is selected from the menu.
     * The function displays a custom window for entering parameters for the Uniform distribution.
     */
    @FXML
    public void onUniformDistribution(ActionEvent actionEvent) throws IOException {
        mbDistribution.setText(miUniformDistribution.getText());
        Stage uniformStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(UniformDistribution.class.getResource("uniform-distribution.fxml"));
        uniformStage.setScene(new Scene(fxmlLoader.load(), 400, 200));
        uniformStage.show();
    }

    /**
     * The function is called when the Exponential distribution is selected from the menu.
     * The function displays a custom window for entering parameters for the Exponential distribution.
     */
    @FXML
    public void onExponentialDistribution(ActionEvent actionEvent) throws IOException {
        mbDistribution.setText(miExponentialDistribution.getText());
        Stage exponentialStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(ExponentialDistribution.class.getResource("exponential-distribution.fxml"));
        exponentialStage.setScene(new Scene(fxmlLoader.load(), 400, 150));
        exponentialStage.show();
    }

    /**
     * The function is called when the Gamma distribution is selected from the menu.
     * The function displays a custom window for entering parameters for the Gamma distribution.
     */
    @FXML
    public void onGammaDistribution(ActionEvent actionEvent) throws IOException {
        mbDistribution.setText(miGammaDistribution.getText());
        Stage gammaStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(GammaDistribution.class.getResource("gamma-distribution.fxml"));
        gammaStage.setScene(new Scene(fxmlLoader.load(), 400, 200));
        gammaStage.show();
    }

    /**
     * The function is called when the Triangular distribution is selected from the menu.
     * The function displays a custom window for entering parameters for the Triangular distribution.
     */
    @FXML
    public void onTriangularDistribution(ActionEvent actionEvent) throws IOException {
        mbDistribution.setText(miTriangularDistribution.getText());
        Stage triangularStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(TriangularDistribution.class.getResource("triangular-distribution.fxml"));
        triangularStage.setScene(new Scene(fxmlLoader.load(), 400, 200));
        triangularStage.show();
    }

    /**
     * The function is called when the Simpson distribution is selected from the menu.
     * The function displays a custom window for entering parameters for the Simpson distribution.
     */
    @FXML
    public void onSimpsonDistribution(ActionEvent actionEvent) throws IOException {
        mbDistribution.setText(miSimpsonDistribution.getText());
        Stage simpsonStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(SimpsonDistribution.class.getResource("simpson-distribution.fxml"));
        simpsonStage.setScene(new Scene(fxmlLoader.load(), 400, 250));
        simpsonStage.show();
    }
}