package Controller;

import Model.Common;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class ProfessorController
{
    private String username;

    public void setUsername(String username)
    {
        this.username = username;
    }

    @FXML
    private void courses(ActionEvent event)
    {

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
    private void LogOut(ActionEvent event) throws IOException
    {
        Common.logOut(event);
    }
}
