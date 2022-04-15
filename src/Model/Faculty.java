package Model;

import java.util.ArrayList;

public class Faculty
{
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Student> professors = new ArrayList<>();
    ArrayList<Student> courses = new ArrayList<>();

    String facultyName;

    public void setFacultyName(String facultyName)
    {
        this.facultyName = facultyName;
    }

    public String getFacultyName()
    {
        return facultyName;
    }
}
