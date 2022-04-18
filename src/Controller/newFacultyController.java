package Controller;

import Model.CentralManagement;
import Model.Common;
import Model.Faculty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

import static Model.CentralManagement.faculties;

public class newFacultyController
{
    @FXML
    private TextField newF;

    @FXML
    private Label repetitious;

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

    @FXML
    private void create(javafx.event.ActionEvent event)
    {
        Boolean allowed = true;
        if (newF.getText().trim().equals(""))
        {
            repetitious.setText("Nothing Entered");
        }
        else
        {
            for (Faculty faculty : faculties)
            {
                if (faculty.getFacultyName().equals(newF.getText()))
                {
                    repetitious.setText("Faculty Already Exists");
                    allowed = false;
                    break;
                }
            }
            if (allowed)
            {
                CentralManagement.makeFaculty(newF.getText());
                repetitious.setText("Faculty "+newF.getText()+" Successfully Created");
            }
        }
    }

    @FXML
    private void back(javafx.event.ActionEvent event) throws IOException
    {
        Parent central = FXMLLoader.load(getClass().getResource("/View/CentralManagement.fxml"));
        Stage centralStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene centralScene = new Scene(central);
        centralStage.setScene(centralScene);
        centralStage.show();
    }
}
