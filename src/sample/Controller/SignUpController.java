package sample.Controller;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.DatabaseHandler;
import sample.User;


public class SignUpController  {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField password_filed;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField signUpName;

    @FXML
    private TextField signUpSurname;

    @FXML
    private TextField signUpAge;

    @FXML
    private TextField signUpLocation;

    @FXML
    private TextField loggin_field;

    @FXML
    private RadioButton signUpRadioButtonMan;

    @FXML
    private RadioButton signUpRadioButtonWoman;

    @FXML
    private Button signUpButtonBack;

    @FXML
    void initialize() {

        signUpButton.setOnAction(event -> {
            signUpNewUser();

        });
    }
    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String name = signUpName.getText();
        String surname=signUpSurname.getText();
        String age=signUpAge.getText();
        String location=signUpLocation.getText();
        String username=loggin_field.getText();
        String password=password_filed.getText();

        String gender="";
        if(signUpRadioButtonMan.isSelected())
            gender="Man";
        else
            gender="Woman";
        User user = new User(name,surname,age,location,gender,username,password);

        dbHandler.signUpUser(user);
    }

}