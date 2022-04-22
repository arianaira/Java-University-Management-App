package Controller;

import Model.CentralManagement;
import Model.Common;
import Model.Score;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class scoresController implements Initializable
{
    @FXML
    private TableView<Score> scores;

    @FXML
    public void quit(ActionEvent event)
    {
        Common.quit();
    }

    @FXML
    public void editInfo(ActionEvent event) throws IOException
    {
        CentralManagement.currentStudent.editInfo(event);
    }

    @FXML
    public void logOut(ActionEvent event) throws IOException
    {
        Common.logOut(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        scores.getItems().clear();

        TableColumn course = new TableColumn("Course");
        TableColumn score = new TableColumn("Score");

        course.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        score.setCellValueFactory(new PropertyValueFactory<>("score"));

        ObservableList<Score> stuScores = FXCollections.observableArrayList(CentralManagement.currentStudent.scores);
        scores.setItems(stuScores);
        scores.getColumns().addAll(course, score);
    }
}
