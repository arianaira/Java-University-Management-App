package Controller;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class scoreController
{
    @FXML
    private TextField score;

    @FXML
    private Label msg;

    @FXML
    private void editInfo(ActionEvent event) throws IOException
    {
        CentralManagement.currentProfessor.editInfo(event);
    }

    @FXML
    private void LogOut(ActionEvent event) throws IOException
    {
        Common.logOut(event);
    }

    @FXML
    private void quit(ActionEvent event)
    {
        Common.quit();
    }

    @FXML
    private void done(ActionEvent event) throws IOException
    {
        if (score.getText().trim().equals(""))
        {
            msg.setText("score not entered");
        }
        else if (Integer.parseInt(score.getText()) > 20 | Integer.parseInt(score.getText()) < 0)
        {
            msg.setText("invalid range of score");
        }
        else
        {
            Score newScore = new Score(score.getText(), CentralManagement.currentCourse.getName());
            for (Student s : CentralManagement.currentCourse.registeredStudents)
            {
                if (s.equals(CentralManagement.currentStudent))
                {
                    s.scores.add(newScore);
                    break;
                }
            }
            back(event);
        }
    }

    @FXML
    private void back(ActionEvent event) throws IOException
    {
        CentralManagement.currentProfessor.login(CentralManagement.currentProfessor.getUsername(), CentralManagement.currentProfessor.getPassword(), event);
    }
}
