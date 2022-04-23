package Model;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.Object;
import java.util.ArrayList;

import static Model.Main.*;

public class Student extends Common
{
    public ArrayList<Course> registeredCourses = new ArrayList<>();

    public ArrayList<Score> scores = new ArrayList<>();

    private String major;
    private String studentID;
    private int entryYear;

    public Boolean registerStatus = false;

    public void setMajor(String major)
    {
        this.major = major;
    }

    public void setStudentID()
    {
        this.studentID = Integer.toString(Main.students.size() + 1);
    }

    public void setEntryYear(int entryYear)
    {
        this.entryYear = entryYear;
    }

    public void register(Course course, Student current)
    {
        for (Course c : CentralManagement.semesters.get(CentralManagement.semesters.size() - 1).courses)
        {
            if (c.equals(course))
            {
                c.registeredStudents.add(current);
                break;
            }
        }
        current.registeredCourses.add(course);
        CentralManagement.currentCourse = course;
    }

    public void scores()
    {

    }

    @Override
    public void editInfo(ActionEvent event) throws IOException
    {
        Parent editStudent = FXMLLoader.load(getClass().getResource("/View/editStudent.fxml"));
        Stage editStudentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene editStudentScene = new Scene(editStudent);
        editStudentStage.setScene(editStudentScene);
        editStudentStage.show();
    }

    @Override
    public void login(String username, String password, ActionEvent event) throws IOException
    {
        Parent student = FXMLLoader.load(getClass().getResource("/View/Student.fxml"));
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

        CentralManagement.currentStudent = newS;

        newS.login(username, password, event);
    }
}
