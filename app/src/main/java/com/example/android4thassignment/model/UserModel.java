package com.example.android4thassignment.model;

public class UserModel {

    private int userId;
    private String userFname;
    private String userLname;
    private  String userName;
    private String password;

    public UserModel(int userId, String userFname, String userLname, String userName, String password) {
        this.userId = userId;
        this.userFname = userFname;
        this.userLname = userLname;
        this.userName = userName;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserFname() {
        return userFname;
    }

    public void setUserFname(String userFname) {
        this.userFname = userFname;
    }

    public String getUserLname() {
        return userLname;
    }

    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
