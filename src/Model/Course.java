package Model;

import java.util.ArrayList;

public class Course
{
    ArrayList<Student> registeredStudents = new ArrayList<>();
    String professor;

    String name;

    int units;

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setProfessor(String professor)
    {
        this.professor = professor;
    }

    public String getProfessor()
    {
        return professor;
    }

    public void setUnits(int units)
    {
        this.units = units;
    }


}
