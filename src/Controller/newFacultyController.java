package Controller;

import Model.CentralManagment;
import Model.Common;
import Model.Faculty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

import static Model.CentralManagment.faculties;

public class newFacultyController
{
    @FXML
    private TextField newFaculty;

    @FXML
    private Label repetitious;

    @FXML
    void create(ActionEvent event)
    {
        Boolean allowed = true;
        if (newFaculty.getText().equals(""))
        {
            repetitious.setText("Nothing Entered");
        }
        else
        {
            for (Faculty faculty : faculties)
            {
                if (faculty.getFacultyName().equals(newFaculty.getText()))
                {
                    repetitious.setText("Faculty Already Exists");
                    allowed = false;
                    break;
                }
            }
            if (allowed)
            {
                CentralManagment.makeFaculty(newFaculty.getText());
                repetitious.setText("Faculty "+newFaculty.getText()+" Successfully Created");
            }
        }
    }

    @FXML
    void back(ActionEvent event) throws IOException
    {
        Parent central = FXMLLoader.load(getClass().getResource("/View/CentralManager.fxml"));
        Stage centralStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene centralScene = new Scene(central);
        centralStage.setScene(centralScene);
        centralStage.show();
    }

    @FXML
    void quit(javafx.event.ActionEvent event)
    {
        Common.quit();
    }

    @FXML
    void editInfo(javafx.event.ActionEvent event)
    {

    }

    @FXML
    void logOut(javafx.event.ActionEvent event) throws IOException
    {
        Common.logOut(event);
    }
}
