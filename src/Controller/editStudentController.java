package Controller;

import Model.CentralManagement;
import Model.Common;
import Model.Faculty;
import Model.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class editStudentController implements Initializable
{
    @FXML
    private TextField password;

    @FXML
    private Label msg;

    @FXML
    private TextField username;

    @FXML
    private TextField name;

    @FXML
    private TextField lastname;

    @FXML
    private TextField entryYear;

    @FXML
    private TextField major;

    @FXML
    private ComboBox<String> faculties;

    @FXML
    private void home(ActionEvent event) throws IOException
    {
        Common.logOut(event);
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
        else if (major.getText().trim().equals(""))
        {
            msg.setText("major not entered");
        }
        else if (entryYear.getText().trim().equals(""))
        {
            msg.setText("entryYear not entered");
        }
        else
        {
            for (Faculty faculty : CentralManagement.faculties)
            {
                if (faculty.getFacultyName().equals(faculties.getValue()))
                {
                    faculty.students.remove(CentralManagement.currentStudent);
                    Main.usernamePassword.remove(CentralManagement.currentStudent.getUsername(), CentralManagement.currentStudent.getPassword());
                    Main.students.remove(CentralManagement.currentStudent, CentralManagement.currentStudent.getUsername());

                    CentralManagement.currentStudent.setName(name.getText());
                    CentralManagement.currentStudent.setLastName(lastname.getText());
                    CentralManagement.currentStudent.setStudentID();
                    CentralManagement.currentStudent.setMajor(major.getText());
                    CentralManagement.currentStudent.setEntryYear(Integer.parseInt(entryYear.getText()));
                    CentralManagement.currentStudent.setFaculty(faculties.getValue());
                    CentralManagement.currentStudent.setPassword(password.getText());
                    CentralManagement.currentStudent.setUsername(username.getText());

                    faculty.students.add(CentralManagement.currentStudent);
                    Main.usernamePassword.put(CentralManagement.currentStudent.getUsername(), CentralManagement.currentStudent.getPassword());
                    Main.students.put(CentralManagement.currentStudent, CentralManagement.currentStudent.getUsername());
                    CentralManagement.currentStudent.login(username.getText(), password.getText(), event);
                }
            }
        }
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
