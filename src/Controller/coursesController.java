package Controller;

import Model.CentralManagement;
import Model.Common;
import Model.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class coursesController implements Initializable
{
    @FXML
    private TableView<Course> courses;

    @FXML
    private void quit(javafx.event.ActionEvent event)
    {
        Common.quit();
    }

    @FXML
    private void editInfo(javafx.event.ActionEvent event) throws IOException
    {
        CentralManagement.currentProfessor.editInfo(event);
    }

    @FXML
    private void LogOut(javafx.event.ActionEvent event) throws IOException
    {
        Common.logOut(event);
    }

    @FXML
    private void back(javafx.event.ActionEvent event) throws IOException
    {
        CentralManagement.currentProfessor.login(CentralManagement.currentProfessor.getUsername(), CentralManagement.currentProfessor.getPassword(), event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        courses.getItems().clear();
        TableColumn name = new TableColumn("Available Courses");
        TableColumn professor = new TableColumn("Professor");
        TableColumn units = new TableColumn("Units");

        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        professor.setCellValueFactory(new PropertyValueFactory<>("professor"));
        units.setCellValueFactory(new PropertyValueFactory<>("units"));

        ObservableList<Course> availableCourses = FXCollections.observableArrayList(CentralManagement.currentProfessor.courses);
        courses.setItems(availableCourses);
        courses.getColumns().addAll(name, professor, units);
    }

    @FXML
    private void courseSelection(MouseEvent mouseEvent) throws IOException
    {
        CentralManagement.currentCourse = courses.getSelectionModel().getSelectedItem();

        Parent students = FXMLLoader.load(getClass().getResource("/View/students.fxml"));
        Stage studentsStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        Scene studentsScene = new Scene(students);
        studentsStage.setScene(studentsScene);
        studentsStage.show();
    }
}
