package com.example.eliaschang8.collegeapp.Model;

/**
 * Created by eliaschang8 on 12/9/16.
 */
public class Sibling extends Person {
    private int age;
    private String relationship;

    public Sibling(){
        age = 15;
        relationship = "Bro";
    }

    public Sibling(int age, String relationship) {
        this.age = age;
        this.relationship = relationship;
    }

    public Sibling(String firstname, String lastname, int age, String relationship) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.relationship = relationship;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}
