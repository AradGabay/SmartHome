package com.example.AlphaVersion;

public class User {
    private String name, email, phone, uid;
    private long serialnum;
    private Boolean active;

    public User(){}
    public User(String name, String email, String phone, String uid, long serialnum, Boolean active) {
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.uid=uid;
        this.serialnum=serialnum;
        this.active=active;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email=email;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone=phone;
    }

    public String getUid() { return uid; }
    public void setUid(String uid) {
        this.uid=uid;
    }

    public long getSerialnum() { return serialnum; }
    public void setSerialnum(long serialnum) {
        this.serialnum=serialnum;
    }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) {
        this.active=active;
    }
}
