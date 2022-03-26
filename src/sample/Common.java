package sample;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class Common
{
    private String name;
    private String lastName;
    private String faculty;

    protected void setName(String name)
    {
        this.name = name;
    }

    protected void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    protected void setFaculty(String faculty)
    {
        this.faculty = faculty;
    }

    protected static void quit()
    {
        System.exit(0);
    }

    protected static void editInfo()
    {

    }

    protected static void login(String username, int password)
    {
        Subject currentUser = SecurityUtils.getSubject();
    }

    protected static void singUp()
    {

    }

    protected static void logOut()
    {

    }
}
