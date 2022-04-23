package Controller;

import Model.CentralManagement;
import Model.Common;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfessorController implements Initializable
{
    @FXML
    private Label user;

    @FXML
    private void courses(ActionEvent event) throws IOException
    {
        Parent courses = FXMLLoader.load(getClass().getResource("/View/courses.fxml"));
        Stage coursesStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene coursesScene = new Scene(courses);
        coursesStage.setScene(coursesScene);
        coursesStage.show();
    }

    @FXML
    private void editInfo(ActionEvent event) throws IOException
    {
        CentralManagement.currentProfessor.editInfo(event);
    }

    @FXML
    private void quit(ActionEvent event)
    {
        Common.quit();
    }

    @FXML
    private void LogOut(ActionEvent event) throws IOException
    {
        Common.logOut(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        user.setText("User : " + CentralManagement.currentProfessor.getUsername());
    }
}
