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

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class registerController implements Initializable
{
    @FXML
    private TableView<Course> courses;

    @FXML
    private javafx.scene.control.TableColumn<Course, String> name;

    @FXML
    private TableColumn<Course, String> professor;

    @FXML
    void logOut(javafx.event.ActionEvent event) throws IOException
    {
        Common.logOut(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        TableColumn name = new TableColumn("Available Courses");
        TableColumn professor = new TableColumn("Professor");

        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        professor.setCellValueFactory(new PropertyValueFactory<>("professor"));
        ObservableList<Course> availableCourses = FXCollections.observableArrayList(CentralManagement.semesters.get(CentralManagement.semesters.size() - 1).courses);
        courses.setItems(availableCourses);
        courses.getColumns().addAll(name, professor);
    }

    @FXML
    private void editInfo(javafx.event.ActionEvent event)
    {

    }

    @FXML
    private void quit(javafx.event.ActionEvent event)
    {
        Common.quit();
    }

    @FXML
    private void back(ActionEvent event) throws IOException
    {
        CentralManagement.currentStudent.login(CentralManagement.currentStudent.getUsername(), CentralManagement.currentStudent.getPassword(), event);
    }

    @FXML
    private void courseSelection(javafx.scene.input.MouseEvent mouseEvent)
    {
        CentralManagement.currentStudent.registerStatus = true;
        Course row = courses.getSelectionModel().getSelectedItem();
        CentralManagement.currentStudent.register(row);
    }
}
