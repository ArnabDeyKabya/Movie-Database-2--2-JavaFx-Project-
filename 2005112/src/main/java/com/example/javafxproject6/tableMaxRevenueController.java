package com.example.javafxproject6;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class tableMaxRevenueController implements Initializable {
    public TextField search;
    @FXML
    private TableView<Movies> table_Title;
    @FXML
    private TableColumn<Movies, String> Title;
    @FXML
    private TableColumn<Movies, Integer> releaseYear;
    @FXML
    private TableColumn<Movies, String> genere1;
    @FXML
    private TableColumn<Movies, String> genere2;
    @FXML
    private TableColumn<Movies, String> genere3;
    @FXML
    private TableColumn<Movies, Integer> runTime;
    @FXML
    private TableColumn<Movies, String> productionCompany;
    @FXML
    private TableColumn<Movies, Long> MovieBudget;
    @FXML
    private TableColumn<Movies, Long> Movierevenue;
    ObservableList<Movies> list1;
    List<Movies> List4 = new ArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List4 = TestMain.object1.Movies_with_max_revenue_forfx();
        list1 = FXCollections.observableArrayList();
        list1.addAll(List4);
        FilteredList<Movies> filteredList = new FilteredList<>(list1, b-> true);
        Title.setCellValueFactory(new PropertyValueFactory<Movies, String>("title"));
        releaseYear.setCellValueFactory(new PropertyValueFactory<Movies, Integer>("release_year"));
        genere1.setCellValueFactory(new PropertyValueFactory<Movies, String>("genre1"));
        genere2.setCellValueFactory(new PropertyValueFactory<Movies, String>("genre2"));
        genere3.setCellValueFactory(new PropertyValueFactory<Movies, String>("genre3"));
        runTime.setCellValueFactory(new PropertyValueFactory<Movies, Integer>("running_time"));
        productionCompany.setCellValueFactory(new PropertyValueFactory<Movies, String>("production_company"));
        MovieBudget.setCellValueFactory(new PropertyValueFactory<Movies, Long>("budget"));
        Movierevenue.setCellValueFactory(new PropertyValueFactory<Movies, Long>("revenue"));
        //table_Title.setItems(list1);
        search.textProperty().addListener((observable, oValue, nValue) ->{
            filteredList.setPredicate(Movies ->{
                if(nValue == null || nValue.isEmpty()) return  true;
                String lowerCaseFilter = nValue.toLowerCase();
                if(Movies.getTitle().toLowerCase().indexOf(lowerCaseFilter) != -1) return true;
                else if(Movies.getProduction_company().toLowerCase().indexOf(lowerCaseFilter) != -1) return  true;
                else if(Movies.getGenre1().toLowerCase().indexOf(lowerCaseFilter) != -1) return  true;
                else if(Movies.getGenre2().toLowerCase().indexOf(lowerCaseFilter) != -1) return  true;
                else if(Movies.getGenre3().toLowerCase().indexOf(lowerCaseFilter) != -1) return  true;
                else  return false;
            });
        });
        SortedList<Movies> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(table_Title.comparatorProperty());
        table_Title.setItems(sortedList);

    }

    public void onBackToLoginPageClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TestMain.class.getResource("productionSearching.fxml"));
        javafx.scene.Scene scene = new javafx.scene.Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
