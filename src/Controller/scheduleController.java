package Controller;

import Model.CentralManagement;
import Model.Common;
import Model.Course;
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

public class scheduleController implements Initializable
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
        CentralManagement.currentStudent.editInfo(event);
    }

    @FXML
    private void logOut(javafx.event.ActionEvent event) throws IOException
    {
        Common.logOut(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        TableColumn name = new TableColumn("Available Courses");
        TableColumn professor = new TableColumn("Professor");
        TableColumn units = new TableColumn("Units");

        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        professor.setCellValueFactory(new PropertyValueFactory<>("professor"));
        units.setCellValueFactory(new PropertyValueFactory<>("units"));

        ObservableList<Course> availableCourses = FXCollections.observableArrayList(CentralManagement.currentStudent.registeredCourses);
        courses.setItems(availableCourses);
        courses.getColumns().addAll(name, professor, units);
    }

    @FXML
    private void back(ActionEvent event) throws IOException
    {
        CentralManagement.currentStudent.login(CentralManagement.currentStudent.getUsername(), CentralManagement.currentStudent.getPassword(), event);
    }
}
