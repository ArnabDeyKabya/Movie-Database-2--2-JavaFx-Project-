package com.example.javafxproject6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.lang.model.element.NestingKind;
import java.io.*;
import java.util.*;

import static javafx.application.Application.launch;

public class TestMain {
    public static MoveiData object1 = new MoveiData();
    public static MoveiData object2 = new MoveiData();
    public static production object3 = new production();
    public static FileRead file = new FileRead();


//    public static void main(String args[]) throws Exception {
//        file.readfile(object1, object2);
//        launch();
//        //main_menu();
//    }
//    public static void main_menu() throws Exception {
//        System.out.println("Main menu:");
//        System.out.println("1) Search Movies");
//        System.out.println("2) Search Production Companies");
//        System.out.println("3) Add Movie");
//        System.out.println("4) Exit System");
//        Scanner scn = new Scanner(System.in);
//        System.out.println("Enter your option(1-4): ");
//       int user_selected;
//        do {
//            user_selected = scn.nextInt();
//            switch(user_selected){
//                case 1://search movie
//                    int search_selection;
//                    do {
//                        search_selection = movei_searching_menu();
//                        switch (search_selection){
//                            case 1:
//                                Movies mov;
//                                System.out.println("Enter the movie title : ");
//                                Scanner scn4 = new Scanner(System.in);
//                                String name4 = scn4.nextLine();
//                                mov =object1.search_by_movie_title(name4);
//                                if(mov == null) System.out.println("No such movie with this name");
//                                else mov.printMovei();
//                                main_menu();
//                                break;
//                            case 2:
//                                System.out.println("Enter the movie's releasing year : ");
//                                Scanner scn5 = new Scanner(System.in);
//                                int year = scn5.nextInt();
//                                List<Movies> List4 = new ArrayList();
//                                List4=object1.search_by_release_year(year);
//                                if(List4.size()==0)
//                                {
//                                    System.out.println("No such movie with this release year");
//                                }
//                                else{
//                                    for(Movies mov1 : List4)
//                                    {
//                                        mov1.printMovei();
//                                    }
//                                }
//                                main_menu();
//                                break;
//                            case 3:
//                                System.out.println("Enter the movie genre : ");
//                                Scanner scn6 = new Scanner(System.in);
//                                String name = scn6.nextLine();
//                                List<Movies> List6 = new ArrayList();
//                                List6 = object1.search_by_genre(name);
//                                if(List6.size()==0)
//                                {
//                                    System.out.println("No such movie with this genre");
//                                }
//                                else{
//                                    for(Movies mov2 : List6)
//                                    {
//                                        mov2.printMovei();
//                                    }
//                                }
//                                main_menu();
//                                break;
//                            case 4:
//                                System.out.println("Enter the movie's production company : ");
//                                Scanner scn7 = new Scanner(System.in);
//                                String pro = scn7.nextLine();
//                                List<Movies> List7 = new ArrayList();
//                                List7=object1.search_by_production_company(pro);
//                                if(List7.size()==0)
//                                {
//                                    System.out.println("No such movie with this production company");
//                                }
//                                else{
//                                    for(Movies mov2 : List7)
//                                    {
//                                        mov2.printMovei();
//                                    }
//                                }
//                                main_menu();
//                                break;
//                            case 5:
//                                System.out.println("Enter the movie's highest running time : ");
//                                Scanner scn8 = new Scanner(System.in);
//                                int time1 = scn8.nextInt();
//                                System.out.println("Enter the movie's lowest running time : ");
//                                Scanner scn9 = new Scanner(System.in);
//                                int time2 = scn9.nextInt();
//                                List<Movies> List8 = new ArrayList();
//                                List8=object1.search_by_running_time(time1, time2);
//                                if(List8.size()==0)
//                                {
//                                    System.out.println("No such movie with this running time range");
//                                }
//                                else{
//                                    for(Movies mov2 : List8)
//                                    {
//                                        mov2.printMovei();
//                                    }
//                                }
//                                main_menu();
//                                break;
//                            case 6:
//                                Collections.sort(object2.moviesList2, new sortProfit());
//                                for (int i = 0; i<10; i++)
//                                {
//                                    Movies mov1 = object2.moviesList2.get(i);
//                                    object2.printinfo(mov1);
//                                }
//                                main_menu();
//                                break;
//                            case 7: main_menu();
//                                break;
//                            default:
//                                System.out.println("Error Chossing!!...Again choose your option");
//                        }
//                    }while (search_selection >7);
//                    break;
//                case 2://search movei by production company
//                    int search;
//                    do {
//                        search = production_searching_menu();
//                        switch (search){
//                            case 1:
//                                System.out.println("Enter the production Company Name: ");
//                                List<Movies> List1 = new ArrayList();
//                                Scanner scn1 = new Scanner(System.in);
//                                String name1 = scn1.nextLine();
//                                List1 = object3.most_recent_movies(object2, name1);
//                                if(List1.size()==0)
//                                {
//                                    System.out.println("No such production company with this name");
//                                }
//                                else{
//                                    for(Movies mov : List1)
//                                    {
//                                        mov.printMovei();
//                                    }
//                                }
//                                main_menu();
//                                break;
//                            case 2:
//                                System.out.println("Enter the production Company Name: ");
//                                List<Movies> List2 = new ArrayList();
//                                Scanner scn2 = new Scanner(System.in);
//                                String name2 = scn2.nextLine();
//                                List2=object3.Movies_with_the_Maximum_Revenue(object2, name2);
//                                if(List2.size()==0)
//                                {
//                                    System.out.println("No such production company with this name");
//                                }
//                                else{
//                                    for(Movies mov : List2)
//                                    {
//                                        mov.printMovei();
//                                    }
//                                }
//                                main_menu();
//                                break;
//                            case 3:
//                                long profit;
//                                System.out.println("Enter the production Company Name: ");
//                                Scanner scn3 = new Scanner(System.in);
//                                String name3 = scn3.nextLine();
//                                profit=object3.Total_Profit(object2, name3);
//                                if(profit == 0) System.out.println("No such production company with this name");
//                                else System.out.println("The Total Profit of This Production Company is: "+ profit);
//                                main_menu();
//                                break;
//                            case 4:
//                                object3.list_of_moveis(object2);
//                                main_menu();
//                                break;
//                            case 5:
//                                main_menu();
//                                break;
//                            default:
//                                System.out.println("Error Chossing!!...Again choose your option");
//                        }
//                    }while (search>5);
//                    break;
//                case 3: object1.add_movies();
//                    main_menu();
//                    break;
//                case 4:
//                    break;
//                default:
//                    System.out.println("ERROR CHOSSING !!...Please choose your option again");
//                    System.out.println("Enter your option: ");
//            }
//        }while (user_selected > 4);
//
//    }
    public static int movei_searching_menu()
    {
        System.out.println("Movie Searching Options:");
        System.out.println("1) By Movie Title");
        System.out.println("2) By Release Year");
        System.out.println("3) By Genre");
        System.out.println("4) By Production Company");
        System.out.println("5) By Running Time");
        System.out.println("6) Top 10 Movies");
        System.out.println("7) Back to Main Menu");
        System.out.println("Enter your option(1-7): ");
        Scanner scn = new Scanner(System.in);
        int selection = scn.nextInt();
        return selection;

    }
    public static int production_searching_menu()
    {
        System.out.println("Production Company Searching Options:");
        System.out.println("1) Most Recent Movies");
        System.out.println("2) Movies with the Maximum Revenue");
        System.out.println("3) Total Profit");
        System.out.println("4) List of Production Companies and the Count of their Produced Movies");
        System.out.println("5) Back to Main Menu");
        System.out.println("Enter your production searching option(1-5): ");
        Scanner scn = new Scanner(System.in);
        int selection = scn.nextInt();
        return selection;
    }

}
