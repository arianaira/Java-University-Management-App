package Model;
import Controller.ProfessorController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static Model.Main.*;

public class Professor extends Common
{
    private String group;

    public void setGroup(String group)
    {
        this.group = group;
    }

    public void courses()
    {

    }

    @Override
    protected void editInfo()
    {

    }

    @Override
    public void login(String username, String password, ActionEvent event) throws IOException
    {
        Parent professor = FXMLLoader.load(getClass().getResource("/View/professor.fxml"));

        ProfessorController temp = new ProfessorController();
        temp.setUsername(username);

        Stage professorStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene professorScene = new Scene(professor);
        professorStage.setScene(professorScene);
        professorStage.show();
    }

    @Override
    protected void singUp(Object current, String username, String password, ActionEvent event)
    {
        Professor newP = new Professor();
        professors.put(newP, username);
        usernamePassword.put(username, password);
    }
}
