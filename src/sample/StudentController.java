package sample;

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
    private void quit(ActionEvent event) throws IOException
    {
        Common.quit(event);
    }

    @FXML
    private void editInfo(ActionEvent event)
    {

    }
}
