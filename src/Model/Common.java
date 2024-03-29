package Model;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static Model.Main.usernamePassword;

public abstract class Common
{
    private String name;
    private String lastName;
    private String faculty;
    private String username;
    private String password;

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setFaculty(String faculty)
    {
        this.faculty = faculty;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public static void quit()
    {
        System.exit(0);
    }

    public static void logOut(ActionEvent event) throws IOException
    {
        Parent login = FXMLLoader.load(Common.class.getResource("/View/login.fxml"));
        Stage loginStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene loginScene = new Scene(login);
        loginStage.setScene(loginScene);
        loginStage.show();
    }

    public static boolean signUpAllowed(String username)
    {
        return usernamePassword.containsKey(username);
    }

    protected abstract void editInfo(ActionEvent event) throws IOException;

    public static Boolean passwordCorrect(String username, String password)
    {

        return usernamePassword.get(username).equals(password);
    }

    public static Boolean usernameExistence(String username)
    {
        return usernamePassword.containsKey(username);
    }

    protected abstract void login(String username, String password, ActionEvent event) throws IOException;

    protected abstract void singUp(Object current, String username, String password, ActionEvent event) throws IOException;
}
