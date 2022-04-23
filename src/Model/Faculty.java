package Model;

import java.util.ArrayList;

public class Faculty
{
    public ArrayList<Student> students = new ArrayList<>();
    public ArrayList<Professor> professors = new ArrayList<>();
    public ArrayList<Course> courses = new ArrayList<>();

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
