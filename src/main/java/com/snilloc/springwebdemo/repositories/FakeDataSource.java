package com.snilloc.springwebdemo.repositories;

public class FakeDataSource {

    private String userName;
    private String passWord;
    private String url;

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getUrl() {
        return url;
    }

    public FakeDataSource(String user, String passWord, String url) {
        this.userName = user;
        this.passWord = passWord;
        this.url = url;
    }
}
