package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;

import java.io.IOException;

public class ProfessorSignUpController
{
    @FXML
    private TextField group;

    @FXML
    private TextField name;

    @FXML
    private TextField lastname;

    @FXML
    private TextField faculty;

    @FXML
    private void signUp(javafx.event.ActionEvent event)
    {

    }

    @FXML
    private void quit(ActionEvent event) throws IOException
    {
        Common.quit(event);
    }
}
