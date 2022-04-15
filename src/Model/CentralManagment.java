package Model;

import java.awt.*;
import java.util.ArrayList;

public class CentralManagment
{
    public static Boolean newSemesterExists = false;
    public static ArrayList<Semester> semesters = new ArrayList<>();
    public static ArrayList<Faculty> faculties = new ArrayList<>();

    public static void makeFaculty(String facultyName)
    {
        //Main.usernamePassword.put("icontrolyouall", "control34");
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

    public Boolean newCourse(Semester newSemester)
    {
        Course newCourse = new Course();
        newSemester.courses.add(newCourse);
        return false;
    }


    protected void editInfo()
    {

    }


    protected void login(String username, String password)
    {

    }


    protected void singUp(TextField username, TextField password)
    {

    }
}
