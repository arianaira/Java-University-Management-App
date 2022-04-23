package Model;

import java.util.ArrayList;

public class Semester
{
    public ArrayList<Course> courses = new ArrayList<>();

    public void newCourse()
    {
        Course newCourse = new Course();
        courses.add(newCourse);
    }
}
