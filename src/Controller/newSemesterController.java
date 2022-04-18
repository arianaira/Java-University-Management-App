package Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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

    }

    @FXML
    private void editInfo(javafx.event.ActionEvent event)
    {

    }

    @FXML
    private void newCourse(ActionEvent event)
    {

    }

    @FXML
    private void logOut(ActionEvent event)
    {

    }
}
