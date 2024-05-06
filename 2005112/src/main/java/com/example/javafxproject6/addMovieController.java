package com.example.javafxproject6;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class addMovieController {
    public TextField title;
    public TextField year;
    public TextField genre1;
    public TextField genre2;
    public TextField genre3;
    public TextField runtime;
    public TextField budget;
    public TextField revenue;
    public Label confirm;
    String[] s = new String[3];
    int y;
    int run;
    long bud;
    long rev;

    public void onAddMovieClick(ActionEvent event) throws IOException {
        y = Integer.parseInt(year.getText());
        run = Integer.parseInt(runtime.getText());
        bud = Long.parseLong(budget.getText());
        rev = Long.parseLong(revenue.getText());
        s[0] = genre1.getText();
        s[1] = genre2.getText();
        s[2] = genre3.getText();
        Movies mov = new Movies(title.getText(), y, s, run, AnotherLoginPageController.name, bud, rev);
        confirm.setText("You Have Successfully Added Movie.");
        System.out.println(AnotherLoginPageController.titlelist.size());
        AnotherLoginPageController.server.write(mov);
        AnotherLoginPageController.titlelist.add(mov);
    }

    public void onGoBackClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TestMain.class.getResource("productionSearching.fxml"));
        javafx.scene.Scene scene = new javafx.scene.Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
