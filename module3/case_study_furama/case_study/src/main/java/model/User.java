package model;

public class User {
    private String userName;
    private String passwordUser;

    public User() {
    }

    public User(String userName, String passwordUser) {
        this.userName = userName;
        this.passwordUser = passwordUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }
}
