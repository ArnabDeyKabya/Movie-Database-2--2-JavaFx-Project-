package com.example.javafxproject6;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class transferMovieController {
    public TextField title;
    public TextField production;
    public Label confirmTransfer;

    public void onTransferClick(ActionEvent event) throws IOException {
        confirmTransfer.setText("You Have Successfully Transferred Movie");

        AnotherLoginPageController.server.write(2.0);
        AnotherLoginPageController.server.write(title.getText());
        AnotherLoginPageController.server.write(production.getText());
    }

    public void onGoBackClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TestMain.class.getResource("productionSearching.fxml"));
        javafx.scene.Scene scene = new javafx.scene.Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
