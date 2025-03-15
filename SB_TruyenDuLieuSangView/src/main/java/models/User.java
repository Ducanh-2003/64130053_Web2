package models;

import lombok.Getter;

import java.util.Date;

@Getter
public class User {
    private String id;
    private String name;
    private boolean gender;
    private Date dob;

    public User(String id, String name, boolean gender, Date dob) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
    }
}
