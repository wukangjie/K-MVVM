package com.example.appsimple.ui.data_lib.green_dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class UserData {
    private String name;
    private String content;
    @Generated(hash = 1020082416)
    public UserData(String name, String content) {
        this.name = name;
        this.content = content;
    }
    @Generated(hash = 1838565001)
    public UserData() {
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
   
}