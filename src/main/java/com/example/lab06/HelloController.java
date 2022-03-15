package com.example.lab06;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private BarChart barChart;
    @FXML
    private PieChart pieChart = new PieChart();

    private static String[] ageGroups = {
            "18-25", "26-35", "36-45", "46-55", "56-65", "65+"
    };
    private static int[] purchasesByAgeGroup = {
            648, 1021, 2453, 3173, 1868, 2247
    };
    private static Color[] pieColours = {
            Color.AQUA, Color.GOLD, Color.DARKORANGE,
            Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM
    };

    private static double[] avgHousingPricesByYear = {
            247381.0,264171.4,287715.3,294736.1,
            308431.4,322635.9,340253.0,363153.7
    };

    private static double[] avgCommercialPricesByYear = {
            1121585.3,1219479.5,1246354.2,1295364.8,
            1335932.6,1472362.0,1583521.9,1613246.3
    };
    @Override
    public void initialize(URL url, ResourceBundle rb){
        //Bar Chart
        barChart.setHorizontalGridLinesVisible(false);
        barChart.setVerticalGridLinesVisible(false);
        barChart.setLegendVisible(false);
        barChart.setBackground(Background.EMPTY);
        barChart.setHorizontalZeroLineVisible(false);
        barChart.setVerticalZeroLineVisible(false);
        XYChart.Series<String, Float> series1 = new XYChart.Series<>();
        for(int i=0; i<avgHousingPricesByYear.length; i++) {
            series1.getData().add(new XYChart.Data(Integer.toString(i), avgHousingPricesByYear[i]));
        }

        XYChart.Series<String, Float> series2 = new XYChart.Series<>();
        for(int i=0; i<avgCommercialPricesByYear.length; i++) {
            series2.getData().add(new XYChart.Data(Integer.toString(i), avgCommercialPricesByYear[i]));
        }

        barChart.getData().addAll(series1, series2);


        //Pie Chart
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (int i=0; i<6; i++) {
            pieChartData.add(new PieChart.Data(ageGroups[i], purchasesByAgeGroup[i]));
        }
        pieChart.setData(pieChartData);
        pieChart.setBackground(Background.EMPTY);
        pieChart.setLegendVisible(false);
    }

}

