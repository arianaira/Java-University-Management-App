package Controller;

import Model.CentralManagement;
import Model.Common;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentController
{
    @FXML
    private Label msg;

    @FXML
    void register(ActionEvent event) throws IOException
    {
        if(!CentralManagement.currentStudent.registerStatus)
        {
            Parent register = FXMLLoader.load(getClass().getResource("/View/register.fxml"));
            Stage registerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene registerScene = new Scene(register);
            registerStage.setScene(registerScene);
            registerStage.show();
        }
        else
        {
            msg.setText("You Have Already Registered");
        }
    }

    @FXML
    void schedule(ActionEvent event) throws IOException
    {
        Parent schedule = FXMLLoader.load(getClass().getResource("/View/schedule.fxml"));
        Stage scheduleStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scheduleScene = new Scene(schedule);
        scheduleStage.setScene(scheduleScene);
        scheduleStage.show();
    }

    @FXML
    void scores(ActionEvent event)
    {

    }

    @FXML
    private void logOut(ActionEvent event) throws IOException
    {
        Common.logOut(event);
    }

    @FXML
    private void editInfo(ActionEvent event)
    {

    }

    @FXML
    private void quit(ActionEvent event)
    {
        Common.quit();
    }
}
