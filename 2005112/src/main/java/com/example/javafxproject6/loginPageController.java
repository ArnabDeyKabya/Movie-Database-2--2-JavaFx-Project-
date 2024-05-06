package com.example.javafxproject6;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class loginPageController {
    public TextField production;
    List<Movies> list = new ArrayList();

    public void onSubmitClick(ActionEvent event) throws IOException {
        list = TestMain.object1.Search_production_company_forFX(production.getText());
        if(list.size()==0)
        {
            FXMLLoader fxmlLoader = new FXMLLoader(TestMain.class.getResource("noProduction.fxml"));
            javafx.scene.Scene scene = new javafx.scene.Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            FXMLLoader fxmlLoader = new FXMLLoader(TestMain.class.getResource("productionSearching.fxml"));
            javafx.scene.Scene scene = new javafx.scene.Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }
}
