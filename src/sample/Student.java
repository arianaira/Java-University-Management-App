package sample;

public class Student extends org.apache.shiro.SecurityUtils
{
    private String major;
    private int studentID;
    private int entryYear;

    public void setMajor(String major)
    {
        this.major = major;
    }

    public void setStudentID(int studentID)
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
        if (registerStatus())
        {

        }
    }

    public void scores()
    {

    }

    public void schedule()
    {

    }
}
