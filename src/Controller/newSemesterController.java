package Controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class newSemesterController implements Initializable
{
    Date date = new Date();

    @FXML
    private Label createdDate;

    @FXML
    void editInfo(ActionEvent event)
    {

    }

    @FXML
    void logOut(ActionEvent event)
    {

    }

    @FXML
    void newCourse(ActionEvent event)
    {

    }

    @FXML
    void quit(ActionEvent event)
    {

    }


    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        createdDate.setText("New Semester Created in "+date.toString());
    }
}
