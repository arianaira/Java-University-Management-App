package Controller;

import Model.CentralManagement;
import Model.Common;
import Model.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import java.io.IOException;

public class editCentralManagementController
{

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private Label msg;

    @FXML
    private void submit(ActionEvent event) throws IOException
    {
        if (username.getText().trim().equals(""))
        {
            msg.setText("username empty");
        }
        else if (password.getText().trim().equals(""))
        {
            msg.setText("password empty");
        }
        else
        {
            Main.usernamePassword.remove(CentralManagement.username, CentralManagement.password);
            Main.usernamePassword.put(username.getText(), password.getText());
            CentralManagement.username = username.getText();
            CentralManagement.password = password.getText();

            Parent central = FXMLLoader.load(CentralManagement.class.getResource("/View/centralManagement.fxml"));
            Stage centralStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene centralScene = new Scene(central);
            centralStage.setScene(centralScene);
            centralStage.show();
        }
    }

    @FXML
    private void quit(ActionEvent event)
    {
        Common.quit();
    }

    @FXML
    private void logOut(ActionEvent event) throws IOException
    {
        Common.logOut(event);
    }
}
