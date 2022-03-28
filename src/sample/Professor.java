package sample;
import javafx.event.ActionEvent;

import static sample.Main.*;

public class Professor extends Common
{
    private String group;

    public void setGroup(String group)
    {
        this.group = group;
    }

    public void courses()
    {

    }

    @Override
    protected void editInfo()
    {

    }

    @Override
    protected void login(String username, String password, ActionEvent event)
    {

    }

    @Override
    protected void singUp(Object current, String username, String password, ActionEvent event)
    {
        Professor newP = new Professor();
        professors.put(newP, username);
        usernamePassword.put(username, password);
    }
}
