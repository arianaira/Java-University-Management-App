package Controller;

import Model.Common;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class StudentController
{
    private String username;

    public void setUsername(String username)
    {
        this.username = username;
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
