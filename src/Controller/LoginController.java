package Controller;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static Model.Main.professors;
import static Model.Main.students;

public class LoginController
{
    @FXML
    private Label msg;

    @FXML
    private TextField username;

    @FXML
    private TextField password;
    

    @FXML
    private void login(ActionEvent event) throws IOException
    {
        if (Common.usernameExistence(username.getText()))
        {
            if (Common.passwordCorrect(username.getText(), password.getText()))
            {
                if (students.containsValue(username.getText()))
                {
                    for (Faculty faculty : CentralManagement.faculties)
                    {
                        for (Student student : faculty.students)
                        {
                            if (student.getUsername().equals(username.getText()))
                            {
                                CentralManagement.currentStudent = student;
                            }
                        }
                    }
                    Student current = new Student();
                    current.login(username.getText(), password.getText(), event);
                }
                else if (professors.containsValue(username.getText()))
                {
                    for (Faculty faculty : CentralManagement.faculties)
                    {
                        for (Professor professor : faculty.professors)
                        {
                            if (professor.getUsername().equals(username.getText()))
                            {
                                CentralManagement.currentProfessor = professor;
                            }
                        }
                    }
                    Professor current = new Professor();
                    current.login(username.getText(), password.getText(), event);
                }
                else
                {
                    CentralManagement.login(username.getText(), password.getText(), event);
                }

            }
            else
            {
                msg.setText("invalid username or password");
            }
        }
        else
        {
            msg.setText("invalid username or password");
        }
    }

    @FXML
    private void signUp(ActionEvent event) throws IOException
    {
        Parent signUp = FXMLLoader.load(getClass().getResource("/View/signup.fxml"));
        Stage signupStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene signupScene = new Scene(signUp);
        signupStage.setScene(signupScene);
        signupStage.show();
    }

    @FXML
    private void quit()
    {
        Common.quit();
    }
}
