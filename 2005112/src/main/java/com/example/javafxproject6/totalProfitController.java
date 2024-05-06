package com.example.javafxproject6;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class totalProfitController implements Initializable {
    public Label profit;
    public Label production;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        production.setText(AnotherLoginPageController.name.toUpperCase());
        long pro = TestMain.object1.total_profit_forfx();
        profit.setText(String.valueOf(pro));
    }

    public void onGoBackToSearchPageClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TestMain.class.getResource("productionSearching.fxml"));
        javafx.scene.Scene scene = new javafx.scene.Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
