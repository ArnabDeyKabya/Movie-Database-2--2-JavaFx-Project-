package com.example.javafxproject6;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

public class Server {
    //List<Movies> clientMovieList;
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(3010);
        TestMain.file.readfile(TestMain.object1, TestMain.object2);
        System.out.println("Server Started");
        while (true)
        {
            Socket clientSocket = server.accept();
            System.out.println("Client Connected");
            SocketWrapper client = new SocketWrapper(clientSocket);
            new Thread(()->{

                try {


                    while(true){
                        Object data = client.read();
                        if(data instanceof  String)
                        {
                            String s = (String) data;
                            System.out.println(s);
                            System.out.println("Read Successfull");
                            List<Movies> clientMovieList;
                            clientMovieList = TestMain.object1.Search_production_company_forFX(s);
                            client.write(clientMovieList);
                            System.out.println("The size inside server is "+clientMovieList.size());
                        }
                        else if(data instanceof Movies)
                        {
                            Movies m = (Movies) data;
                            AnotherLoginPageController.titlelist.add(m);
                            TestMain.object1.add_movies_for_fx(m);
                        }
                        else if (data instanceof Double)
                        {
                            double l= (Double) data;
                            Object text1 = client.read();
                           String name = (String) text1;
                            Object text2 = client.read();
                           String production = (String) text2;
                            TestMain.object1.transfer_movie_for_fx(name, production);
                        }
                    }


                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }).start();
        }
    }
}
