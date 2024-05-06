package com.example.javafxproject6;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class productionSearchingController implements Initializable {
    public Label welcome;

    public void onMostRecentMoviesClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TestMain.class.getResource("tableMostRecentMovies.fxml"));
        javafx.scene.Scene scene = new javafx.scene.Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void onMoviesWithMaxRevenueClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TestMain.class.getResource("tableMaxRevenue.fxml"));
        javafx.scene.Scene scene = new javafx.scene.Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void onTotalProfitClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TestMain.class.getResource("totalProfit.fxml"));
        javafx.scene.Scene scene = new javafx.scene.Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void onAddMovieClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TestMain.class.getResource("addMovie.fxml"));
        javafx.scene.Scene scene = new javafx.scene.Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void onTranferMovieClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TestMain.class.getResource("transferMovie.fxml"));
        javafx.scene.Scene scene = new javafx.scene.Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void onReloadClick(ActionEvent event) throws IOException {
        System.out.println(AnotherLoginPageController.name);
        AnotherLoginPageController.server.write(AnotherLoginPageController.name);
    }

    public void onShowAllMoviesClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TestMain.class.getResource("showAllMovies.fxml"));
        javafx.scene.Scene scene = new javafx.scene.Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void onExitClick(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        welcome.setText(AnotherLoginPageController.name.toUpperCase());

    }
}
