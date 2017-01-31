package com.example.eliaschang8.collegeapp.Model;

/**
 * Created by eliaschang8 on 12/9/16.
 */
abstract class Person {
    protected String firstname, lastname;

    public Person(){
        firstname="Ollie";
        lastname="Chang";
    }

    public Person(String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
