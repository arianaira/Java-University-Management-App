package Controller;
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
import java.util.Date;
import java.util.ResourceBundle;

public class newSemesterController implements Initializable
{
    Date date = new Date();

    @FXML
    private Label createdDate;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        createdDate.setText("New Semester Created in "+date.toString());
    }

    @FXML
    private void quit(javafx.event.ActionEvent event)
    {
        Common.quit();
    }

    @FXML
    private void editInfo(javafx.event.ActionEvent event)
    {

    }

    @FXML
    private void newCourse(ActionEvent event) throws IOException
    {
        Parent newCourse = FXMLLoader.load(getClass().getResource("/View/newCourse.fxml"));
        Stage newCourseStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene newCourseScene = new Scene(newCourse);
        newCourseStage.setScene(newCourseScene);
        newCourseStage.show();
    }

    @FXML
    private void logOut(ActionEvent event) throws IOException
    {
        Common.logOut(event);
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
