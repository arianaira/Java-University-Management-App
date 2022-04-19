package Controller;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class newCourseController implements Initializable
{
    @FXML
    private Label msg;

    @FXML
    private ComboBox<String> chooseProfessor;

    @FXML
    private ComboBox<String> faculties;

    @FXML
    private TextField courseName;

    @FXML
    private TextField cu;

    @FXML
    void create(ActionEvent event)
    {
        if (CentralManagement.newSemesterExists)
        {
            Course currentC = new Course();
            currentC.setName(courseName.getText());
            currentC.setUnits(Integer.parseInt(cu.getText()));
            currentC.setProfessor(chooseProfessor.getValue());
            for (Faculty faculty : CentralManagement.faculties)
            {
                faculty.courses.add(currentC);
                break;
            }
            msg.setText("Course Successfully Created");
        }
    }

    @FXML
    void facultySelected(ActionEvent event)
    {
        for (Faculty faculty : CentralManagement.faculties)
        {
            if (faculty.getFacultyName().equals(faculties.getValue()))
            {
                for (Professor professor : faculty.professors)
                {
                    chooseProfessor.getItems().add(professor.getName()+" "+professor.getLastName());
                }
            }
            break;
        }
    }

    @FXML
    void editInfo(ActionEvent event)
    {

    }

    @FXML
    void logOut(ActionEvent event) throws IOException
    {
        Common.logOut(event);
    }

    @FXML
    void quit(ActionEvent event)
    {
        Common.quit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        if (!CentralManagement.newSemesterExists)
        {
            msg.setText("No New Semester Is Defined");
        }
        for (Faculty faculty : CentralManagement.faculties)
        {
            faculties.getItems().add(faculty.getFacultyName());
        }
    }

    @FXML
    private void back(ActionEvent event) throws IOException
    {
        Parent central = FXMLLoader.load(getClass().getResource("/View/CentralManagement.fxml"));
        Stage centralStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene centralScene = new Scene(central);
        centralStage.setScene(centralScene);
        centralStage.show();
    }
}
