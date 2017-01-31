package com.example.eliaschang8.collegeapp.Model;

/**
 * Created by eliaschang8 on 12/9/16.
 */
public class Guardian extends Person {
    private int age;
    private String occupation;

    public Guardian(int age, String occupation) {
        this.age = age;
        this.occupation = occupation;
    }

    public Guardian(String firstname, String lastname, int age, String occupation) {
        super(firstname, lastname);
        this.age = age;
        this.occupation = occupation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
