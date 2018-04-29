package sample;

public class User {
    private String name;
    private String surname;
    private String age;
    private String location;
    private String gender;
    private String username;
    private String password;
    public User(String name,String surname,String age,String location,String gender,String username,String password){
        this.name=name;
        this.surname=surname;
        this.age=age;
        this.location=location;
        this.gender=gender;
        this.username=username;
        this.password=password;

    }

    public User() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAge(){
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
