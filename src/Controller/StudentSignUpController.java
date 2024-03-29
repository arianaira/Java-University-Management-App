package Controller;

import Model.CentralManagement;
import Model.Common;
import Model.Faculty;
import Model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class StudentSignUpController implements Initializable
{
    @FXML
    private TextField name;

    @FXML
    private TextField lastname;

    @FXML
    private TextField major;

    @FXML
    private TextField entryYear;

    @FXML
    private TextField password;

    @FXML
    private TextField username;

    @FXML
    ComboBox<String> faculties;


    @FXML
    public Label msg;

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
        else if (major.getText().trim().equals(""))
        {
            msg.setText("major not entered");
        }
        else if (!Pattern.compile("[0-9]{4}").matcher(entryYear.getText()).matches())
        {
            msg.setText("entryYear not valid");
        }
        else if (!Pattern.compile(".{6,}").matcher(password.getText()).matches())
        {
            msg.setText("invalid password length");
        }
        else if (Common.signUpAllowed(username.getText()))
        {
            msg.setText("username already taken");
        }
        else
        {
            Student current = new Student();
            current.setName(name.getText());
            current.setLastName(lastname.getText());
            current.setStudentID();
            current.setMajor(major.getText());
            current.setEntryYear(Integer.parseInt(entryYear.getText()));
            current.setFaculty(faculties.getValue());
            current.setPassword(password.getText());
            current.setUsername(username.getText());
            for (Faculty faculty : CentralManagement.faculties)
            {
                if (faculty.getFacultyName().equals(faculties.getValue()))
                {
                    faculty.students.add(current);
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
