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

public class editProfessorController implements Initializable
{
    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private Label msg;

    @FXML
    private TextField name;

    @FXML
    private TextField lastname;

    @FXML
    private TextField group;

    @FXML
    private ComboBox<String> faculties;

    @FXML
    private void quit(ActionEvent event)
    {
        Common.quit();
    }

    @FXML
    private void submit(ActionEvent event) throws IOException
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
        else
        {
            for (Faculty faculty : CentralManagement.faculties)
            {
                if (faculty.getFacultyName().equals(faculties.getValue()))
                {
                    faculty.professors.remove(CentralManagement.currentProfessor);
                    Main.usernamePassword.remove(CentralManagement.currentProfessor.getUsername(), CentralManagement.currentProfessor.getPassword());
                    Main.professors.remove(CentralManagement.currentProfessor, CentralManagement.currentProfessor.getUsername());

                    CentralManagement.currentProfessor.setName(name.getText());
                    CentralManagement.currentProfessor.setLastName(lastname.getText());
                    CentralManagement.currentProfessor.setGroup(group.getText());
                    CentralManagement.currentProfessor.setFaculty(faculties.getValue());
                    CentralManagement.currentProfessor.setPassword(password.getText());

                    faculty.professors.add(CentralManagement.currentProfessor);
                    Main.usernamePassword.put(CentralManagement.currentProfessor.getUsername(), CentralManagement.currentProfessor.getPassword());
                    Main.professors.put(CentralManagement.currentProfessor, CentralManagement.currentProfessor.getUsername());
                    CentralManagement.currentProfessor.login(username.getText(), password.getText(), event);
                    break;
                }
            }
        }
    }

    @FXML
    private void home(ActionEvent event) throws IOException
    {
        Common.logOut(event);
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
