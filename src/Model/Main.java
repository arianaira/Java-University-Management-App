package Model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Main extends Application
{
    public static Map<Student, String> students = new HashMap<>();
    public static Map<Professor, String> professors = new HashMap<>();
    public static Map<String, String> usernamePassword = new HashMap<>();

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("/View/login.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        alreadySaved();
        launch(args);
    }

    static void alreadySaved()
    {
        usernamePassword.put("icontrolyouall", "control34");

        CentralManagement.makeFaculty("Math");
        CentralManagement.makeFaculty("Psychology");
        CentralManagement.makeFaculty("Physics");
    }
}
