package Model;

import Controller.StudentController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.Object;

import static Model.Main.*;

public class Student extends Common
{
    private String major;
    private int studentID;
    private int entryYear;

    public void setMajor(String major)
    {
        this.major = major;
    }

    public void setStudentID()
    {
        this.studentID = students.size() + 1;
    }

    public void setEntryYear(int entryYear)
    {
        this.entryYear = entryYear;
    }

    public Boolean registerStatus()
    {
        if (CentralManagment.newSemesterExists)
        {
            return false;
        }
        return true;
    }

    public void register()
    {

    }

    public void scores()
    {

    }

    public void schedule()
    {

    }

    @Override
    protected void editInfo()
    {

    }

    @Override
    public void login(String username, String password, ActionEvent event) throws IOException
    {
        Parent student = FXMLLoader.load(getClass().getResource("/View/Student.fxml"));

        StudentController temp = new StudentController();
        temp.setUsername(username);

        Stage studentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene studentScene = new Scene(student);
        studentStage.setScene(studentScene);
        studentStage.show();
    }

    @Override
    public void singUp(Object current, String username, String password, ActionEvent event) throws IOException
    {
        Student newS = (Student) current;
        students.put(newS, username);
        usernamePassword.put(username, password);

        newS.login(username, password, event);
    }
}
