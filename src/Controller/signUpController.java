package Controller;

import Model.Common;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;

public class signUpController
{

    @FXML
    private RadioButton student;

    @FXML
    private RadioButton professor;


    @FXML
    void signUpRoled(ActionEvent event) throws IOException
    {
        if (student.isSelected())
        {
            Parent studentSignUp = FXMLLoader.load(getClass().getResource("/View/studentSignUp.fxml"));
            Stage studentSignUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene studentSignUpScene = new Scene(studentSignUp);
            studentSignUpStage.setScene(studentSignUpScene);
            studentSignUpStage.show();
        }
        else if (professor.isSelected())
        {
            Parent professorSignUp = FXMLLoader.load(getClass().getResource("/View/professorSignUp.fxml"));
            Stage professorSignUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene professorSignUpScene = new Scene(professorSignUp);
            professorSignUpStage.setScene(professorSignUpScene);
            professorSignUpStage.show();
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

}
