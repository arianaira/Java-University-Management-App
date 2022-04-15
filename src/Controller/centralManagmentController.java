package Controller;

import Model.Semester;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import Model.Common;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class centralManagmentController
{
    @FXML
    private void newSemester(javafx.event.ActionEvent event)
    {
        Semester newSemester = new Semester();
    }

    @FXML
    private void newCourse(javafx.event.ActionEvent event)
    {

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
    private void editInfo(ActionEvent event)
    {
    }

    @FXML
    private void quit(ActionEvent event)
    {

    }

    @FXML
    private void logOut(ActionEvent event) throws IOException
    {
        Common.logOut(event);
    }
}