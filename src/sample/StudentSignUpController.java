package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class StudentSignUpController
{
    @FXML
    private TextField name;

    @FXML
    private TextField lastname;

    @FXML
    private TextField studentID;

    @FXML
    private TextField faculty;

    @FXML
    private TextField major;

    @FXML
    private TextField entryYear;

    @FXML
    private TextField password;

    @FXML
    private TextField username;


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
        else if (studentID.getText().trim().equals(""))
        {
            msg.setText("student ID not entered");
        }
        else if (faculty.getText().trim().equals(""))
        {
            msg.setText("faculty not entered");
        }
        else if (major.getText().trim().equals(""))
        {
            msg.setText("major not entered");
        }
        else if (entryYear.getText().trim().equals(""))
        {
            msg.setText("entryYear not entered");
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
            current.setFaculty(faculty.getText());
            current.setStudentID(studentID.getText());
            current.setMajor(major.getText());
            current.setEntryYear(Integer.parseInt(entryYear.getText()));
            current.singUp(current, username.getText(), password.getText(), event);
        }
    }

    @FXML
    private void quit(ActionEvent event) throws IOException
    {
        Common.quit(event);
    }
}
