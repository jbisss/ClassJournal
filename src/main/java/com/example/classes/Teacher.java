package com.example.classes;

public class Teacher {
    private final String name;
    private final String login;
    private final String password;
    public Teacher(String name, String login, String password){
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
