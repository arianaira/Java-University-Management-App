package Model;

import java.util.ArrayList;

public class Course
{
    public ArrayList<Student> registeredStudents = new ArrayList<>();

    String professor;

    String name;

    String units;

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

    public void setUnits(String units)
    {
        this.units = units;
    }

    public String getUnits()
    {
        return units;
    }

    public Professor findProfessor(String name)
    {
        Professor output = null;
        for (Faculty f : CentralManagement.faculties)
        {
            for ( Professor p : f.professors)
            {
                String temp = p.getName() + " " + p.getLastName();
                if (p.equals(temp))
                {
                    output = p;
                }
            }
        }
        return output;
    }
}
