package com.example.javafxproject6;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnotherLoginPageController extends Application {
    public TextField production;
    static SocketWrapper server;
    static List<Movies> titlelist=new ArrayList<>();
    public  static String name;

    private static Stage stage;


    public void start(Stage stage) throws IOException {
        this.stage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(TestMain.class.getResource("loginPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        server = new SocketWrapper("127.0.0.1", 3010);
        new Thread(()->{
            while(true){
                try {
                    Object ob = server.read();
                    titlelist.clear();
                    titlelist = (ArrayList<Movies>) ob;

                    Platform.runLater(() -> {
                        if(titlelist.size()==0)
                        {
                            FXMLLoader fxmlLoader = new FXMLLoader(TestMain.class.getResource("noProduction.fxml"));
                            Scene scene = null;
                            try {
                                scene = new Scene(fxmlLoader.load());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            stage.setScene(scene);
                            stage.show();
                        }
                        else
                        {
                            FXMLLoader fxmlLoader = new FXMLLoader(TestMain.class.getResource("productionSearching.fxml"));
                            Scene scene = null;
                            try {
                                scene = new Scene(fxmlLoader.load());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            stage.setScene(scene);
                            stage.show();
                        }
                    });

                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        launch();
    }

    public void onSubmitClick(ActionEvent event) throws IOException {
            name = production.getText();
            server.write(production.getText());
    }
}
