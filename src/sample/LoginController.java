package sample;

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

import static sample.Main.students;

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
                    Student current = new Student();
                    current.login(username.getText(), password.getText(), event);
                }
                else
                {
                    Professor current = new Professor();
                    current.login(username.getText(), password.getText(), event);
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
        Parent signUp = FXMLLoader.load(getClass().getResource("signup.fxml"));
        Stage signupStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene signupScene = new Scene(signUp);
        signupStage.setScene(signupScene);
        signupStage.show();
    }

    @FXML
    private void quit()
    {
        System.exit(0);
    }
}
