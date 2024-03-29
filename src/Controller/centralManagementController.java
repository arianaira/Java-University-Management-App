package Controller;

import Model.CentralManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import Model.Common;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class centralManagementController implements Initializable
{
    @FXML
    private Label user;

    @FXML
    private void newSemester(javafx.event.ActionEvent event) throws IOException
    {
        CentralManagement.newSemester();
        Parent newSem = FXMLLoader.load(getClass().getResource("/View/newSemester.fxml"));
        Stage newSemStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene newSemScene = new Scene(newSem);
        newSemStage.setScene(newSemScene);
        newSemStage.show();
    }

    @FXML
    private void newCourse(javafx.event.ActionEvent event) throws IOException
    {
        Parent newCourse = FXMLLoader.load(getClass().getResource("/View/newCourse.fxml"));
        Stage newCourseStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene newCourseScene = new Scene(newCourse);
        newCourseStage.setScene(newCourseScene);
        newCourseStage.show();
    }

    @FXML
    private void makeFaculty(javafx.event.ActionEvent event) throws IOException
    {
        Parent newFac = FXMLLoader.load(getClass().getResource("/View/newFaculty.fxml"));
        Stage newFacStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene newFacScene = new Scene(newFac);
        newFacStage.setScene(newFacScene);
        newFacStage.show();
    }

    @FXML
    private void editInfo(ActionEvent event) throws IOException
    {
        CentralManagement.editInfo(event);
    }

    @FXML
    private void quit(ActionEvent event)
    {
        Common.quit();
    }

    @FXML
    private void logOut(ActionEvent event) throws IOException
    {
        Common.logOut(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        user.setText("User : Central Management");
    }
}