package com.example.javafxproject6;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

public class noProductionController {
    public void onGoBackToLoginPageClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TestMain.class.getResource("loginPage.fxml"));
        javafx.scene.Scene scene = new javafx.scene.Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
