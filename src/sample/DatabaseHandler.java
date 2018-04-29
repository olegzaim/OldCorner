package sample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
public class DatabaseHandler extends Confings {
    Connection dbConnection;


    public Connection getDbConnection()
            throws ClassNotFoundException,SQLException {
        String connectionString = "jdbc:mysql://" +dbHost+":"+dbPort+"/"+dbName;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection=DriverManager.getConnection(connectionString,
                dbUser,dbPass);
        return dbConnection;
    }
    //sql запросы внизу
    public void signUpUser(User user){
        String insert = "INSERT INTO "+Const.USER_TABLE+"("+
                Const.USERS_NAME+","+Const.USERS_SURNAME+","+Const.USERS_AGE+","+Const.USERS_LOCATION+","+
                Const.USERS_GENDER+","+Const.USERS_USERNAME+","+Const.USERS_PASSWORD+")"+"VALUES(?,?,?,?,?,?,?)";


        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(insert);
            prSt.setString(1,user.getName());
            prSt.setString(2,user.getSurname());
            prSt.setString(3,user.getAge());
            prSt.setString(4,user.getLocation());
            prSt.setString(5,user.getGender());
            prSt.setString(6,user.getUserName());
            prSt.setString(7,user.getPassword());

            prSt.executeUpdate();//заносим в базуданных
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //массив из все тех значений пользователя - это для авторизации
    public ResultSet getUser(User user) {
        ResultSet resSet = null;
        //коммент к запросу  выбрать все из табилцы юзер где поле юзернэйм ранво чему либо
        String select = "SELECT * FROM "+Const.USER_TABLE+" WHERE "+Const.USERS_USERNAME+" =? AND "+Const.USERS_PASSWORD +" =? ";
        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(select);
            prSt.setString(1,user.getUserName());
            prSt.setString(2,user.getPassword());

           resSet= prSt.executeQuery(); //получаем из базыданных
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }
}
