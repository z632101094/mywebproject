package com.mywebprojet.springboot.entity;
 
public class User {
  
    private int id;
    private String name;
    private String userName;
    private String password;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassord() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}