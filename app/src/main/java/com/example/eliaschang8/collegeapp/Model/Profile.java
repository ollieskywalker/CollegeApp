package com.example.eliaschang8.collegeapp.Model;

import java.util.Date;

/**
 * Created by eliaschang8 on 12/7/16.
 */
public class Profile extends Person {
    private String firstName;
    private String lastName;
    private Date birthday;

    public Profile(Date birthday){
        this.birthday = birthday;
    }

    public Profile(String firstName, String lastName, Date birthday){
        super(firstName, lastName);
        this.birthday = birthday;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
