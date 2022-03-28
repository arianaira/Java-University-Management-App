package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.Object;

import static sample.Main.*;

public class Student extends Common
{
    private String major;
    private String studentID;
    private int entryYear;

    public void setMajor(String major)
    {
        this.major = major;
    }

    public void setStudentID(String studentID)
    {
        this.studentID = studentID;
    }

    public void setEntryYear(int entryYear)
    {
        this.entryYear = entryYear;
    }

    public Boolean registerStatus()
    {
        if (CentralManagment.newSemester())
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
    protected void login(String username, String password, ActionEvent event) throws IOException
    {
        Parent student = FXMLLoader.load(getClass().getResource("Student.fxml"));

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
