package Model;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static Model.Main.*;

public class Professor extends Common
{
    public ArrayList<Course> courses = new ArrayList<>();

    private String group;

    public void setGroup(String group)
    {
        this.group = group;
    }

    @Override
    public void editInfo(ActionEvent event) throws IOException
    {
        Parent editProfessor = FXMLLoader.load(getClass().getResource("/View/editProfessor.fxml"));
        Stage editProfessorStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene editProfessorScene = new Scene(editProfessor);
        editProfessorStage.setScene(editProfessorScene);
        editProfessorStage.show();
    }

    @Override
    public void login(String username, String password, ActionEvent event) throws IOException
    {
        Parent professor = FXMLLoader.load(getClass().getResource("/View/professor.fxml"));

        Stage professorStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene professorScene = new Scene(professor);
        professorStage.setScene(professorScene);
        professorStage.show();
    }

    @Override
    public void singUp(Object current, String username, String password, ActionEvent event) throws IOException
    {
        Professor newP = (Professor) current;
        professors.put(newP, username);
        usernamePassword.put(username, password);

        CentralManagement.currentProfessor = newP;

        newP.login(username, password, event);
    }
}
