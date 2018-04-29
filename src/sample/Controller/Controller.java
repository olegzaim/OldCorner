package sample.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DatabaseHandler;
import sample.User;
import sample.animations.Shake;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loggin_field;

    @FXML
    private PasswordField password_filed;

    @FXML
    private Button authSignButton;

    @FXML
    private Button loginSignUpButton;

    @FXML
    void initialize() {
        authSignButton.setOnAction(event -> {
            String loginText=loggin_field.getText().trim();
            String loginPassword=password_filed.getText().trim();
            if(!loginText.equals("")&&!loginPassword.equals("")){
                loginUser(loginText,loginPassword);
            }else
                System.out.println("Login and password is empty");
        });
        loginSignUpButton.setOnAction( event -> {
            openNewScene("/sample/View/signUp.fxml");
        });


    }

    private void loginUser(String loginText, String loginPassword) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user= new User();
        user.setUserName(loginText);
        user.setPassword(loginPassword);
         ResultSet result = dbHandler.getUser(user);

         int counter=0;
         try {
             while (result.next()) {
                 counter++;
             }
         }catch (SQLException e){
             e.printStackTrace();
         }
             if(counter>=1) {
             openNewScene("/sample/View/app.fxml");
                 }
             else{
                 Shake userLoginAnim=new Shake(loggin_field);
                 Shake userPasswordAnim=new Shake(password_filed);
                 userLoginAnim.playAnim();
                 userPasswordAnim.playAnim();
             }

    }
   public void openNewScene(String window){
        loginSignUpButton.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();///отображаем нужное нам окно при нажатии кнопки регист перейти на новое окно
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();

    }

}

