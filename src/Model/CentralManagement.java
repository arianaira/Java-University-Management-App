package Model;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class CentralManagement
{
    public static Boolean newSemesterExists = false;
    public static ArrayList<Semester> semesters = new ArrayList<>();
    public static ArrayList<Faculty> faculties = new ArrayList<>();

    public static Student currentStudent = new Student();
    public static Professor currentProfessor = new Professor();
    public static Course currentCourse = new Course();

    public static String username;
    public static String password;

    public static void makeFaculty(String facultyName)
    {
        Faculty newFaculty = new Faculty();
        newFaculty.setFacultyName(facultyName);
        faculties.add(newFaculty);
    }

    public static void newSemester()
    {
        Semester newSemester = new Semester();
        semesters.add(newSemester);
        newSemesterExists = true;
    }

    public static void editInfo(ActionEvent event) throws IOException
    {
        Parent editCentral = FXMLLoader.load(CentralManagement.class.getResource("/View/editCentralManagement.fxml"));
        Stage editCentralStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene editCentralScene = new Scene(editCentral);
        editCentralStage.setScene(editCentralScene);
        editCentralStage.show();
    }


    public static void login(String username, String password, ActionEvent event) throws IOException
    {
        Parent central = FXMLLoader.load(CentralManagement.class.getResource("/View/centralManagement.fxml"));
        Stage centralStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene centralScene = new Scene(central);
        centralStage.setScene(centralScene);
        centralStage.show();
    }
}
