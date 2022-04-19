package Controller;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfessorSignUpController implements Initializable
{
    @FXML
    private TextField name;

    @FXML
    private TextField lastname;

    @FXML
    private TextField group;


    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    ComboBox faculties;

    @FXML
    private Label msg;

    @FXML
    private void signUp(javafx.event.ActionEvent event) throws IOException
    {
        if (name.getText().trim().equals(""))
        {
            msg.setText("name not entered");
        }
        else if (lastname.getText().trim().equals(""))
        {
            msg.setText(("last name not entered"));
        }
        else if (group.getText().trim().equals(""))
        {
            msg.setText(("group not entered"));
        }
        else if (Common.signUpAllowed(username.getText()))
        {
            msg.setText("username already taken");
        }
        else
        {
            Professor current = new Professor();
            current.setName(name.getText());
            current.setLastName(lastname.getText());
            current.setGroup(group.getText());
            current.setFaculty(faculties.getValue().toString());
            for (Faculty faculty : CentralManagement.faculties)
            {
                if (faculty.getFacultyName().equals(faculties.getValue()))
                {
                    faculty.professors.add(current);
                }
            }
            current.singUp(current, username.getText(), password.getText(), event);
        }
    }

    @FXML
    void home(ActionEvent event) throws IOException
    {
        Common.logOut(event);
    }

    @FXML
    private void quit(ActionEvent event)
    {
        Common.quit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        for (Faculty faculty : CentralManagement.faculties)
        {
            faculties.getItems().add(faculty.getFacultyName());
        }
    }
}
