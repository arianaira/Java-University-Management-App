package Controller;

import Model.CentralManagement;
import Model.Common;
import Model.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class registerController implements Initializable
{
    int units = 0;

    @FXML
    private Label unitsTaken;

    @FXML
    private Label msg;


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
        TableColumn units = new TableColumn("Units");

        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        professor.setCellValueFactory(new PropertyValueFactory<>("professor"));
        units.setCellValueFactory(new PropertyValueFactory<>("units"));

        ObservableList<Course> availableCourses = FXCollections.observableArrayList(CentralManagement.semesters.get(CentralManagement.semesters.size() - 1).courses);
        courses.setItems(availableCourses);
        courses.getColumns().addAll(name, professor, units);
    }

    @FXML
    private void editInfo(javafx.event.ActionEvent event) throws IOException
    {
        CentralManagement.currentStudent.editInfo(event);
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
        Course row = courses.getSelectionModel().getSelectedItem();
        if (CentralManagement.currentStudent.registeredCourses.contains(row))
        {
            CentralManagement.currentStudent.registeredCourses.remove(row);
            units -= Integer.parseInt(row.getUnits());
        }
        else
        {
            CentralManagement.currentStudent.register(row, CentralManagement.currentStudent);
            units += Integer.parseInt(row.getUnits());
        }
        unitsTaken.setText("Units : " + units);
    }

    @FXML
    private void done(ActionEvent event) throws IOException
    {
        if (units < 12)
        {
            msg.setText("Minimum Allowed Units Is 12");
        }
        else if (units > 20)
        {
            msg.setText(("Maximum Allowed Units Is 20"));
        }
        else
        {
            CentralManagement.currentStudent.registerStatus = true;

            back(event);
        }
    }
}
