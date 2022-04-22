package Model;

public class Score
{
    private String score;

    private String courseName;

    public Score(String score, String courseName)
    {
        this.score = score;
        this.courseName = courseName;
    }

    public String getScore()
    {
        return score;
    }

    public String getCourseName()
    {
        return courseName;
    }
}
