package Controller;

import Model.CentralManagement;
import Model.Common;
import Model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class studentsController implements Initializable
{
    @FXML
    private TableView<Student> students;

    public void quit(ActionEvent actionEvent)
    {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        students.getItems().clear();
        TableColumn firstName = new TableColumn("First Name");
        TableColumn lastName = new TableColumn("Last Name");

        firstName.setCellValueFactory(new PropertyValueFactory<>("name"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        ObservableList<Student> availableStudents = FXCollections.observableArrayList(CentralManagement.currentCourse.registeredStudents);
        students.setItems(availableStudents);
        students.getColumns().addAll(firstName, lastName);
    }

    @FXML
    private void editInfo(ActionEvent event) throws IOException
    {
        CentralManagement.currentProfessor.editInfo(event);
    }

    @FXML
    private void LogOut(ActionEvent event) throws IOException
    {
        Common.logOut(event);
    }

    @FXML
    private void back(ActionEvent event) throws IOException
    {
        CentralManagement.currentProfessor.login(CentralManagement.currentProfessor.getUsername(), CentralManagement.currentProfessor.getPassword(), event);
    }

    @FXML
    private void giveScore(MouseEvent mouseEvent) throws IOException
    {
        Student row = students.getSelectionModel().getSelectedItem();
        if (row != null)
        {
            CentralManagement.currentStudent = row;

            Parent score = FXMLLoader.load(getClass().getResource("/View/score.fxml"));
            Stage scoreStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            Scene scoreScene = new Scene(score);
            scoreStage.setScene(scoreScene);
            scoreStage.show();
        }
    }
}
